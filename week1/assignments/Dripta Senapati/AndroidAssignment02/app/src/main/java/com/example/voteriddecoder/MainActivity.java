package com.example.voteriddecoder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button uploadimg,chooseimg,clear;
    private ImageView img;
    private int IMG_REQUEST=1;
    private Bitmap bitmap;
    private String url="http://35.193.57.0/voterId";
    private boolean IMG_HOLDER_ID=false;
    final loading Loading = new loading(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
        chooseimg=findViewById(R.id.imgchoose);
        uploadimg=findViewById(R.id.imgupload);
        clear=findViewById(R.id.clear);
        chooseimg.setOnClickListener(this);
        uploadimg.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgchoose:
                selectimage();
                break;
            case R.id.imgupload:
                if (IMG_HOLDER_ID == false){
                    Toast.makeText(MainActivity.this,"Please Select an image",Toast.LENGTH_LONG).show();
                }else{
                    Loading.startLoading();
                    uploadimage();
                }
                break;
            case R.id.clear:
                if (IMG_HOLDER_ID==true){
                    img.setImageDrawable(null);
                    IMG_HOLDER_ID=false;
                }else{
                    Toast.makeText(MainActivity.this,"No image is selected",Toast.LENGTH_LONG).show();
                }

        }
    }


    private void selectimage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMG_REQUEST && resultCode==RESULT_OK && data != null){
            IMG_HOLDER_ID=true;
            Uri path=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void uploadimage() {
        Log.i("msg","HEllo");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            String Response = jsonObject.getString("Response");
                            Loading.dissmiss();
                            openactivity(Response);
//                            Log.i("Result",Response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("msg2", String.valueOf(error));
                Loading.dissmiss();
                Toast.makeText(MainActivity.this,"Server not responding.",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("front",imagetostring(bitmap));
                return params;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);
    }
    private void openactivity(String massage){
        Intent intent = new Intent(this, Result.class);
        intent.putExtra(Keystore.KEY_MESSAGE,massage);
        startActivity(intent);

    }
    private String imagetostring(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgbyte= byteArrayOutputStream.toByteArray();
//        Log.i("msg3", Base64.encodeToString(imgbyte,Base64.DEFAULT));
        return Base64.encodeToString(imgbyte,Base64.DEFAULT);
    }
}