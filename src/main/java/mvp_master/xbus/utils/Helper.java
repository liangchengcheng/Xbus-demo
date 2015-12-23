package mvp_master.xbus.utils;

import android.os.Looper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:
 */
public class Helper {


    private static void addInterfaces(Set<Class<?>> types, Class<?>[] interfaces) {
        for (Class<?> interfaceClass : interfaces) {
            types.add(interfaceClass);
            addInterfaces(types, interfaceClass.getInterfaces());
        }
    }

    public static Set<Class<?>> findSuperTypes(Class<?> targetClass) {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        Class<?> clazz = targetClass;
        while (clazz != null) {
            classes.add(clazz);
            addInterfaces(classes, clazz.getInterfaces());
            clazz = clazz.getSuperclass();
        }
        return classes;
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void dumpMethod(final Method method) {
        final StringBuilder builder = new StringBuilder();
        builder.append("------------------------------\n");
        builder.append("MethodName: ").append(method.getName()).append("\n");
        builder.append("ParameterTypes:{");
        for (Class<?> cls : method.getParameterTypes()) {
            builder.append(cls.getName()).append(", ");
        }
        builder.append("}\n");
        builder.append("GenericParameterTypes:{");
        for (Type cls : method.getGenericParameterTypes()) {
            builder.append(cls.getClass()).append(", ");
        }
        builder.append("}\n");
        builder.append("TypeParameters:{");
        for (TypeVariable<Method> cls : method.getTypeParameters()) {
            builder.append(cls.getName()).append(", ");
        }
        builder.append("}\n");
        builder.append("DeclaredAnnotations:{");
        for (Annotation cls : method.getDeclaredAnnotations()) {
            builder.append(cls).append(", ");
        }
        builder.append("}\n");
        builder.append("Annotations:{");
        for (Annotation cls : method.getAnnotations()) {
            builder.append(cls).append(", ");
        }
        builder.append("}\n");
        builder.append("ExceptionTypes:{");
        for (Class<?> cls : method.getExceptionTypes()) {
            builder.append(cls.getName()).append(", ");
            ;
        }
        builder.append("}\n");
        builder.append("ReturnType: ").append(method.getReturnType());
        builder.append("\nGenericReturnType: ").append(method.getGenericReturnType());
        builder.append("\nDeclaringClass: ").append(method.getDeclaringClass());
        builder.append("\n");

        System.out.println(builder.toString());
    }
}
