package com.example.user.navigationdrawersample;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MonApp extends Application {

    public static final String exampleNotification ="Example Notification";
    @Override
    public void onCreate(){
        super.onCreate();
        createNotifcationExample();
    }

    private void createNotifcationExample(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notif =new NotificationChannel(
                    exampleNotification,
                    "ExampleNotification",
                    NotificationManager.IMPORTANCE_HIGH
            );

            notif.setDescription("this is an example of Notification");



            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notif);

        }
    }
}
