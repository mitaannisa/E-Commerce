package com.meow.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registerCustomer extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton, loginLagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

        // Initialize UI elements
        fullNameEditText = findViewById(R.id.input_full_name);
        emailEditText = findViewById(R.id.input_email_register);
        passwordEditText = findViewById(R.id.input_password_register);
        registerButton = findViewById(R.id.btn_register);
        loginLagi = findViewById(R.id.loginlagi);

        // Set onClickListener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered full name, email, and password
                String fullName = fullNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Example: Check if all fields are not empty
                if (!fullName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    // Example: Perform registration logic
                    boolean registrationSuccess = performRegistration(fullName, email, password);

                    // Example: Show a toast message based on registration result
                    if (registrationSuccess) {
                        showToast("Registration successful");
                        // TODO: Optionally, you can navigate to the login screen or perform other actions
                    } else {
                        showToast("Registration failed. Please try again.");
                    }
                } else {
                    showToast("Please enter all fields.");
                }
            }
        });

        loginLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the RegisterActivity when the register button is clicked
                Intent intent = new Intent(registerCustomer.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Example method for performing registration logic
    private boolean performRegistration(String fullName, String email, String password) {
        // You should implement your registration logic here
        // For simplicity, let's assume any non-empty values are valid
        return !fullName.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }

    // Helper method to show a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
