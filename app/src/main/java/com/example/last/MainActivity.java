package com.example.last;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


  //Variables
  private static int SPLASH =5000;
  Animation topanim, bottomanim;
  ImageView logo;
  TextView slogan;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_main);
    //Animation
    topanim = AnimationUtils.loadAnimation(this, R.anim.transition);
    bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom);

    logo = findViewById(R.id.logo);
    slogan = findViewById(R.id.slogan);

    logo.setAnimation(topanim);
    slogan.setAnimation(bottomanim);


    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(MainActivity.this, Login.class);

        Pair[] pairs= new Pair[2];
        pairs[0] = new Pair<View,String>(logo,"logo_image");
        pairs[1] = new Pair<View,String>(slogan,"logo_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
          ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
          startActivity(intent,options.toBundle());
//          startActivity(intent);
          finish();
        }
//        startActivity(intent);

      }
    }, SPLASH);

  }
}
