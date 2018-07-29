package com.visionreboot.kaipunyam.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.visionreboot.kaipunyam.R;

/**
 * Created by BincyBaby on 29/07/18.
 * Copyright (c) 2018 Padath Infotainment
 */
public class SignUpActivity extends AppCompatActivity {
    AppCompatButton materialButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        materialButton = findViewById(R.id.next_button);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(signUp);
                finish();
            }
        });
    }
}
