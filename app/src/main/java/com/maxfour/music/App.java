package com.maxfour.music;

import android.app.Application;
import android.os.Build;

import com.maxfour.appthemehelper.ThemeStore;
import com.maxfour.music.appshortcuts.DynamicShortcutManager;


public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        // default theme
        if (!ThemeStore.isConfigured(this, 1)) {
            ThemeStore.editTheme(this)
                    .primaryColorRes(R.color.mariner_blue)
                    .accentColorRes(R.color.red)
                    .commit();
        }

        // Set up dynamic shortcuts
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            new DynamicShortcutManager(this).initDynamicShortcuts();
        }
    }


    public static App getInstance() {
        return app;
    }

}
