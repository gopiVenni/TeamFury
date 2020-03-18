package com.gogas.delivery.ui.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;

import androidx.core.app.NotificationCompat;

import com.gogas.delivery.BuildConfig;
import com.gogas.delivery.R;
import com.gogas.delivery.ui.MainActivity;
import com.gogas.delivery.ui.Util.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String title = "";
        try {
            title = remoteMessage.getNotification().getTitle();
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, BuildConfig.APPLICATION_ID)
                    .setContentTitle(title)
                    .setContentText(remoteMessage.getNotification().getBody())
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(new NotificationCompat.BigTextStyle())
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setSmallIcon(R.drawable.cylinder)
                    .setAutoCancel(true);

            // Create an Intent for the activity
            Intent resultIntent = new Intent(this, MainActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addNextIntentWithParentStack(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


            notificationBuilder.setContentIntent(resultPendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0, notificationBuilder.build());
        } catch (Exception e) {
        }

        //send broadcast message
        try {
            Intent i = new Intent(Constants.INTENT_FILTER).putExtra(Constants.INTENT_MESSAGE, title);
            this.sendBroadcast(i);
        } catch (Exception e) {
        }
    }
}