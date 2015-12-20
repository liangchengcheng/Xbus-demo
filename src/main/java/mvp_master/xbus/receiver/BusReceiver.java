package mvp_master.xbus.receiver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:    BusReceiver
 */
@Target(ElementType.METHOD)//表示这个注解适用于方法
@Retention(RetentionPolicy.RUNTIME)//标识这个注解需要保存到运行的时候
public @interface BusReceiver {
}
