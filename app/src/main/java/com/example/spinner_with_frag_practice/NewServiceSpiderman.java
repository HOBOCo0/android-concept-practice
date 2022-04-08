package com.example.spinner_with_frag_practice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class NewServiceSpiderman extends Service {

    private MediaPlayer mMediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mMediaPlayer = MediaPlayer.create(this, R.raw.spidr);

        mMediaPlayer.setLooping(true);

        mMediaPlayer.start();

        return START_STICKY;


    }
    @Override
    public void onDestroy() {
        {
            Log.d("service", "onDestroy called");
        }
        super.onDestroy();

        // stopping the process
        mMediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}