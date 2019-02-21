package cn.dss.android;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import timber.log.Timber;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化Utils，项目有大量地方使用它，第一个初始化
        Utils.init(this);

        // setup timber
        Timber.plant(new Timber.DebugTree() {
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ":" + element.getLineNumber();
            }
        });
    }
}