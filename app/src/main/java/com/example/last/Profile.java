package com.example.last;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

//import com.squareup.picasso.Picasso;

public class Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView ImgUserphoto;
    TextView Emailp, userpr, hname, hphone, hmail;
    Button updater;
    Bitmap bitmapc;

    Uri pickedImg;
    MenuItem login, profile;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    DatabaseReference ref1;
    StorageReference storageRef = storage.getReferenceFromUrl("gs://lostnfound-d25b8.appspot.com");


    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        drawer = findViewById(com.example.last.R.id.drawer_layoutp);
        navigationView = findViewById(com.example.last.R.id.nav_viewp);
        toolbar = findViewById(com.example.last.R.id.toolbarp);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;



        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, com.example.last.R.string.navopen, com.example.last.R.string.navclose);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();
        login = menu.findItem(com.example.last.R.id.drawer_login);
        login.setVisible(false);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case com.example.last.R.id.logout:
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
                Intent intent = new Intent(Profile.this, Login.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            //End Switch
        }
        return true;
    }

    //End onCreate
}
