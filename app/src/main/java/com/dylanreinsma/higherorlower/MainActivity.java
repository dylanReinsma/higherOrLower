package com.dylanreinsma.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandomNumber() {
        randomNumber = new Random().nextInt(20) + 1;
    }

    public void guess (View view) {

        EditText guessText = findViewById(R.id.guessText);
        String message;
        if (guessText.getText().toString().isEmpty()) {
            message = "Please input a number between 1 and 20";
            Toast.makeText(this, message,
                    Toast.LENGTH_LONG).show();
        } else {
            int guessNumber = Integer.parseInt(guessText.getText().toString());
            String randomNumberString = Integer.toString(randomNumber);
            if (guessNumber > randomNumber && guessNumber >= 1 && guessNumber <= 20) {
                message = "Lower";
            } else if (guessNumber < randomNumber && guessNumber >= 1 && guessNumber <= 20) {
                message = "Higher";
            } else if (guessNumber == randomNumber) {
                message = "Correct, the number was " + randomNumberString + "!  Try Again!";
                generateRandomNumber();
            } else {
                message = "Please input a number between 1 and 20";
            }

            Toast.makeText(this, message,
                    Toast.LENGTH_LONG).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumber = new Random().nextInt(20) + 1;
    }
}
