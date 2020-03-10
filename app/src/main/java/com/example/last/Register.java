package com.example.last;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {
    //Variables
    Button register, loginbk;
    TextInputEditText fname, lname, phone, cfmpass, email, pasd;


    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);


//        if (globalconst.user != null) {
//            Intent intent = new Intent(Register.this, Dashboard.class);
//            startActivity(intent);
//            finish();
//
//        }

        email = findViewById(R.id.regem);
        fname = findViewById(R.id.fname1);
        lname = findViewById(R.id.lname1);
        phone = findViewById(R.id.tell1);
        pasd = findViewById(R.id.regpp);
        cfmpass = findViewById(R.id.regconf);
        register = findViewById(R.id.registerbtn);
        loginbk = findViewById(R.id.bklogin);
        pd = new ProgressDialog(Register.this);


        loginbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                Toast.makeText(Register.this, "Clicked",
                        Toast.LENGTH_SHORT).show();


            }
        });


    }

    private Boolean validateEmail() {
        String mail = email.getText().toString();
        String mailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (mail.isEmpty()) {
            email.setError("Field is required");
            return false;
        } else if (!mail.matches(mailPattern)) {
            email.setError("Invalid Email");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String passw = pasd.getText().toString();
        String cpassw = cfmpass.getText().toString();
        pasd.setError(null);
        cfmpass.setError(null);
        if (passw == cpassw) {

            if (passw.isEmpty() && cpassw.isEmpty()) {

                pasd.setError("Field is required");
                cfmpass.setError("Field is required");
                return false;
            } else if (passw.isEmpty()) {
                pasd.setError("Field is required");
                return false;
            } else if (cpassw.isEmpty()) {
                cfmpass.setError("Field is required");
                return false;
            } else
                pasd.setError(null);
            cfmpass.setError(null);
            return true;
        } else {
            return false;
        }
    }


    public void registerUser(View view) {
        String namestr = fname.getText().toString();
        String emailstr = email.getText().toString();
        String passstr = pasd.getText().toString();
        String method = "register";
        BackgroundTask backt = new BackgroundTask(this);
        backt.execute(method, namestr,emailstr,passstr);
        Intent intent = new Intent(Register.this, Dashboard.class);
        startActivity(intent);
        finish();


    }






}
