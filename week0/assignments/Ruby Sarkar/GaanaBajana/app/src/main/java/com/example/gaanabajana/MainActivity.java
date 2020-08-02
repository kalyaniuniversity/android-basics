package com.example.gaanabajana;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button play,pause,stop;
    MediaPlayer mediaplayer;
    int currentpausepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=(Button) findViewById(R.id.btn_play);
        pause=(Button) findViewById(R.id.btn_pause);
        stop=(Button) findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play:
                if(mediaplayer==null){
                mediaplayer=MediaPlayer.create(getApplicationContext(),R.raw.dhating);
                mediaplayer.start();
                }
                else if(!mediaplayer.isPlaying()){
                    mediaplayer.seekTo(currentpausepos);
                    mediaplayer.start();
                }
                break;

            case R.id.btn_pause:
                if(mediaplayer!=null){
                    mediaplayer.pause();
                    currentpausepos=mediaplayer.getCurrentPosition();
                }
                break;

            case R.id.btn_stop:
                if(mediaplayer!=null){
                mediaplayer.stop();
                mediaplayer=null;}
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}