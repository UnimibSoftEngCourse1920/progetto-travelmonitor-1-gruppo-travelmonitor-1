package com.sviluppotrilo.trilo.gui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.sviluppotrilo.trilo.R;

public class PushNotification {
    private PushNotification(){}

    private static Context context;
    private static final String CHANNEL_1_ID = "Channel1";
    private static final String NAME = "Channel1";
    private static final String GROUP = "Group1";
    private static final String TITLE = "Ehi! Trilo ha rilevato qualcosa";
    private static final String DESCRIPTION = "Channel for trilo notification";

    public static void init(Context c){
        context = c;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    NAME,
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription(DESCRIPTION);
            NotificationManager manager = c.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }

    public static void invia(String testoNotifica){
        NotificationManagerCompat notificationManager;
        notificationManager = NotificationManagerCompat.from(context);
        Notification notification1 = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle(TITLE)
                .setContentText(testoNotifica)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup(GROUP)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(testoNotifica))
                .build();
        notificationManager.notify(1, notification1);
    }
}
