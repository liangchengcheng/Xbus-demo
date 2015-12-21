package mvp_master.xbus.method;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import mvp_master.xbus.Bus;
import mvp_master.xbus.MethodInfo;
import mvp_master.xbus.annotation.BusReceiver;
import mvp_master.xbus.exception.BusException;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:
 */
public class MethodHelper {

    public static boolean shouldSkipClass(final Class<?> clazz) {
        if (clazz == null || Object.class.equals(clazz)) {
            return true;
        }
        final String clsName = clazz.getName();
        return clsName.startsWith("java.")
                || clsName.startsWith("javax.")
                || clsName.startsWith("android.")
                || clsName.startsWith("com.android.");
    }

    public static boolean isValidMethod(final Method method) {
        if (!Modifier.isPublic(method.getModifiers())) {
            throw new BusException("event method: " + getMethodSignature(method)
                    + " must be public!");
        }
        if (Modifier.isStatic(method.getModifiers())) {
            throw new BusException("event method: " + getMethodSignature(method) +
                    " must not be static!");
        }
        if (method.getParameterTypes().length != 1) {
            throw new BusException("event method: " + getMethodSignature(method)
                    + " must have exact one parameter!");
        }
        return !Modifier.isVolatile(method.getModifiers());
    }

    public static Set<MethodInfo> findSubscriberMethods(
            final Class<?> targetClass, MethodConverter converter) {
        Class<?> clazz = targetClass;
        final Set<MethodInfo> methods = new HashSet<MethodInfo>();
        while (!shouldSkipClass(clazz)) {
            final Method[] clsMethods = clazz.getDeclaredMethods();
            for (final Method method : clsMethods) {
                final MethodInfo methodInfo = converter.convert(method);
                if (methodInfo != null) {
                    methods.add(methodInfo);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return methods;
    }

    public static Set<MethodInfo> findSubscriberMethodsByAnnotation(
            final Class<?> targetClass) {
        final MethodConverter converter = new MethodConverter() {
            @Override
            public MethodInfo convert(final Method method) {
                final BusReceiver annotation = method.getAnnotation(BusReceiver.class);
                if (annotation == null) {
                    return null;
                }
                if (!isValidMethod(method)) {
                    return null;
                }
                return new MethodInfo(method, targetClass, annotation.mode());
            }
        };
        return findSubscriberMethods(targetClass, converter);
    }

    public static Set<MethodInfo> findSubscriberMethodsByName(
            final Class<?> targetClass, final String name) {
        final MethodConverter converter = new MethodConverter() {
            @Override
            public MethodInfo convert(final Method method) {
                if (!method.getName().equals(name)) {
                    return null;
                }
                if (!isValidMethod(method)) {
                    return null;
                }
                return new MethodInfo(method, targetClass, Bus.EventMode.Main);
            }
        };
        return findSubscriberMethods(targetClass, converter);
    }

    private static String getMethodSignature(final Method method) {
        return method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
    }

}
