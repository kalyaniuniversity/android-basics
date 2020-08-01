package com.androidapp.phototext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EdittextActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ACTIVITY_RESULT_CODE = 0;

     EditText addtext;
     ImageView mcolorimg;
     ImageView mcolorView;
     EditText mresultColor;
     Bitmap bitmap;
     TextView savetext;
     ImageView backbutton;
     String textclr;
     Intent intenttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(this);

        addtext = findViewById(R.id.addtext);

        savetext = findViewById(R.id.savetext);
        savetext.setOnClickListener(this);

        mcolorView = findViewById(R.id.colorView);
        mresultColor = findViewById(R.id.resultColor);

        mcolorimg = findViewById(R.id.color);
        mcolorimg.setDrawingCacheEnabled(true);
        mcolorimg.buildDrawingCache(true);

        mcolorimg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE){
                    bitmap = mcolorimg.getDrawingCache();

                    int pixel = bitmap.getPixel((int)event.getX(), (int)event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    String hex = "#"+ Integer.toHexString(pixel);

                    mcolorView.setBackgroundColor(Color.rgb(r,g,b));
                    mcolorView.setImageDrawable(null);
                    mresultColor.setText("RGB: "+r +", "+ g +", "+ b
                    +"\tHEX: "+ hex);
                   // int setcolor = Color.rgb(r, g, b);
                    addtext.setTextColor(Color.rgb(r, g, b));
                    //textclr = addtext.getEditableText().toString();
                    intenttxt = new Intent();
                    intenttxt.putExtra("text", addtext.getEditableText().toString());
                    //Intent i=new Intent(EdittextActivity.this,TexteditorActivity.class);
                    intenttxt.putExtra("Color", hex);
                }
                return true;
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton:
                finish();
                break;

            case R.id.savetext:
                setResult(RESULT_OK, intenttxt);
                finish();
                break;
        }
    }

}
