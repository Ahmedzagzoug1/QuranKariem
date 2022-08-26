package com.zagzoug.qourankariem;

import android.app.Notification;
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

    @Override
    public void onReceive(Context context, Intent intent) {
       MediaPlayer mediaPlayer= MediaPlayer.create(context,R.raw.splash_sound);
               mediaPlayer .start();
        final Notification.Builder builder = new Notification.Builder(context)


                .setDefaults(Notification.DEFAULT_ALL)

               
                .setContentTitle("المنبه القرانى")
                .setContentText("حان الان موعد قراه القران")
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)

                .setContentIntent(
                        PendingIntent.getActivity(
                                context,
                                0,
                                new Intent(context, QouranPager.class),0));
        Notification.BigTextStyle noBigTextStyle=new Notification.BigTextStyle(builder);

        NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    manager.notify(0,builder.build());
    }



}
