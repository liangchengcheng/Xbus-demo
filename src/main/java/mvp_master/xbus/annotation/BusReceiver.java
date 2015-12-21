package mvp_master.xbus.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import mvp_master.xbus.Bus;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:  标识一个方法为事件接收器方法
 * 同时这个方法需要满足条件：
 * public/非static/一个参数/无返回值
 */
@Target(ElementType.METHOD)//表示这个注解适用于方法
@Retention(RetentionPolicy.RUNTIME)//标识这个注解需要保存到运行的时候
public @interface BusReceiver {
    Bus.EventMode mode() default Bus.EventMode.Main;
}
