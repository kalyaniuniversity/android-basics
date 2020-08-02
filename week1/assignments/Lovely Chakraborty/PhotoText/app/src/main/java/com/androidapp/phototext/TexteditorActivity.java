package com.androidapp.phototext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;

import static java.security.AccessController.getContext;

public class TexteditorActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int ACTIVITY_RESULT_CODE = 10;
    private ImageView backbutton;
    private ImageView phototext;
    private ImageView text;
    private TextView textonphoto;
    private ImageView back;
    private LinearLayout wallpaper;
    private TextView customPageScreenshot;
    private LinearLayout rootContent;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texteditor);

        customPageScreenshot = (TextView) findViewById(R.id.custom_page_screenshot);
        customPageScreenshot.setOnClickListener(this);
        rootContent = (LinearLayout) findViewById(R.id.root_content);
        imageView = (ImageView) findViewById(R.id.image_view);

            phototext = findViewById(R.id.phototext);
            Intent intent = getIntent();
            String image_path = intent.getStringExtra("imagePath");
            Uri fileUri = Uri.parse(image_path);
            phototext.setImageURI(fileUri);

            wallpaper = findViewById(R.id.backwallpaper);
            textonphoto = findViewById(R.id.textonphoto);

            backbutton = (ImageView) findViewById(R.id.backbutton);
            backbutton.setOnClickListener(this);

            text = (ImageView) findViewById(R.id.text);
            text.setOnClickListener(this);

            back = (ImageView) findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openNext();
                }
            });

            Intent intenttxt = new Intent(this, EdittextActivity.class);
            startActivityForResult(intenttxt, ACTIVITY_RESULT_CODE);
    }

    private void openNext() {
        Intent intentwall = new Intent(this, BackgroundActivity.class);
        startActivityForResult(intentwall, 0);
    }

    private void takeScreenshot(ScreenshotType screenshotType) {
        Bitmap b = null;
        switch (screenshotType) {
            case FULL:
                b = ScreenshotUtils.getScreenShot(rootContent);
                break;
            case CUSTOM:
                //If Screenshot type is CUSTOM
                //fullPageScreenshot.setVisibility(View.INVISIBLE);//set the visibility to INVISIBLE of first button
                //hiddenText.setVisibility(View.VISIBLE);//set the visibility to VISIBLE of hidden text
                b = ScreenshotUtils.getScreenShot(rootContent);
                //After taking screenshot reset the button and view again
                //fullPageScreenshot.setVisibility(View.VISIBLE);//set the visibility to VISIBLE of first button again
               // hiddenText.setVisibility(View.INVISIBLE);//set the visibility to INVISIBLE of hidden text

                //NOTE:  You need to use visibility INVISIBLE instead of GONE to remove the view from frame else it wont consider the view in frame and you will not get screenshot as you required.
                break;
        }

        //If bitmap is not null
        if (b != null) {
            showScreenShotImage(b);//show bitmap over imageview

            File saveFile = ScreenshotUtils.getMainDirectoryName(this);//get the path to save screenshot
            File file = ScreenshotUtils.store(b, "screenshot" + screenshotType + ".jpg", saveFile);//save the screenshot to selected path
            shareScreenshot(file);//finally share screenshot
        } else
            //If bitmap is null show toast message
            Toast.makeText(this, "screenshot_take_failed", Toast.LENGTH_SHORT).show();

    }
    /*  Show screenshot Bitmap */
    private void showScreenShotImage(Bitmap b) {
        imageView.setImageBitmap(b);
    }

    /*  Share Screenshot  */
    private void shareScreenshot(File file) {
        Uri uri = Uri.fromFile(file);//Convert file path into Uri for sharing
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.sharing_text));
        intent.putExtra(Intent.EXTRA_STREAM, uri);//pass uri here
        startActivity(Intent.createChooser(intent, getString(R.string.share_title)));
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == ACTIVITY_RESULT_CODE) {
            String returnString = data.getStringExtra("text");
            String color= data.getStringExtra("Color");
            textonphoto.setText(returnString);
            textonphoto.setTextColor(Color.parseColor(color));
        }
        if (resultCode == RESULT_OK && requestCode == 0){
            int receivedImage = data.getIntExtra("wallpaper",0);
            wallpaper.setBackgroundResource(receivedImage);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.backbutton:
                finish();
                break;

            case R.id.custom_page_screenshot:
                takeScreenshot(ScreenshotType.CUSTOM);
                break;
        }
    }
}
