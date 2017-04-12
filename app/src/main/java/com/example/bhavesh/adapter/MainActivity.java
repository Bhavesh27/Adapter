package com.example.bhavesh.adapter;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends ListActivity {

    String [] programs = {"validate","phone","BroadCastReceiver","Gesturedetector","NetworkConnectivity"};
    //TextView textView;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)   {
        super.onListItemClick(l, v, position, id);
        String Myclasses = programs[position];
        try
        {
            Class ourClass = Class.forName("com.example.bhavesh.adapter." + Myclasses);
            Intent intent = new Intent(MainActivity.this,ourClass);
            startActivity(intent);
        }
        catch (ClassNotFoundException e)
        {

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //textView = (TextView)findViewById(R.id.textView2) ;
        setListAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,programs));

    }
}
