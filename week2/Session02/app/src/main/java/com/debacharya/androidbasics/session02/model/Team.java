package com.debacharya.androidbasics.session02.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Team {

	private final String key;
	private final String title;
	private final String code;

	public Team(JSONObject jsonObject) throws JSONException {
		this.key = jsonObject.getString("key");
		this.title = jsonObject.getString("title");
		this.code = jsonObject.getString("code");
	}

	public String getKey() {
		return key;
	}

	public String getTitle() {
		return title;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return this.title;
	}
}
