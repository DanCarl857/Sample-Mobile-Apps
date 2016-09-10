package com.example.daniel.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertFunc(View view){

        EditText textEdit = (EditText) findViewById(R.id.editText);

        // get dollar amount now
        Double amount = Double.parseDouble(textEdit.getText().toString());

        // assuming conversion rate is 0.6 to pounds...
        Double ans = amount * 0.6;

        // Print ans to toast
        Toast.makeText(getApplicationContext(), "Amount in Pounds: " + ans , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
