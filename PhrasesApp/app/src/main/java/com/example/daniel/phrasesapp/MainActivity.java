package com.example.daniel.phrasesapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view){

        int id = view.getId();

        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id);

        int playId = getResources().getIdentifier(ourId, "raw", "com.example.daniel.phraseapp");

        MediaPlayer mplayer = MediaPlayer.create(this, playId);

        mplayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
