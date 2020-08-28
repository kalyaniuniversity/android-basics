package com.debacharya.androidbasics.session05.model;

import android.provider.BaseColumns;

public final class FriendsContract {

	public static final String DB_NAME = "friend_db";
	public static final int VERSION = 1;

	public static final class FriendsEntry implements BaseColumns {
		public static final String TABLE_NAME = "friends";
		public static final String COLUMN_FIRSTNAME = "firstname";
		public static final String COLUMN_LASTNAME = "lastname";
	}
}
