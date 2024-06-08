package ayush.ggv.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService

class CounterNotification(
    private val context : Context,
) {

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun counterNotification(counter : Int){

        val flag = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            PendingIntent.FLAG_CANCEL_CURRENT
        else 0

        val intent = Intent(context, MainActivity::class.java)
        val notificationClickPendingIntent = PendingIntent.getActivity(
            context,
            1,
            intent,
            flag
        )


        val notification = NotificationCompat
            .Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_add_alert_24)
            .setContentTitle("Counter")
            .setContentText(counter.toString())
            .setStyle(NotificationCompat.BigTextStyle())
            .setOngoing(true)
            .setContentIntent(notificationClickPendingIntent)
            .addAction(
                R.drawable.baseline_add_alert_24,
                "Start",
                notificationClickPendingIntent
            )
            .build()

        notificationManager.notify(1, notification)


    }
    companion object {
        const val CHANNEL_ID = "Counter_Channel"
    }
}