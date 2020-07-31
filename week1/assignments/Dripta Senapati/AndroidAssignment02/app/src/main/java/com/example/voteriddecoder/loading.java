package com.example.voteriddecoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

public class loading {
    private Activity activity;
    private AlertDialog dialog;

    loading(Activity myactivity){
        activity=myactivity;
    }

    void startLoading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater layoutInflater= activity.getLayoutInflater();
        builder.setView(layoutInflater.inflate(R.layout.loading,null));
        builder.setCancelable(false);
        dialog=builder.create();
        dialog.show();
    }
    void dissmiss(){
        dialog.dismiss();
    }
}
