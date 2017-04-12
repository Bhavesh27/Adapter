package com.example.bhavesh.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by BHAVESH on 05/07/2016.
 */
public class phone extends Activity {

    Button B;
    ImageView I;
    private AudioManager mAudioManager;
    boolean mPhoneIsSilent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);
        //B = (Button)findViewById(R.id.button2);
        //I = (ImageView)findViewById(R.id.imageView);
        mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);

        checkIfPhoneIsSilent();
        setButtonClickListener();

    }
    /**
     * Checks to see if the phone is currently in silent mode.
     **/
    private void checkIfPhoneIsSilent() {
        int ringerMode = mAudioManager.getRingerMode();
        if (ringerMode == AudioManager.RINGER_MODE_SILENT) {
            mPhoneIsSilent = true;
        } else {
            mPhoneIsSilent = false;
        }
    }

    private void setButtonClickListener() {
        Button toggleButton = (Button)findViewById(R.id.button2);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mPhoneIsSilent) {
// Change back to normal mode
                    mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    mPhoneIsSilent = false;
                } else {
// Change to silent mode
                    mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    mPhoneIsSilent = true;
                }
// Now toggle the UI again
                toggleUi();
            }
        });
    }
    /**
     * Toggles the UI images from silent to normal and vice versa.
     */
    private void toggleUi() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Drawable newPhoneImage;
        if (mPhoneIsSilent) {
            newPhoneImage =
                    getResources().getDrawable(R.drawable.image_preview);
        } else {
            newPhoneImage =
                    getResources().getDrawable(R.drawable.unnamed);
        }
        imageView.setImageDrawable(newPhoneImage);
    }
    @Override
    protected void onResume() {
        super.onResume();
        checkIfPhoneIsSilent();
        toggleUi();
    }



}
