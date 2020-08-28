package com.debacharya.androidbasics.session05;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.debacharya.androidbasics.session05.model.FriendsContract;
import com.debacharya.androidbasics.session05.model.FriendsDBHelper;

public class MainActivity extends AppCompatActivity {

	private FriendsDBHelper dbHelper;
	private SQLiteDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.dbHelper = new FriendsDBHelper(this);
		this.database = this.dbHelper.getWritableDatabase();

		Cursor cursor = this.dbHelper.getAllFriends(this.database);
		int rows = cursor.getCount();

		for(int i = 0; i < rows; i++) {
			if(cursor.moveToPosition(i)) {

				int columnIndexFirstname = cursor.getColumnIndex(FriendsContract.FriendsEntry.COLUMN_FIRSTNAME);
				int columnIndexLastName = cursor.getColumnIndex(FriendsContract.FriendsEntry.COLUMN_LASTNAME);

				String firstname = cursor.getString(columnIndexFirstname);
				String lastname = cursor.getString(columnIndexLastName);
			}
		}
	}


}