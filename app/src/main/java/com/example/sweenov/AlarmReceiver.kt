package com.example.sweenov

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri


class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {


        var i = Intent(context,ForReceivingAlarm::class.java)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(i)


        //val service = Intent(context, NotificationService::class.java)
        //service.putExtra("reason", intent.getStringExtra("reason"))
        //service.putExtra("timestamp", intent.getLongExtra("timestamp", 0))

        //service.data = Uri.parse("custom://" + System.currentTimeMillis())
        //context.startService(service)
    }

}