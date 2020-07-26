package com.debacharya.androidbasics.session02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void showListViewExample(View view) {
		startActivity(new Intent(this, ListViewExample.class));
	}

	public void showRecyclerViewExample(View view) {
		startActivity(new Intent(this, RecyclerExample.class));
	}
}





/*


	[{
		...
	}, {
		...
	}]

 */