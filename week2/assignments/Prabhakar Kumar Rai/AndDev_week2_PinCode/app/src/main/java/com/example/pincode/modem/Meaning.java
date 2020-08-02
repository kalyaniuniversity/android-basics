package com.example.pincode.modem;

import org.json.JSONException;
import org.json.JSONObject;

public class Meaning {

    private final String textMeaning;
    private final String pincode;

    public Meaning(JSONObject jsonObject) throws JSONException {
        this.textMeaning = jsonObject.getString("state");
        this.pincode = jsonObject.getString("std");
    }

    public String getPincode() {
        return pincode;
    }

    public String getTextMeaning() {
        return textMeaning;
    }

    @Override
    public String toString() {
        return "Train{" +
                "name='" + textMeaning + '\'' +
                '}';
    }
}
