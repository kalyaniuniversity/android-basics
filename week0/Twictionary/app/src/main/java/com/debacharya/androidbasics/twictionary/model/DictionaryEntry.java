package com.debacharya.androidbasics.twictionary.model;

public class DictionaryEntry {

	private final String label;
	private final String twitterLabel;
	private final String description;

	public DictionaryEntry(String label, String twitterLabel, String description) {
		this.label = label;
		this.twitterLabel = twitterLabel;
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public String getTwitterLabel() {
		return twitterLabel;
	}

	public String getDescription() {
		return description;
	}
}
