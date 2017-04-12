package com.example.bhavesh.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by BHAVESH on 06/07/2016.
 */
public class BroadCastReceiver extends Activity {

    IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);

    @Override
    protected void onPause() {
        this.unregisterReceiver(broadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        this.registerReceiver(broadcastReceiver,filter);
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getApplicationContext(),"TIME CHANGED",Toast.LENGTH_LONG).show();
        }
    };
}
