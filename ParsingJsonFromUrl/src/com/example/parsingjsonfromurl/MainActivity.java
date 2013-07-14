package com.example.parsingjsonfromurl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new AsyncTask<Void, String, Void>(){

			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				
				//definiamo i parametri fondamentali
				final String url = "http://www.likeadrop.com/json-categorie";
				final String jsonArrayName = "taxonomies";
				final String jsonObjectName = "taxonomy";
				
				try{
					JSONObject jobj = getJsonObject(url);
					JSONArray jsonArray = jobj.getJSONArray(jsonArrayName);
					for(int i = 0; i < jsonArray.length(); i++){
						JSONObject currentObj = jsonArray.getJSONObject(i);
						JSONObject finalObject = currentObj.getJSONObject(jsonObjectName);
						Log.d("JOBJ", finalObject.getString("name"));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					
				}
				
				return null;
			}
			
		}.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private static JSONObject getJsonObject(String path) throws IOException, JSONException{
		URL url = new URL(path);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			Gson gson = new Gson();
			Object jobj = gson.fromJson(reader, Object.class);
			return new JSONObject(jobj.toString());
		}
		finally{
			
		}
	}

}





















