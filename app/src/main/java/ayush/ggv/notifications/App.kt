package ayush.ggv.notifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App  : Application(){
    override fun onCreate() {
        super.onCreate()
        val counterChannel = NotificationChannel(
            "Counter_Channel",
            "Counter Channel",
              NotificationManager.IMPORTANCE_LOW
        )
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(counterChannel)
    }

}



