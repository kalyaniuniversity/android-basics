package com.debacharya.androidbasics.session03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

	private String spName = "com.debacharya.androidbasics.session03sp";
	private static final String KEY_NAME = "name";
	private static final String KEY_GOD = "isGod";


	SharedPreferences sharedPreferences;
	SharedPreferences singlePref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.singlePref = getPreferences(Context.MODE_PRIVATE);
		this.sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
	}

	public void saveValue(View view) {

		SharedPreferences.Editor editor = this.sharedPreferences.edit();

		editor.putString(KEY_NAME, "Lord Abhijit");
		editor.putBoolean(KEY_GOD, true);

		boolean success = editor.commit();

		//editor.apply();

		Toast.makeText(getApplicationContext(), success ? "saved!" : "failed :(", Toast.LENGTH_SHORT).show();
	}

	public void viewValue(View view) {

		String value = this.sharedPreferences.getString(KEY_NAME, "No Name");
		TextView tv = findViewById(R.id.textView);

		tv.setText(value);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {

		int menuId = item.getItemId();
		String message;

		switch(menuId) {

			case R.id.menu_1: message = "menu one"; break;
			case R.id.menu_2: message = "menu_two"; break;
			case R.id.menu_3: message = "menu_three"; break;
			default: message = "menu wtf?"; break;
		}

		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

		return super.onOptionsItemSelected(item);
	}
}