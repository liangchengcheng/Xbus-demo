package mvp_master.xbus.method;

import java.lang.reflect.Method;

import mvp_master.xbus.MethodInfo;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月21日23:14:08
 * Description:
 */
interface MethodConverter {

    MethodInfo convert(final Method method);
}
