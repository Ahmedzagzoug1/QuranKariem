package com.zagzoug.qourankariem;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class AlarmReciever extends BroadcastReceiver {

    private static final String CHANNEL_ID = "ALARM_CHANNEL_ID";

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // 1. إنشاء القناة (للنسخ أندرويد 8 فما فوق)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "المنبه القرآني",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("قناة تنبيهات قراءة القرآن");
            manager.createNotificationChannel(channel);
        }

        // 2. إعداد الـ PendingIntent مع الـ Flags الجديدة
        int flags = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M ?
                PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT :
                PendingIntent.FLAG_UPDATE_CURRENT;

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                new Intent(context, QouranPager.class),
                flags
        );

        // 3. بناء الإشعار
        Notification.Builder builder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            builder = new Notification.Builder(context, CHANNEL_ID);
        } else {
            builder = new Notification.Builder(context);
        }

        builder.setContentTitle("المنبه القرآني")
                .setContentText("حان الآن موعد قراءة القرآن")
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                .setAutoCancel(true) // عشان الإشعار يختفي لما تدوس عليه
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent);
manager.notify(1,builder.build());
    }



}
