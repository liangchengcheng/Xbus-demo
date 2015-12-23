package mvp_master.xbus.scheduler;

import android.os.Handler;

import java.util.concurrent.Executor;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:    HandlerExecutor
 */
public class HandlerExecutor implements Executor {

    private final Handler handler;

    public  HandlerExecutor(final Handler handler){
        this.handler=handler;
    }

    @Override
    public void execute(Runnable command) {
        handler.post(command);
    }
}
