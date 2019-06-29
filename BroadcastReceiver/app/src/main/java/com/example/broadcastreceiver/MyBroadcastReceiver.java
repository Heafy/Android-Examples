package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    /**
     * Method to execute when the Alarm is received
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("DEBUG", "Alarm received");
        Toast.makeText(context, "Alarm received", Toast.LENGTH_SHORT).show();
    }
}