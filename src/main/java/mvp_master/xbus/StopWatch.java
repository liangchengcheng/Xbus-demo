package mvp_master.xbus;

import android.util.Log;

import java.util.HashMap;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:  StopWatch
 */
public class StopWatch {

    private static final String TAG=StopWatch.class.getSimpleName();
    private String mName;
    private HashMap<String,Long>mTicks;

    public StopWatch(final String name){
        mName=name;
        mTicks=new HashMap<>();
    }

    public void start(String tag){
        mTicks.put(tag,System.nanoTime());
    }

    public void stop(String tag){
        Long start=mTicks.remove(tag);
        if (start!=null){
            long elapsed=(System.nanoTime()-start)/1000000L;
            String message=mName+" "+tag+"elapsed time: "+elapsed+"ms";
            if (elapsed > 100) {
                Log.w(TAG, message);
            } else if (elapsed > 20) {
                Log.i(TAG, message);
            } else if (elapsed > 2) {
                Log.d(TAG, message);
            }
        }
    }
}
