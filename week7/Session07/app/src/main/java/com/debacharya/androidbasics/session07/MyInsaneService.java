package com.debacharya.androidbasics.session07;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyInsaneService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startID) {

		System.out.println("in on start command");

		stopSelf();

		return super.onStartCommand(intent, flags, startID);
	}


	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("in on bind");
		return null;
	}

	@Override
	public void onDestroy() {
		System.out.println("in on destroy");
	}
}
