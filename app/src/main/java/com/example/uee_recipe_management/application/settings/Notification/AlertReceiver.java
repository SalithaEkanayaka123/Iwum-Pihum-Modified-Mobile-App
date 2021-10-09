package com.example.uee_recipe_management.application.settings.Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());

        //Play the alarm -MediaPlayer
//        mediaplayer = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
//        mediaplayer.start();
//        System.out.println("Method running ------------------------------------------");
//        Toast.makeText(context, "Alarm Method is triggering", Toast.LENGTH_SHORT).show();
    }
}
