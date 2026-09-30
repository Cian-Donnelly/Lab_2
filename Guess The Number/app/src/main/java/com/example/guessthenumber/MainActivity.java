package com.example.guessthenumber;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int secretNumber;
    private int numberOfGuesses;

    private EditText guessInput;
    private Button guessButton;
    private Button playAgainButton;
    private TextView resultText;
    private TextView guessCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessInput = findViewById(R.id.guessInput);
        guessButton = findViewById(R.id.guessButton);
        playAgainButton = findViewById(R.id.playAgainButton);
        resultText = findViewById(R.id.resultText);
        guessCountText = findViewById(R.id.guessCountText);

        startNewGame();

        guessButton.setOnClickListener(v -> checkGuess());

        playAgainButton.setOnClickListener(v -> startNewGame());
    }

    private void startNewGame() {
        Random random = new Random();

        // Generate a number from 1 to 30
        secretNumber = random.nextInt(30) + 1;

        numberOfGuesses = 0;

        guessInput.setText("");
        guessInput.setEnabled(true);
        guessButton.setEnabled(true);

        resultText.setText("Make your first guess!");
        guessCountText.setText("Number of guesses: 0");

        playAgainButton.setVisibility(Button.GONE);
    }

    private void checkGuess() {

        String input = guessInput.getText().toString().trim();

        if (input.isEmpty()) {
            guessInput.setError("Please enter a number");
            return;
        }

        int userGuess;

        try {
            userGuess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            guessInput.setError("Please enter a valid number");
            return;
        }

        if (userGuess < 1 || userGuess > 30) {
            guessInput.setError("Enter a number between 1 and 30");
            return;
        }

        numberOfGuesses++;

        guessCountText.setText(
                "Number of guesses: " + numberOfGuesses
        );

        if (userGuess == secretNumber) {

            resultText.setText(
                    "Correct! You guessed the number!"
            );

            guessInput.setEnabled(false);
            guessButton.setEnabled(false);

            playAgainButton.setVisibility(Button.VISIBLE);

        } else if (userGuess < secretNumber) {

            resultText.setText(
                    "The number is higher!"
            );

        } else {

            resultText.setText(
                    "The number is lower!"
            );
        }
    }
}