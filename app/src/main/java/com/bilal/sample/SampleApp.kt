package com.bilal.sample

import android.app.Application
import android.widget.Toast
import com.onesignal.OneSignal

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .setNotificationOpenedHandler {
                    Toast.makeText(baseContext,"Notification Opened",Toast.LENGTH_SHORT).show()
                }
                .setNotificationReceivedHandler {
                    Toast.makeText(baseContext,"Notification Received",Toast.LENGTH_SHORT).show()
                }
                .init()
    }

}