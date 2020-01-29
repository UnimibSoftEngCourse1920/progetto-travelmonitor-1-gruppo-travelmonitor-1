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
        PushNotification.invia(testoNotifica);
    }
}
