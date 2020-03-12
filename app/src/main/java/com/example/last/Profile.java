package com.example.last;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Profile extends AppCompatActivity implements IDItemClick {
    private List<slider> lstSlides;
    private ViewPager spager;
    DrawerLayout drawerp;
    NavigationView navigationViewp;
    Toolbar toolbarp;
    MenuItem login, logout, profile;
    private RecyclerView IDSRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        spager = findViewById(R.id.slider);

        SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
        String using = preferences.getString("remember", "");


        //Drawer
//        drawerp = findViewById(com.example.last.R.id.drawer_layout);
//        navigationViewp = findViewById(com.example.last.R.id.nav_view);
//        toolbarp = findViewById(com.example.last.R.id.toolbar);
//
//
//        setSupportActionBar(toolbarp);
//        navigationViewp.bringToFront();
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerp, toolbarp, com.example.last.R.string.navopen, com.example.last.R.string.navclose);
//        drawerp.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationViewp.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
//        Menu menu = navigationViewp.getMenu();
//
//        if (using.equals("true")) {
//            login = menu.findItem(com.example.last.R.id.drawer_login);
//            login.setVisible(false);
//        } else {
//            logout = menu.findItem(R.id.drawer_logout);
//            logout.setVisible(false);
//            profile = menu.findItem(R.id.drawer_profile);
//            profile.setVisible(false);
//        }

//        Load slides Here
        lstSlides = new ArrayList<>();
        lstSlides.add(new slider(R.drawable.abstract1, "ABSTRACT \n"));
        lstSlides.add(new slider(R.drawable.abstract1, "ABSTRACT 2\n"));
        lstSlides.add(new slider(R.drawable.abstract1, "ABSTRACT 3\n"));
        SliderAdapter adapter = new SliderAdapter(this, lstSlides);
        spager.setAdapter(adapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Profile.SliderTimer(), 4000, 6000);

//        Recycler view
        IDSRV = findViewById(R.id.idrv);
        List<IDs> lst = new ArrayList<>();
        lst.add(new IDs("First",R.drawable.abstract4));
        lst.add(new IDs("Second",R.drawable.abstract4));
        lst.add(new IDs("Third",R.drawable.abstract4));

        IDadapter adpter = new IDadapter(this, lst, this);
        IDSRV.setAdapter(adpter);
        IDSRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }


    @Override
    public void onIDsClick(IDs id, ImageView IDimg) {
        //Send ID info
        Intent intent = new Intent(this, Details.class);
        intent.putExtra("title",id.getTitle());
        intent.putExtra("imgUrl",id.getThumbnail());

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Profile.this, IDimg,"shared");
            startActivity(intent, options.toBundle());
        }

    }

    public class SliderTimer extends TimerTask {
        @Override
        public void run() {
            Profile.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (spager.getCurrentItem() < lstSlides.size() - 1) {
                        spager.setCurrentItem(spager.getCurrentItem() + 1);
                    } else {
                        spager.setCurrentItem(0);
                    }
                }
            });
        }
    }


    //End onCreate
}
