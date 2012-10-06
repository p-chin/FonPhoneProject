package com.adamrocker.android.test.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.media.MediaPlayer;


public class Activity0 extends Activity {
	 private MediaPlayer bgMusic;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0);

        bgMusic = MediaPlayer.create(this, R.raw.gamestart);


        Button nextBtn = (Button)findViewById(R.id.next_bt);
        nextBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {

				MediaPlayer mp;
		        mp = bgMusic;
		        mp.seekTo(0);
		        mp.start();
				Intent it =new Intent();
				it.setClass(Activity0.this, Activity1.class);
				startActivity(it);
			}});
    }
}