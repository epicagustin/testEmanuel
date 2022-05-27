package com.emanuel.testsessionemanuel.base

import android.app.PendingIntent
import android.app.PendingIntent.CanceledException
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.emanuel.testsessionemanuel.features.login.LoginActivity


class AlarmBroadcastReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val i = Intent(context, LoginActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context, 0, i, 0)
        try {
            pendingIntent.send(context, 666, i)
        } catch (e: CanceledException) {
            e.printStackTrace()
        }
    }
}