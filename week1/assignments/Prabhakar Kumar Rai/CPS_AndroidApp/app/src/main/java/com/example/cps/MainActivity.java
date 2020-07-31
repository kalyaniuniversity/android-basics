package com.example.cps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();

//        TextView tv = findViewById(R.id.tv_one);
//        String message = getText(R.string.login).toString();
//
//        tv.setText(message);
    }

    public void switchActivity(View view){

        EditText et = findViewById(R.id.loginId);
        String name = et.getText().toString();

        Intent intent = new Intent(this, ProfilePage.class);
        intent.putExtra(keystore.KEY_MESSAGE,name);
        startActivity(intent);
    }

    public void registerActivity(View view){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
}