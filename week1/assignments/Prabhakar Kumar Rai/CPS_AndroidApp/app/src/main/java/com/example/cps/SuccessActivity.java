package com.example.cps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Intent intent = getIntent();

        if(intent != null){
            TextView tv = findViewById(R.id.tv_stdName);
            String msg = intent.getStringExtra(keystore.KEY_MESSAGE);

            tv.setText(getString(R.string.success_msg , msg));
        }

    }
}