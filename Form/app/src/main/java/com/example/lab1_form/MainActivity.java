package com.example.lab1_form;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameInput = findViewById(R.id.nameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        EditText telephoneInput = findViewById(R.id.telephoneInput);
        EditText emailInput = findViewById(R.id.emailInput);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {

            String name = nameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String telephone = telephoneInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();

            // Check that the name is not empty
            if (name.isEmpty()) {
                nameInput.setError("Please enter your name");
                nameInput.requestFocus();
                return;
            }

            // Check that the name contains only letters and spaces
            if (!name.matches("[a-zA-Z ]+")) {
                nameInput.setError("Name can only contain letters");
                nameInput.requestFocus();
                return;
            }

            // Check password
            if (password.isEmpty()) {
                passwordInput.setError("Please enter a password");
                passwordInput.requestFocus();
                return;
            }

            // Check telephone number
            if (telephone.isEmpty()) {
                telephoneInput.setError("Please enter your telephone number");
                telephoneInput.requestFocus();
                return;
            }

            if (!telephone.matches("[0-9]+")) {
                telephoneInput.setError("Telephone number can only contain numbers");
                telephoneInput.requestFocus();
                return;
            }

            // Check email
            if (email.isEmpty()) {
                emailInput.setError("Please enter your email address");
                emailInput.requestFocus();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.setError("Please enter a valid email address");
                emailInput.requestFocus();
                return;
            }

            // Everything is valid
            Toast.makeText(
                    MainActivity.this,
                    "Thank you " + name + ", your request is being processed",
                    Toast.LENGTH_LONG
            ).show();
        });
    }
}