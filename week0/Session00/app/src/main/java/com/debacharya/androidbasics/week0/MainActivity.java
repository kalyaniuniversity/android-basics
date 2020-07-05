package com.debacharya.androidbasics.week0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();

		// get the textView instance from the associated layout using findViewById
		TextView textView = findViewById(R.id.tv_one);
		String text = getText(R.string.cs50).toString();

		// programmatically set the text of TextView
		textView.setText(text);
	}

	public void changeText(View view) {

		EditText editText = findViewById(R.id.et_one);
		TextView textView = findViewById(R.id.tv_one);

		//get the text written in the editText input field
		String text = editText.getText().toString();

		if(text.equals(""))
			text = getText(R.string.cs50).toString();

		textView.setText(text);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}