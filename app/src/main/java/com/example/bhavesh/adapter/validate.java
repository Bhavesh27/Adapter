package com.example.bhavesh.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by BHAVESH on 23/06/2016.
 */
public class validate extends AppCompatActivity {

    Button button;
    EditText E1,E2,E3;
    TextView T;
    //private String first = "",second = "",third = "";
    final String s1 = "PLEASE FILL ALL THE DETAILS";
    final String s2 = "ALL DETAILS FILLED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        button = (Button)findViewById(R.id.button);
        E1 = (EditText)findViewById(R.id.editText);
        E2 = (EditText)findViewById(R.id.editText2);
        E3 = (EditText)findViewById(R.id.editText3);
        T = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = E1.getText().toString();
                String second = E2.getText().toString();
                String third = E3.getText().toString();

                if( second.equalsIgnoreCase("") || third.equalsIgnoreCase("") || first.equalsIgnoreCase("") )
                {
                    //T.setTextSize(32);
                    T.setText(s1);
                }
                else
                {
                    //T.setTextSize(32);
                    T.setText(s2);
                }
            }
        });
    }
}
