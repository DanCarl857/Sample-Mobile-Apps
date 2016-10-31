package com.example.daniel.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    TextView resultsTextView;
    TextView pointsTextView;
    TextView sumTextView;

    ArrayList<Integer>answers = new ArrayList<Integer>();

    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    public void generateQuestion() {

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        int incorrectAnswer;

        for(int i = 0; i < 4; i++){

            if(i == locationOfCorrectAnswer){

                answers.add(a + b);

            } else {

                incorrectAnswer = rand.nextInt(41);

                while(incorrectAnswer == a + b){

                    incorrectAnswer = rand.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }

        // Update all the buttons with respective answers

        button.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public void chooseAnswer(View view) {

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){

            score++;
            resultsTextView.setText("Correct!");
        } else{

            resultsTextView.setText("Wrong!");
        }

        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score) + " / " + Integer.toString(numberOfQuestions));
    }

    public void start(View view) {

        startButton.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);

        sumTextView = (TextView)findViewById(R.id.sumTextView);
        resultsTextView = (TextView) findViewById(R.id.resultTextView);
        pointsTextView = (TextView) findViewById(R.id.scoreTextView);
        button = (Button)findViewById(R.id.button);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);

        generateQuestion();
    }
}
