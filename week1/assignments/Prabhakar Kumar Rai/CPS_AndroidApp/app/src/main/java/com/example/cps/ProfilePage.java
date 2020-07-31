package com.example.cps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        Intent intent = getIntent();

//        if(intent != null){
//            TextView tv = findViewById(R.id.tv_profile);
//            String msg = intent.getStringExtra(keystore.KEY_MESSAGE);
//
//
//            tv.setText(getString(R.string.welcome_message, msg));
//        }
    }

}