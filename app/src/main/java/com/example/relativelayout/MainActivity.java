package com.example.relativelayout;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Pattern;




public class MainActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[a-zA-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");

    EditText mail, pass;
    Button signin,signup;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);
        signin =findViewById(R.id.signin);
        mail =findViewById(R.id.email);
        pass =findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail();
                password();
                if(mail()==true && password() == true)
                {
                    Intent intent = new Intent(MainActivity.this, Singapore.class);
                    startActivity(intent);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abd = new Intent(MainActivity.this,Second_Page.class);
                startActivity(abd);
            }
        });



    }

    private boolean mail()
    {
        String MAIL = mail.getEditableText().toString().trim();

        if (MAIL.isEmpty()) {
            mail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(MAIL).matches()) {
            mail.setError("Please enter a valid email address");
            return false;
        } else {
            mail.setError(null);
            return true;
        }
    }
    private boolean password() {
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

}


