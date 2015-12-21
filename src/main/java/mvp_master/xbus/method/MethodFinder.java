package mvp_master.xbus.method;

import java.util.Set;

import mvp_master.xbus.Bus;
import mvp_master.xbus.MethodInfo;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:    MethodFinder
 */
public interface MethodFinder {
    Set<MethodInfo> find(final Bus bus, final Class<?> targetClass);
}
