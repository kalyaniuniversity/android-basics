package com.debacharya.androidbasics.session02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.debacharya.androidbasics.session02.model.Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ListViewExample extends AppCompatActivity {

	private static final String API_KEY = "7aa4afb855mshf1e9bfd4e550ab3p1d765fjsn33a30a4a3188";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_example);
		new SomeTask().execute(API_KEY);
	}

	public class SomeTask extends AsyncTask<String, Void, List<Team>> {

		@Override
		protected void onPreExecute() {
			Toast.makeText(getApplicationContext(), "Loading FIFA Teams", Toast.LENGTH_LONG).show();
		}

		@Override
		protected List<Team> doInBackground(String... values) {

			String apiKey = values[0];
			List<Team> teams = new ArrayList<>();

			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder()
				.url("https://montanaflynn-fifa-world-cup.p.rapidapi.com/teams")
				.get()
				.addHeader("x-rapidapi-host", "montanaflynn-fifa-world-cup.p.rapidapi.com")
				.addHeader("x-rapidapi-key", apiKey)
				.addHeader("accepts", "json")
				.build();

			try {

				Response response = client.newCall(request).execute();
				ResponseBody responseBody = response.body();
				String jsonString = responseBody.string();
				JSONArray jsonArray = new JSONArray(jsonString);

				for(int i = 0; i < jsonArray.length(); i++) {

					JSONObject jsonObject = jsonArray.getJSONObject(i);
					Team team = new Team(jsonObject);

					teams.add(team);
				}

				return teams;
			} catch(IOException | JSONException e) {
				return null;
			}
		}

		@Override
		protected void onPostExecute(List<Team> teams) {

			ListView listView = findViewById(R.id.lv_teams);

//			ArrayAdapter<Team> adapter = new ArrayAdapter<>(
//				getApplicationContext(),
//				R.layout.simple_textview,
//				teams
//			);

			TeamLVAdapter adapter = new TeamLVAdapter(teams);

			listView.setAdapter(adapter);
		}
	}
}