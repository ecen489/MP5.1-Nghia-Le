package com.company.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        ImageView scooby = (ImageView)findViewById(R.id.scoobyImage);
        ImageView fairly = (ImageView)findViewById(R.id.fairlyImage);
        ImageView pokemon = (ImageView)findViewById(R.id.pokemonImage);

        switch(view.getId()) {
            case R.id.song1:
                if(checked) {
                    fairly.setVisibility(View.VISIBLE);
                    pokemon.setVisibility(View.INVISIBLE);
                    scooby.setVisibility(View.INVISIBLE);
                    stopPlaying();
                    mp = MediaPlayer.create(this,R.raw.fairlyoddparents);
                    mp.start();
                }
                break;
            case R.id.song2:
                if(checked) {
                    fairly.setVisibility(View.INVISIBLE);
                    pokemon.setVisibility(View.VISIBLE);
                    scooby.setVisibility(View.INVISIBLE);
                    stopPlaying();
                    mp = MediaPlayer.create(this,R.raw.pokemon);
                    mp.start();
                }
                break;
            case R.id.song3:
                if(checked) {
                    fairly.setVisibility(View.INVISIBLE);
                    pokemon.setVisibility(View.INVISIBLE);
                    scooby.setVisibility(View.VISIBLE);
                    stopPlaying();
                    mp = MediaPlayer.create(this,R.raw.scoobydoo);
                    mp.start();
                }
                break;
        }
    }

    public void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void startPlay(View view) {
        mp.start();
    }

    public void stopPlay(View view) {
        mp.pause();
    }
}
