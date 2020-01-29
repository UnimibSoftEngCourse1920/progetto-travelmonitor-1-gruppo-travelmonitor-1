package com.sviluppotrilo.trilo.Domain;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.SendNotification;

public abstract class Notifica {
    String testoNotifica;

    public void invia(){
        Context context = SendNotification.context;
        NotificationManagerCompat notificationManager;
        notificationManager = NotificationManagerCompat.from(context);


        String title1 = "Ehi !! Trilo ha una cattiva notizia per te!";
        String message1 = testoNotifica;
        String CHANNEL_1_ID = "channel1";
        Notification notification1 = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo_black)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .build();
        notificationManager.notify(1, notification1);
    }
}
