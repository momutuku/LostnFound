package com.example.last;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
    ImageView img;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img = findViewById(R.id.detimg);
        tv = findViewById(R.id.dettitle);

        int i = getIntent().getExtras().getInt("imgUrl");
        tv.setText(getIntent().getExtras().getString("title"));

        img.setImageResource(i);
    }
}
