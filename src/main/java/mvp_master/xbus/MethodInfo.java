package mvp_master.xbus;

import java.lang.reflect.Method;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:    MethodInfo
 */
public class MethodInfo {

    public final Method method;
    public final Class<?> targetType;
    public final Class<?>eventType;
    public final String name;
    public final Bus.EventMode mode;

    public MethodInfo(final Method method,final Class<?> targetClass,final Bus.EventMode mode){
        this.method=method;
        this.targetType=targetClass;
        this.eventType=method.getParameterTypes()[0];
        this.mode=mode;
        this.name = targetType.getName() + "." + method.getName()
                + "(" + eventType.getName() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this==o)return true;
        if (o==null||getClass()!=o.getClass())return false;
        final  MethodInfo that= (MethodInfo) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
