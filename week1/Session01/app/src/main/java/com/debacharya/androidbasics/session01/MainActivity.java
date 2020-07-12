package com.debacharya.androidbasics.session01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if(savedInstanceState != null) {

			TextView tv = findViewById(R.id.tv_one);
			String message = savedInstanceState.getString(Keystore.KEY_MESSAGE);

			tv.setText(message);
		}
	}

	public void setText(View view) {

		TextView tv = findViewById(R.id.tv_one);
		tv.setText("Hello, World!");
	}

	public void openContacts(View view) {

		Intent intent = new Intent();

		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(ContactsContract.Contacts.CONTENT_URI);
		startActivity(intent);
	}

	public void openActivity2(View view) {

		EditText et = findViewById(R.id.et_one);
		String message = et.getText().toString();
		Intent intent = new Intent(this, ActivityTwo.class);

		intent.putExtra(Keystore.KEY_MESSAGE, message);
		startActivity(intent);
	}

	public void openForResult(View view) {

		Intent intent = new Intent(this, ActivityTwo.class);

		startActivityForResult(intent, Keystore.KEY_RESULT_RC);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == Keystore.KEY_RESULT_RC && resultCode == Activity.RESULT_OK) {
			String message = data.getStringExtra(Keystore.KEY_MESSAGE);
			TextView tv = findViewById(R.id.tv_one);
			tv.setText(message);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("onPause", "onPause is called");
	}

	@Override
	protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {

		super.onSaveInstanceState(saveInstanceState);

		Log.d("OSIS", "OSIS is called");

		TextView tv = findViewById(R.id.tv_one);
		String message = tv.getText().toString();

		saveInstanceState.putString(Keystore.KEY_MESSAGE, message);
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("onStop", "onStop is called");
	}
}