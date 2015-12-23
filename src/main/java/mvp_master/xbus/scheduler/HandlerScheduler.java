package mvp_master.xbus.scheduler;

import android.os.Handler;

import mvp_master.xbus.Bus;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:    HandlerScheduler
 */
public class HandlerScheduler  implements Scheduler{

    private Bus mBus;

    private Handler mHandler;

    public HandlerScheduler(final  Bus bus,final  Handler handler){
        mBus=bus;
        mHandler=handler;
    }
    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
