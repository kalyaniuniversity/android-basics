package com.example.pincode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pincode.modem.Meaning;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class List_Activity extends AppCompatActivity {

    private static  final String API_KEY="f914c6ecfdmsh02e3ea7cc8a710ap14c384jsnc39d2346f057";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        new Dictionary().execute(API_KEY);
    }
    public class Dictionary extends AsyncTask<String,Void, List<Meaning>>{
        @Override
        protected void onPreExecute(){
            Toast.makeText(getApplicationContext(), "Loading List of States with pincode", Toast.LENGTH_LONG).show();
        }

        @Override
        protected List<Meaning> doInBackground(String... values) {
            String apikey= values[0];
            List<Meaning> meanings = new ArrayList<>();

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"search\":\"Pun\"}");
            Request request = new Request.Builder()
                    .url("https://std.p.rapidapi.com/")
                    .post(body)
                    .addHeader("x-rapidapi-host", "std.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", apikey )
                    .addHeader("content-type", "application/json")
                    .addHeader("accept", "application/json")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                ResponseBody resposebody= response.body();
                String jsonString = resposebody.string();
                JSONArray jsonArray= new JSONArray(jsonString);

                for(int i=0 ;i< jsonArray.length();i++){
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    Meaning meaning = new Meaning(jsonObject);

                    meanings.add(meaning);
                }
                return meanings;

            } catch (IOException | JSONException e) {
               return null;
            }

        }

        @Override
        protected void onPostExecute(List<Meaning> meanings){
            ListView listView= findViewById(R.id.meaning);
            Listview_adapter adapter=new Listview_adapter(meanings);
            listView.setAdapter(adapter);
        }
    }
}