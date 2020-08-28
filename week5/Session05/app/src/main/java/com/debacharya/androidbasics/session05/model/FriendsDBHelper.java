package com.debacharya.androidbasics.session05.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FriendsDBHelper extends SQLiteOpenHelper {

	public FriendsDBHelper(Context context) {
		super(
			context,
			FriendsContract.DB_NAME,
			null,
			FriendsContract.VERSION
		);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {

		String SQL_CREATE_FRIENDS_TABLE = "CREATE TABlE IF NOT EXISTS " +
											FriendsContract.FriendsEntry.TABLE_NAME +
											" (" +
											FriendsContract.FriendsEntry._ID +
											" PRIMARY KEY AUTOINCREMENT NOT NULL, " +
											FriendsContract.FriendsEntry.COLUMN_FIRSTNAME +
											" TEXT NOT NULL, " +
											FriendsContract.FriendsEntry.COLUMN_LASTNAME +
											" TEXT DEFAULT NULL)";

		sqLiteDatabase.execSQL(SQL_CREATE_FRIENDS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

		String SQL_DELETE_FRIENDS_TABLE = "DROP TABLE IF EXISTS " + FriendsContract.FriendsEntry.TABLE_NAME;

		sqLiteDatabase.execSQL(SQL_DELETE_FRIENDS_TABLE);
		this.onCreate(sqLiteDatabase);
	}

	public Cursor getAllFriends(SQLiteDatabase db) {
		return db.query(
			FriendsContract.FriendsEntry.TABLE_NAME,
			null,
			null,
			null,
			null,
			null,
			null
		);
	}
}

/*
	Friends
	2 columns
	100 rows

	QUERY -> 10 rows

	F1
	2 columns
	20 rows

	SELECT * FROM Friends

	Friends
 */
