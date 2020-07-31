package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    public void reverseWord(View view) {

        EditText editText = findViewById(R.id.Reverse);
        String reverse="";

        //get the text written in the editText input field
        String text = editText.getText().toString();
        int length = text.length();
        for (int i = length - 1 ; i >= 0 ; i--)
            reverse = reverse + text.charAt(i);
        //Log.i("ok","ok");
        editText.setText(reverse);
    }
    public void getLength(View view){
        EditText editText = findViewById(R.id.Reverse);
        String text = editText.getText().toString();
        int len=text.length();
        String length=Integer.toString(len);
        editText.setText(length);
    }
    public void getLower(View view){
        EditText editText = findViewById(R.id.Reverse);
        String text = editText.getText().toString();
        editText.setText(text.toLowerCase());
    }

    public void getCapitalize(View view){
        EditText editText = findViewById(R.id.Reverse);
        String text = editText.getText().toString();
        editText.setText(text.toUpperCase());
    }
    public void reset(View view){
        EditText editText = findViewById(R.id.Reverse);
        editText.getText().clear();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}