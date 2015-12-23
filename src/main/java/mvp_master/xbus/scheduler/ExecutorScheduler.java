package mvp_master.xbus.scheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mvp_master.xbus.Bus;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:   ExecutorScheduler
 */
public class ExecutorScheduler implements  Scheduler {

    private Bus mBus;
    private Executor mExecutor;

    public ExecutorScheduler(final Bus bus){
        this.mBus=bus;
        this.mExecutor= Executors.newCachedThreadPool();
    }

    @Override
    public void post(Runnable runnable) {
        mExecutor.execute(runnable);
    }
}
