package com.edu.mmu.capstone.cherryx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<String, Void, String> {
	
	

	@Override
	protected String doInBackground(String... params) {
		try {
			Log.d("junk", params[0]);
			URL url = new URL(params[0]);
			URLConnection connection = url.openConnection();
			HttpURLConnection conn = (HttpURLConnection)connection;
			int responseCode = conn.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
			InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader reader = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				
				return sb.toString();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		
		super.onPostExecute(result);
	}

}
