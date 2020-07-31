package com.example.voteriddecoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();

        if(intent != null) {
            String message = intent.getStringExtra(Keystore.KEY_MESSAGE);
            EditText name = findViewById(R.id.NameR);
            EditText father= findViewById(R.id.FatherR);
            EditText gender=findViewById(R.id.GenderR);
            EditText DOB=findViewById(R.id.DOBR);
            EditText id= findViewById(R.id.IDR);
            try {
                JSONObject jsonObject= new JSONObject(message);
//                String Response = jsonObject.getString("Response");
                name.setText(jsonObject.getString("Elector's name"));
                father.setText(jsonObject.getString("Father's name"));
                gender.setText(jsonObject.getString("Gender"));
                DOB.setText(jsonObject.getString("DOB"));
                id.setText(jsonObject.getString("ID"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    public void finishactivity(View view){
        finish();
    }
}