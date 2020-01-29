package com.sviluppotrilo.trilo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class SendNotification {
    public static Context context;

    public static void init(Context c){
        context = c;
    }
}
