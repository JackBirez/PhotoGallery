import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.jack.photogallery.PollService;

/**
 * Created by jack on 16/7/21.
 */
public class NotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "NotificationReceiver";

    @Override
    public void onReceive(Context c, Intent i){
        Log.i(TAG,"received result: " + getResultCode());
        if(getResultCode() != Activity.RESULT_OK){
            return;
        }

        int requestCode = i.getIntExtra(PollService.REQUEST_CODE,0);
        Notification notification = (Notification) i.getParcelableExtra(PollService.NOTIFICATION);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(c);
        notificationManager.notify(requestCode,notification);
    }
}
