package com.meow.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton, registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        emailEditText = findViewById(R.id.input_email);
        passwordEditText = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.btn_login);
        registerButton = findViewById(R.id.btn_register);

        // Set onClickListener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered email and password
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Example: Check if email and password are not empty
                if (!email.isEmpty() && !password.isEmpty()) {
                    // Example: Perform login logic (authentication)
                    boolean loginSuccess = performLogin(email, password);

                    // Example: Show a toast message based on login result
                    if (loginSuccess) {
                        showToast("Login successful");

                        // Start the next activity or perform necessary actions for successful login
                        Intent intent = new Intent(MainActivity.this, mainMenu.class);
                        startActivity(intent);
                    } else {
                        showToast("Login failed. Invalid email or password.");
                    }
                } else {
                    showToast("Please enter both email and password.");
                }
            }
        });


// Set onClickListener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the RegisterActivity when the register button is clicked
                Intent intent = new Intent(MainActivity.this, registerCustomer.class);
                startActivity(intent);
            }
        });
    }

    // Example method for performing login logic (authentication)
    private boolean performLogin(String email, String password) {
        // You should implement your authentication logic here
        // For simplicity, let's assume any non-empty email and password are valid
        return !email.isEmpty() && !password.isEmpty();
    }

    // Helper method to show a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
