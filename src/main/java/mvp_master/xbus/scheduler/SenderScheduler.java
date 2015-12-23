package mvp_master.xbus.scheduler;

import mvp_master.xbus.Bus;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:    SenderScheduler
 */
public class SenderScheduler implements Scheduler{
    private Bus mbus;

    public SenderScheduler(final Bus bus){
        this.mbus=bus;
    }

    @Override
    public void post(Runnable runnable) {
        runnable.run();
    }
}
