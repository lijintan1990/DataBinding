package tsou.cn.databinding;

import android.app.Application;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class BaseApplication extends Application{
    /**
     * 上下文
     */
    private static BaseApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
