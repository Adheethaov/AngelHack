package com.visionreboot.kaipunyam.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;

import com.visionreboot.kaipunyam.R;

/**
 * Created by BincyBaby on 29/07/18.
 * Copyright (c) 2018 Padath Infotainment
 */
public class LandingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent signUp = new Intent(LandingActivity.this, SignUpActivity.class);
                startActivity(signUp);
                finish();
            }
        }, 3000);


    }
}
