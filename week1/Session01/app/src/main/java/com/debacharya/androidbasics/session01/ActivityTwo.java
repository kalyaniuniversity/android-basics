package com.debacharya.androidbasics.session01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		Intent intent = getIntent();

		if(intent != null) {
			String message = intent.getStringExtra(Keystore.KEY_MESSAGE);
			TextView tv = findViewById(R.id.tv_two);

			tv.setText(message);
		}
	}

	public void openMainActivity(View view) {

		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void returnResult(View view) {

		Intent intent = new Intent();
		EditText et = findViewById(R.id.et_two);
		String message = et.getText().toString();

		intent.putExtra(Keystore.KEY_MESSAGE, message);
		setResult(ActivityTwo.RESULT_OK, intent);
		finish();
	}
}