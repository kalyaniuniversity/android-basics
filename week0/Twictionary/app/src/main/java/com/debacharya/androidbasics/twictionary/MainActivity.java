package com.debacharya.androidbasics.twictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.debacharya.androidbasics.twictionary.model.DictionaryEntry;
import com.debacharya.androidbasics.twictionary.provider.DictionaryProvider;

public class MainActivity extends AppCompatActivity {

	private static final String KEY_ENTRY_LABEL = "entry_label";
	private static final String KEY_TWEET_LABEL = "tweet_label";
	private static final String KEY_ENTRY_DESC = "entry_desc";
	private static final String KEY_SEARCH_TERM = "search_term";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if(savedInstanceState != null) {

			String entryLabel = savedInstanceState.getString(KEY_ENTRY_LABEL);
			String tweetLabel = savedInstanceState.getString(KEY_TWEET_LABEL);
			String entryDesc = savedInstanceState.getString(KEY_ENTRY_DESC);
			String searchTerm = savedInstanceState.getString(KEY_SEARCH_TERM);

			((TextView) findViewById(R.id.tv_entry_label)).setText(entryLabel);
			((TextView) findViewById(R.id.tv_entry_tweet_label)).setText(tweetLabel);
			((TextView) findViewById(R.id.tv_entry_desc)).setText(entryDesc);
			((EditText) findViewById(R.id.et_search_text)).setText(searchTerm);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		DictionaryProvider.prepare();
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {

		super.onSaveInstanceState(savedInstanceState);

		String entryLabel = ((TextView) findViewById(R.id.tv_entry_label)).getText().toString();
		String tweetLabel = ((TextView) findViewById(R.id.tv_entry_tweet_label)).getText().toString();
		String entryDesc = ((TextView) findViewById(R.id.tv_entry_desc)).getText().toString();
		String searchTerm = ((EditText) findViewById(R.id.et_search_text)).getText().toString();

		if(!entryLabel.equals(""))
			savedInstanceState.putString(KEY_ENTRY_LABEL, entryLabel);

		if(!tweetLabel.equals(""))
			savedInstanceState.putString(KEY_TWEET_LABEL, tweetLabel);

		if(!entryDesc.equals(""))
			savedInstanceState.putString(KEY_ENTRY_DESC, entryDesc);

		if(!searchTerm.equals(""))
			savedInstanceState.putString(KEY_SEARCH_TERM, searchTerm);
	}

	@Override
	public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
		// this bundle is also passed to onCreate
		super.onRestoreInstanceState(savedInstanceState);
	}

	public void search(View view) {

		EditText editText = findViewById(R.id.et_search_text);
		String searchText = editText.getText().toString();

		if(searchText.equals("")) {

			Toast.makeText(
				getApplicationContext(),
				getText(R.string.no_search_text).toString(),
				Toast.LENGTH_SHORT
			).show();

			return;
		}

		DictionaryEntry entry = DictionaryProvider.findMatch(searchText);

		if(entry == null) {

			Toast.makeText(
				getApplicationContext(),
				getText(R.string.no_entry_found).toString(),
				Toast.LENGTH_SHORT
			).show();

			return;
		}

		TextView entryTextView = findViewById(R.id.tv_entry_label);
		TextView tweetLableTextView = findViewById(R.id.tv_entry_tweet_label);
		TextView descTextView = findViewById(R.id.tv_entry_desc);
		String tweetLabel = "( " + entry.getTwitterLabel() + " )";

		entryTextView.setText(entry.getLabel());
		tweetLableTextView.setText(tweetLabel);
		descTextView.setText(entry.getDescription());
		editText.setText("");
		this.hideKeyboard();
	}

	private void hideKeyboard() {

		InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
		View view = getCurrentFocus();

		if(view == null)
			view = new View(this);

		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
}