package com.app.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.app.coolweather.service.AutoUpdataService;

public class AutoUpdataReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       Intent i=new Intent(context, AutoUpdataService.class);
        context.startService(i);
    }
}
