package com.debacharya.androidbasics.session08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastListener extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Toast.makeText(context, "received broadcast", Toast.LENGTH_LONG).show();

		if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
			// do what you'd like to do here
		}

		if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
			// connection was changed
		}
	}
}
