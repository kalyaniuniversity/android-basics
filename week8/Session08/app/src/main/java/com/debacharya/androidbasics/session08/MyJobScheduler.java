package com.debacharya.androidbasics.session08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyJobScheduler extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {

			boolean noConnection = intent.getBooleanExtra(
				ConnectivityManager.EXTRA_NO_CONNECTIVITY,
				false
			);

			Toast.makeText(
				context,
				noConnection ? "Not Connected" : "Connected",
				Toast.LENGTH_SHORT).show();
		}
	}
}
