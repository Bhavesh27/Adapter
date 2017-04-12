package com.example.bhavesh.adapter;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by BHAVESH on 07/07/2016.
 */
public class NetworkConnectivity extends Activity {

    BroadcastReceiver broadCastReceiver;
    Button B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.networkconnectivity);
        B = (Button)findViewById(R.id.button4);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadCastReceiver = null;
                checkConnectivity();
            }
        });
    }

    public void checkConnectivity()
    {
        broadCastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
                NetworkInfo info = (NetworkInfo)bundle.getParcelable("networkInfo");

                State state = info.getState();
                if (state == State.CONNECTED)
                {
                    Toast.makeText(getApplicationContext(),"CONNECTED",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"NOT CONNECTED",Toast.LENGTH_LONG).show();
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadCastReceiver,intentFilter);
    }

}
