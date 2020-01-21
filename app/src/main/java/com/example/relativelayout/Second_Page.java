package com.example.relativelayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import android.view.View;

import java.util.regex.Pattern;

public class Second_Page extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[a-zA-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");
    EditText username,email,conpass,pass;
    Button signup;
    DatabaseHandler dbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__page);
        dbo = new DatabaseHandler(this);
        signup = findViewById(R.id.signupp);
        username = findViewById(R.id.name);
        email = findViewById(R.id.emails);
        pass = findViewById(R.id.pwd);
        conpass = findViewById(R.id.country);

        validateusern();
        validatemail();
        validatepas();
        validatecofpass();
        ChangeScreen();
    }
    void ChangeScreen()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abd = new Intent (Second_Page.this,Singapore.class);
                startActivity(abd);
            }
        });
    }
    private boolean validateusern() {
        String usernameInput = username.getEditableText().toString().trim();

        if (usernameInput.isEmpty()) {
            username.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            username.setError("Username too long");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }
    private boolean validatemail() {
        String usernameInput = email.getEditableText().toString().trim();

        if (usernameInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            email.setError("Username too long");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }
    private boolean validatepas() {
        String passwordInput = pass.getEditableText().toString().trim();

        if (passwordInput.isEmpty()) {
            pass.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            pass.setError("Password too weak");
            return false;
        } else {
            pass.setError(null);
            return true;

        }
    }
    private boolean validatecofpass() {
        String passwordInput = conpass.getEditableText().toString().trim();

        if (passwordInput.isEmpty()) {
            conpass.setError("Field can't be empty");
            return false;
        } else {
            conpass.setError(null);
            return true;

        }
    }
}
