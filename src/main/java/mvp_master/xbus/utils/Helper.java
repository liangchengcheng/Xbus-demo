package mvp_master.xbus.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:
 */
public class Helper {

    /**
     * 获取所有的方法
     * @param type 类
     * @param annotation annotation
     * @return List<Method>
     */
    public static List<Method> findAnnotatedMethods(final  Class<?> type, final Class<? extends Annotation> annotation){
        final  List<Method> methods=new ArrayList<>();
        Method []ms=type.getDeclaredMethods();
        for (Method method:ms){
            if (Modifier.isStatic(method.getModifiers())){
                continue;
            }
            if (!Modifier.isPublic(method.getModifiers())){
                continue;
            }
            if (method.getParameterTypes().length!=-1){
                continue;
            }
            if (!method.isAnnotationPresent(annotation)){
                continue;
            }
            methods.add(method);
        }
        return methods;
    }
}
