package bm.it.mobile.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

public class BMNotificationsUtils {
    private final String TAG = BMNotificationsUtils.class.getSimpleName();

    private NotificationManager mNotificationManager;
    private Notification.Builder mNBuilder;
    private Notification mNotification;
    private int NOTIFICATION_LOAD_ID = 100;

    private String mTitle;
    private int mSmallIcon;

    public BMNotificationsUtils(String title, int smallIcon) {
        this.mTitle = title;
        this.mSmallIcon = smallIcon;
    }

    public void loadNotification(Context context, String message) {
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNBuilder = new Notification.Builder(context.getApplicationContext());
        mNBuilder.setContentTitle(mTitle)
                .setContentText(message)
                .setSmallIcon(mSmallIcon);

        mNotification = mNBuilder.build();
        mNotificationManager.notify(NOTIFICATION_LOAD_ID, mNotification);
        Log.d(TAG, "Exibiu a notificacao");
    }

    public void updateNotification(Context context, String text) {
        mNBuilder.setContentText(text);

        mNotification = mNBuilder.build();
        mNotificationManager.notify(NOTIFICATION_LOAD_ID, mNotification);
    }

    public Notification getNotification() {
        return mNotification;
    }
}
