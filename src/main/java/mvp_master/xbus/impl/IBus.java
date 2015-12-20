package mvp_master.xbus.impl;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:  IBus
 */
public interface IBus {

    /**
     * register event target
     */
    boolean register(Object target);

    /**
     * unregister event target
     */
    boolean unregister(Object target);

    /**
     * post event
     */
    void post(Object event);
}
