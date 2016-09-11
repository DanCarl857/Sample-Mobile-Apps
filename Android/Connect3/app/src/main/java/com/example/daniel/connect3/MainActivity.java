package com.example.daniel.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 0 - yellow, 1 - red
    int activePlayer = 0;

    boolean gameIsActive = true;

    // 2 - represents neutral states.
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // winning positions
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view){

        ImageView pic = (ImageView) view;

        // Get tags to determine which position was clicked.
        int tappedCounter = Integer.parseInt(pic.getTag().toString());

        if(gameState[tappedCounter] == 2 && gameIsActive) {

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

            for(int[] winningPosition : winningPositions){

                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    gameIsActive = false;

                    String winner = "Red";

                    if(gameState[winningPosition[0]] == 0){
                        winner = "Yellow";
                    }

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                    // Set text message to display correct winner.
                    winnerMessage.setText(winner + " has won!");

                    // Make layout appear when user wins. I think a dialog could do here better.
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                } else {
                    boolean gameIsOver = true;

                    for(int counterState : gameState){

                        if(counterState == 2) gameIsOver = false;
                    }

                    if(gameIsOver){
                        gameIsActive = false;
                        // This could be moved into a method.
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                        // Set text message to display correct winner.
                        winnerMessage.setText("It's a draw");

                        // Make layout appear when user wins. I think a dialog could do here better.
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }

        } else {
            // Display toast to inform client that position is already filled.
            Toast.makeText(getApplicationContext(), "Position occupied.\nTry another!", Toast.LENGTH_SHORT).show();
        }

    }

    // function to allow play again.
    public void playAgain(View view){

        gameIsActive = true;

        // now make layout invisible
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for(int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for(int i = 0; i < gridLayout.getChildCount(); i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
