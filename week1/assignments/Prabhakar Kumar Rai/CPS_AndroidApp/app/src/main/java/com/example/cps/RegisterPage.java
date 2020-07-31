package com.example.cps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }

    public void switchToSuccessActivity(View view){

        EditText etName = findViewById(R.id.regName);
        EditText etId = findViewById(R.id.regUserId);
        EditText etAdmn = findViewById(R.id.regAdmnNo);
        EditText etClass = findViewById(R.id.regClass);
        EditText etRoll = findViewById(R.id.regRoll);
        EditText etPassword = findViewById(R.id.regPassword);
        EditText etConfirm = findViewById(R.id.regConfirm);

        String stdName = etName.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirm.getText().toString();
        Intent intent = new Intent(this,SuccessActivity.class);
        intent.putExtra(keystore.KEY_MESSAGE,stdName);
        startActivity(intent);
//        if(password == confirmPassword){
//
//
//        }
    }

    public void switchToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}