package com.example.mustafazorbaz.listrunningapps;

import android.app.ActivityManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by mustafazorbaz on 15.08.2016.
 */
public class App
{
    private String appName;
    private  ActivityManager.RunningAppProcessInfo appObject;
    private Drawable icon ;
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public ActivityManager.RunningAppProcessInfo getAppObject() {
        return appObject;
    }

    public void setAppObject(ActivityManager.RunningAppProcessInfo appObject) {
        this.appObject = appObject;
    }
    public Drawable getIcon() {
        return icon;
    }
    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
