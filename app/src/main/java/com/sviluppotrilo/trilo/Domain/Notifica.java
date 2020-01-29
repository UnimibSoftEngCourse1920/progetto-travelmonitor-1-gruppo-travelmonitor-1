package com.sviluppotrilo.trilo.Domain;

import android.app.Notification;
import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.PushNotification;

public abstract class Notifica {
    String testoNotifica;

    public void invia(){
        Context context = PushNotification.context;
        NotificationManagerCompat notificationManager;
        notificationManager = NotificationManagerCompat.from(context);


        String title1 = "Ehi !! Trilo ha una cattiva notizia per te!";
        String message1 = testoNotifica;
        String CHANNEL_1_ID = "channel1";
        Notification notification1 = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .build();
        notificationManager.notify(1, notification1);
    }
}
