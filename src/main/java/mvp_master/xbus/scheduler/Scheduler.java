package mvp_master.xbus.scheduler;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:   Scheduler
 */
public interface Scheduler {

    void post(Runnable runnable);
}
