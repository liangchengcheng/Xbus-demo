package mvp_master.xbus.scheduler;

import android.os.Handler;
import android.os.Looper;
import mvp_master.xbus.Bus;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月23日13:25:21
 * Description:
 */
public final class Schedulers {

    public static Scheduler sender(final Bus bus) {
        return new SenderScheduler(bus);
    }

    public static Scheduler main(final Bus bus) {
        return new HandlerScheduler(bus, new Handler(Looper.getMainLooper()));
    }

    public static Scheduler thread(final Bus bus) {
        return new ExecutorScheduler(bus);
    }
}
