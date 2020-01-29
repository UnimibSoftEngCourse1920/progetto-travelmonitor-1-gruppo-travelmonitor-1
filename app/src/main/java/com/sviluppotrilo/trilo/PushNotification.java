package com.sviluppotrilo.trilo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class PushNotification {
    public static Context context;
    private static String CHANNEL_1_ID = "channel1";

    public static void init(Context c){
        context = c;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            NotificationManager manager = c.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }
}
