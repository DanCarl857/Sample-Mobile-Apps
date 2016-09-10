package com.example.daniel.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 - yellow, 1 - red
    int activePlayer = 0;

    // 2 - represents neutral states.
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    public void dropIn(View view){

        ImageView pic = (ImageView) view;

        // Get tags to determine which position was clicked.
        int tappedCounter = Integer.parseInt(pic.getTag().toString());

        if(gameState[tappedCounter] == 2) {

            // Now change state to that of the activePlayer.
            gameState[tappedCounter] = activePlayer;

            // remove picture from the top.
            pic.setTranslationY(-1000f);

            if (activePlayer == 0) {
                // change image.
                pic.setImageResource(R.drawable.yellow);

                // now set it to red's turn.
                activePlayer = 1;
            } else {
                pic.setImageResource(R.drawable.red);

                // now set it to yellow's turn.
                activePlayer = 0;
            }

            // simulate drop In effect.
            pic.animate().translationYBy(1000f).rotation(3600).setDuration(300);

        } else {
            // Display toast to inform client that position is already filled.
            Toast.makeText(getApplicationContext(), "Position occupied.\nTry another!", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
