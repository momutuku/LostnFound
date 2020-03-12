package com.example.last;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    //Variables
    Animation topanim, bottomanim;
    ImageView logo;
    TextView slogan;
    TextInputEditText email1, pasd1;
    Button loginbtn, forget, signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
        String using = preferences.getString("remember", "");
        if (using.equals("true")) {
            Intent dash = new Intent(Login.this, Dashboard.class);
            startActivity(dash);
            finish();
        }


        loginbtn = findViewById(R.id.loginbtn);
        forget = findViewById(R.id.forgotbtn);
        signupbtn = findViewById(R.id.signupbtn);
        logo = findViewById(R.id.logo1);
        slogan = findViewById(R.id.slogan1);


        email1 = findViewById(R.id.email_login);
        pasd1 = findViewById(R.id.password_login);


        topanim = AnimationUtils.loadAnimation(this, R.anim.transition);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom);

        logo.setAnimation(topanim);
        slogan.setAnimation(bottomanim);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Pair[] pairs = new Pair[2];
                    pairs[0] = new Pair<View, String>(logo, "logo_image");
                    pairs[1] = new Pair<View, String>(slogan, "logo_text");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());
                    finish();

                }
                startActivity(intent);
                finish();
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Reset.class);
                startActivity(intent);
            }
        });




        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email1.getText().toString();
                String passwd = pasd1.getText().toString();
                String method = "login";
                BackgroundTask login = new BackgroundTask(Login.this);
                login.execute(method, email, passwd);

                Handler waiter = new Handler();
                Runnable runner = new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);
                        finish();
                    }
                };
                waiter.postDelayed(runner,3000);

                // TODO: 3/6/2020
//                    Add Vallidation to See if login was successful


            }
        });


    }
}
