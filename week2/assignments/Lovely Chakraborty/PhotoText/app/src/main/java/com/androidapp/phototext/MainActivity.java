package com.androidapp.phototext;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import static android.os.Environment.DIRECTORY_DCIM;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView pic;
    ImageView photo;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView writetext;
    ImageView colorview;
    ImageView back;
    LinearLayout wall;
    private String filePath;
    private String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = (ImageView) findViewById(R.id.photo);
        wall = (LinearLayout) findViewById(R.id.wall);

        pic = (ImageView) findViewById(R.id.pic);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        writetext = (ImageView) findViewById(R.id.writephoto);
        writetext.setOnClickListener(this);

        colorview = (ImageView) findViewById(R.id.colorView);
        colorview.setOnClickListener(this);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNext();
            }
        });
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private void openNext() {
        Intent intentwall = new Intent(this, BackgroundActivity.class);
        startActivityForResult(intentwall, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            photo.setImageURI(imageUri);
        }
        if (resultCode == RESULT_OK && requestCode == 0){
            int resId = data.getIntExtra("wallpaper", 0);
            wall.setBackgroundResource(resId);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.writephoto:
            case R.id.colorView:
                Intent intent_text = new Intent(MainActivity.this, TexteditorActivity.class);
                if(imageUri == null){
                    startActivity(intent_text);
                }
                else {
                    intent_text.putExtra("imagePath", imageUri.toString());
                    startActivity(intent_text);
                }
                break;
        }
    }

}

//            /*     ----------- */
    //        File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DCIM)+"/PhotoText");
//        boolean success = true;
//        if(!file.exists()) {
//            Toast.makeText(getApplicationContext(),"Directory does not exist, create it",
//                    Toast.LENGTH_LONG).show();
//        }
//        if(success) {
//            Toast.makeText(getApplication(),"Directory created",
//                    Toast.LENGTH_LONG).show();
//        }
//        else {
//            Toast.makeText(this,"Failed to create Directory",
//                    Toast.LENGTH_LONG).show();
//        }



//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            //file path of captured image
//            filePath = cursor.getString(columnIndex);
//            //file path of captured image
//            File f = new File(filePath);
//            filename = f.getName();
//
//            Toast.makeText(getApplicationContext(), "Your Path:" + filePath, Toast.LENGTH_LONG).show();
//            Toast.makeText(getApplicationContext(), "Your Filename:" + filename, Toast.LENGTH_LONG).show();
//            cursor.close();
//
//            //Convert file path into bitmap image using below line.
//            // yourSelectedImage = BitmapFactory.decodeFile(filePath);
//            Toast.makeText(getApplicationContext(), "Your image" + imageUri, Toast.LENGTH_LONG).show();
//
//            //put bitmapimage in your imageview
//            //yourimgView.setImageBitmap(yourSelectedImage);
//
//            Savefile(filename, filePath);



//    public void Savefile(String name, String path) {
//        File file = new File(Environment.getExternalStorageDirectory()+"/PhotoText");
//        boolean success = true;
//        if(!file.exists()) {
//            Toast.makeText(getApplicationContext(),"Directory does not exist, create it",
//                    Toast.LENGTH_LONG).show();
//        }
//        if(success) {
//            Toast.makeText(getApplication(),"Directory created",
//                    Toast.LENGTH_LONG).show();
//        }
//        else {
//            Toast.makeText(this,"Failed to create Directory",
//                    Toast.LENGTH_LONG).show();
//        }
//    }
            /*     ----------- */
//        if (resultCode == RESULT_OK && requestCode == 0){
//            int resId = data.getIntExtra("wallpaper", 0);
//            wall.setBackgroundResource(resId);
//        }
//    }


