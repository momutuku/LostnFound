package com.example.last;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

//import com.squareup.picasso.Picasso;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView ImgUserphoto;
    TextView Emailp, userpr, hname, hphone, hmail;
    Button updater;
    Bitmap bitmapc;

    Uri pickedImg;
    MenuItem login, profile;
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(com.example.last.R.layout.activity_dashboard);


        //Hooks
        ImgUserphoto = findViewById(com.example.last.R.id.profileimg);
        updater = findViewById(com.example.last.R.id.update);
        userpr = findViewById(com.example.last.R.id.userp);
        Emailp = findViewById(com.example.last.R.id.email1);
        hname = findViewById(com.example.last.R.id.dashname);
        hphone = findViewById(com.example.last.R.id.dashtel);
        hmail = findViewById(com.example.last.R.id.dashemail);


        final SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
        String user = preferences.getString("remember", "");
        String lname = preferences.getString("lname", "");
        String email = preferences.getString("email", "");
        String phnoe = preferences.getString("phnoe", "");
        String fname = preferences.getString("fname", "");
        String image = preferences.getString("image", "");


        hname.setText(lname);
        hmail.setText(email);
        hphone.setText(phnoe);
        Emailp.setText(email);
        userpr.setText(fname);

        drawer = findViewById(com.example.last.R.id.drawer_layout);
        navigationView = findViewById(com.example.last.R.id.nav_view);
        toolbar = findViewById(com.example.last.R.id.toolbar);


        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, com.example.last.R.string.navopen, com.example.last.R.string.navclose);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();


        login = menu.findItem(com.example.last.R.id.drawer_login);
        login.setVisible(false);




        updater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
//                Toast.makeText(Dashboard.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void openGallery() {

        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(galleryIntent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }



    private void showMessage(String updated) {

        Toast.makeText(getApplicationContext(), updated, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case com.example.last.R.id.drawer_logout:
                globalconst.user = null;
                globalconst.gmail = "";
                globalconst.gltname = "";
                globalconst.gname = "";
                globalconst.gtelno = "";
                globalconst.gimg = "";
                SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                Intent intent = new Intent(Dashboard.this, Login.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_home:
                Intent navhome = new Intent(Dashboard.this, Profile.class);
                startActivity(navhome);
                break;
            //End Switch
        }
        return true;
    }

    //End onCreate
}
