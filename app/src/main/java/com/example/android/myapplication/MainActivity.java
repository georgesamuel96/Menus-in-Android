package com.example.android.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView mNavigationView;

    Animation fabOpenWhite, fabCloseWhite, fabOpenRed, fabCloseRed, fabOpenGreen, fabCloseGreen,
            fabOpenYellow, fabCloseYellow, fabOpenBlack, fabCloseBlack;
    boolean isOpen = false;
    ImageView imageWhite, imageRed, imageGreen, imageYellow, imageBlack, logo;
    TextView textWhite, textRed, textGreen, textYellow, textBlack, mGeorge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * This Code for Navigation Drawer
         */
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavigationView = (NavigationView)findViewById(R.id.navigationView);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.white)
                {
                    mDrawerLayout.setBackgroundColor(Color.WHITE);
                }
                else if(item.getItemId() == R.id.red)
                {
                    mDrawerLayout.setBackgroundColor(Color.RED);
                }
                else if(item.getItemId() == R.id.yellow)
                {
                    mDrawerLayout.setBackgroundColor(Color.YELLOW);
                }
                else if(item.getItemId() == R.id.black)
                {
                    mDrawerLayout.setBackgroundColor(Color.BLACK);
                }
                else if(item.getItemId() == R.id.green)
                {
                    mDrawerLayout.setBackgroundColor(Color.GREEN);
                }

                return true;
            }
        });

        /*
         * Thic Code for Floating Action Menu
         */
        cycleImage(R.id.white, R.drawable.p);
        cycleImage(R.id.red, R.drawable.p);
        cycleImage(R.id.green, R.drawable.p);
        cycleImage(R.id.yellow, R.drawable.p);
        cycleImage(R.id.black, R.drawable.p);

        fabOpenWhite = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open_white);
        fabCloseWhite = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_white);
        fabOpenRed = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open_red);
        fabCloseRed = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_red);
        fabOpenGreen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open_green);
        fabCloseGreen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_green);
        fabOpenYellow = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open_yellow);
        fabCloseYellow = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_yellow);
        fabOpenBlack = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open_black);
        fabCloseBlack = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_black);
        imageWhite = (ImageView)findViewById(R.id.white);
        imageRed = (ImageView)findViewById(R.id.red);
        imageGreen = (ImageView)findViewById(R.id.green);
        imageYellow = (ImageView)findViewById(R.id.yellow);
        imageBlack = (ImageView)findViewById(R.id.black);
        logo = (ImageView)findViewById(R.id.logo);
        textWhite = (TextView)findViewById(R.id.text_white);
        textRed = (TextView)findViewById(R.id.text_red);
        textGreen = (TextView)findViewById(R.id.text_green);
        textYellow = (TextView)findViewById(R.id.text_yellow);
        textBlack = (TextView)findViewById(R.id.text_black);
        mGeorge = (TextView)findViewById(R.id.george);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen)
                {
                    mGeorge.setAlpha(1.0f);
                    imageWhite.startAnimation(fabCloseWhite);
                    imageRed.startAnimation(fabCloseRed);
                    imageGreen.startAnimation(fabCloseGreen);
                    imageYellow.startAnimation(fabCloseYellow);
                    imageBlack.startAnimation(fabCloseBlack);
                    textWhite.startAnimation(fabCloseWhite);
                    textRed.startAnimation(fabCloseRed);
                    textGreen.startAnimation(fabCloseGreen);
                    textYellow.startAnimation(fabCloseYellow);
                    textBlack.startAnimation(fabCloseBlack);
                    isOpen = false;
                }
                else
                {
                    mGeorge.setAlpha(0.3f);
                    imageWhite.startAnimation(fabOpenWhite);
                    imageRed.startAnimation(fabOpenRed);
                    imageGreen.startAnimation(fabOpenGreen);
                    imageYellow.startAnimation(fabOpenYellow);
                    imageBlack.startAnimation(fabOpenBlack);
                    textWhite.startAnimation(fabOpenWhite);
                    textRed.startAnimation(fabOpenRed);
                    textGreen.startAnimation(fabOpenGreen);
                    textYellow.startAnimation(fabOpenYellow);
                    textBlack.startAnimation(fabOpenBlack);
                    isOpen = true;
                }
            }
        });

        imageWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.setBackgroundColor(Color.WHITE);
            }
        });

        imageRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.setBackgroundColor(Color.RED);
            }
        });

        imageGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.setBackgroundColor(Color.GREEN);
            }
        });

        imageYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.setBackgroundColor(Color.YELLOW);
            }
        });

        imageBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.setBackgroundColor(Color.BLACK);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
            return true;

        if(item.getItemId() == R.id.white)
        {
            mDrawerLayout.setBackgroundColor(Color.WHITE);
        }
        else if(item.getItemId() == R.id.red)
        {
            mDrawerLayout.setBackgroundColor(Color.RED);
        }
        else if(item.getItemId() == R.id.yellow)
        {
            mDrawerLayout.setBackgroundColor(Color.YELLOW);
        }
        else if(item.getItemId() == R.id.black)
        {
            mDrawerLayout.setBackgroundColor(Color.BLACK);
        }
        else if(item.getItemId() == R.id.green)
        {
            mDrawerLayout.setBackgroundColor(Color.GREEN);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
         * Finction to return cycler image
         */
    public void cycleImage(int id1, int id2)
    {
        ImageView profileImage = (ImageView)findViewById(id1);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id2);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        profileImage.setImageDrawable(roundedBitmapDrawable);
    }


}
