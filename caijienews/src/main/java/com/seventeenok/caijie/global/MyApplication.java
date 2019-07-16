package com.seventeenok.caijie.global;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.seventeenok.caijie.database.DatabaseManager;
import com.zyw.horrarndoo.sdk.global.GlobalApplication;

/**
 * Created by Horrarndoo on 2017/9/6.
 * <p>
 */

public class MyApplication extends GlobalApplication {
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化屏幕宽高
        getScreenSize();
        DatabaseManager.getInstance().init(this);
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
}
