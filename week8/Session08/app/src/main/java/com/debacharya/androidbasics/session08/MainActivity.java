package com.debacharya.androidbasics.session08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	private MyJobScheduler scheduler = new MyJobScheduler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		super.onStart();

		IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(this.scheduler, filter);
	}

	@Override
	protected void onStop() {
		super.onStop();
		unregisterReceiver(this.scheduler);
	}
}