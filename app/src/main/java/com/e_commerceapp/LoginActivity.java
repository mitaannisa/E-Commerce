package com.e_commerceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail, editPassword;
    Button btnLogin;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silakan tunggu...");
        progressDialog.setCancelable(false);

        editEmail = findViewById(R.id.input_email);
        editPassword = findViewById(R.id.input_password);

        mAuth = FirebaseAuth.getInstance();

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(v -> {
            if(editEmail.getText().length()>0 && editPassword.getText().length()>0){
                login(editEmail.getText().toString(), editPassword.getText().toString());
            } else {
                Toast.makeText(this, "Silakan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void login(String email, String password) {
        //progressDialog.show();
        //Toast.makeText(getApplicationContext(), "masuk login()", Toast.LENGTH_SHORT).show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //Toast.makeText(getApplicationContext(), "masuk sign in blabla", Toast.LENGTH_SHORT).show();
                if (task.isSuccessful() && task.getResult()!=null) {
                    if (task.getResult().getUser()!=null) {
                        reload();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Login Gagal!", Toast.LENGTH_SHORT).show();
                }
                //progressDialog.dismiss();
            }
        });
        Toast.makeText(getApplicationContext(), "selesai login", Toast.LENGTH_SHORT).show();
    }

    private void reload() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    /*@Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            //Intent intent = new Intent(MainActivity.this, HalamanUtamaActivity.class);
            //startActivity(intent);
        }
    }*/
}