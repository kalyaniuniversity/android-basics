package com.debacharya.androidbasics.twictionary.provider;

import com.debacharya.androidbasics.twictionary.model.DictionaryEntry;

import java.util.ArrayList;
import java.util.List;

public class DictionaryProvider {

	private static final List<DictionaryEntry> DICTIONARY = new ArrayList<>();

	public static DictionaryEntry findMatch(String keyword) {

		for(DictionaryEntry entry : DICTIONARY)
			if(entry.getTwitterLabel().toLowerCase().equals(keyword.trim().toLowerCase()))
				return entry;

		return null;
	}

	public static void prepare() {

		DICTIONARY.add(
			new DictionaryEntry(
				"Rahul Gandhi",
				"pappu",
				"Rahul Gandhi is an Indian politician who was the President of the Indian National Congress from 16 December 2017 to 3 July 2019. He hails from a long line of politicians, known as the Nehru-Gandhi family, which has occupied a prominent place in the politics of India ever since the country gained independence in 1947.")
		);

		DICTIONARY.add(
			new DictionaryEntry(
				"Amish Devgan",
				"dalal",
				"Managing Editor #News18 Hindi ,Anchor #AarPaar on " +
					"@News18India " +
					" & #Takkar " +
					"@Cnbc_awaaz " +
					" Former Editor " +
					"@ZeeBusiness " +
					" , HT")
		);

		DICTIONARY.add(
			new DictionaryEntry(
				"Narendra Modi",
				"feku",
				"Narendra Damodardas Modi is an Indian politician serving as the 14th and current Prime Minister of India since 2014. He was the Chief Minister of Gujarat from 2001 to 2014 and is the Member of Parliament for Varanasi.")
		);

		DICTIONARY.add(
			new DictionaryEntry(
				"Mamata Banerjee",
				"didi",
				"Mamata Banerjee is an Indian politician who is serving as the 8th and current Chief Minister of West Bengal since 2011 being the first woman to hold the office. She founded the party All India Trinamool Congress in 1998 after separating from the Indian National Congress, and became its chairperson.")
		);

		DICTIONARY.add(
			new DictionaryEntry(
				"Kunal Kamra",
				"rahul ka kutta",
				"Kunal Kamra is an observational comedian known for his political commentary. In 2020, after an incident on IndiGo airlines where he \"allegedly heckled\" the Indian news anchor Arnab Goswami, he was banned by five Indian Airlines")
		);

		DICTIONARY.add(
			new DictionaryEntry(
				"Donald Trump",
				"doland",
				"Donald John Trump is the 45th and current president of the United States. Before entering politics, he was a businessman and television personality. Trump was born and raised in Queens, a borough of New York City, and received a bachelor's degree in economics from the Wharton School.")
		);

		DICTIONARY.add(
			new DictionaryEntry(
				"Arnab Goswami",
				"chamcha",
				"Arnab Ranjan Goswami is an Indian journalist and television news anchor, who is the editor and majority owner of the news channel Republic TV. He is also president of News Broadcasting Association's governing board.")
		);

		DICTIONARY.add(
			new DictionaryEntry(
				"Shashi Tharoor",
				"wife killer",
				"Shashi Tharoor (born 9 March 1956) is an Indian politician, writer and former international diplomat who has been serving as Member of Parliament, Lok Sabha from Thiruvananthapuram, Kerala, since 2009. He was formerly Under-Secretary General of the United Nations and contested for the post of Secretary-General in 2006.")
		);
	}
}
