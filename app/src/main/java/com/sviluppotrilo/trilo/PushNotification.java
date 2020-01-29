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
    private static final String CHANNEL_1_ID = "channel1";
    private static final String title1 = "Ehi !! Trilo ha rilevato qualcosa !";
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

    public static void invia(String testoNotifica){
        NotificationManagerCompat notificationManager;
        notificationManager = NotificationManagerCompat.from(context);
        String CHANNEL_1_ID = "channel1";
        Notification notification1 = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo_black)
                .setContentTitle(title1)
                .setContentText(testoNotifica)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .build();
        notificationManager.notify(1, notification1);
    }
}
