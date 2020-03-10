package com.example.last;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Reset extends AppCompatActivity {
    EditText email;
    Button login, send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        email = findViewById(R.id.reset);
        login = findViewById(R.id.loginbk);
        send = findViewById(R.id.resetbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reset.this, Login.class);
                startActivity(intent);
            }
        });



    }

    public void forgot(View view) {
        Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show();
    }


}
