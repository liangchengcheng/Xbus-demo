package mvp_master.xbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mvp_master.xbus.annotation.BusReceiver;
import mvp_master.xbus.utils.Helper;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:   Bus
 */
public class Bus {

    private Map<Object,List<Method>> mMethodMap=new HashMap<>();

    public enum EventMode {

        Sender, Main, Thread
    }

    public void register(final Object target){
        List<Method> methods= Helper.findAnnotatedMethods(target.getClass(), BusReceiver.class);
        if (methods==null||methods.isEmpty()){
            return;
        }
        mMethodMap.put(target,methods);
    }

    public void unregister(final Object target){
        mMethodMap.remove(target);
    }

    public void post(Object event){
        final Class<?> eventClass=event.getClass();
        for (Map.Entry<Object,List<Method>> entry :mMethodMap.entrySet()){
            final Object target=entry.getKey();
            final List<Method> methods=entry.getValue();
            if (methods==null || methods.isEmpty()){
                continue;
            }
            for (Method method:methods){
                //要是事件的类型一样的话，就直接调用对应的方法发送事件
                //这里的类型要求的就是精确匹配 不考虑继承
                if (eventClass.equals(method.getParameterTypes()[0])){
                    try {
                        method.invoke(target,event);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
