package com.cp.dma.dma_android_xml;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;


public class AsyncTaskService extends AsyncTask<String, Integer, String> {
	
	private String TAG = "AsyncTaskService";
	final static String SERVICE_ADDRESS = "http://api.openweathermap.org/data/2.5/forecast?";
	final static String CITY_KEY_TEXT = "q=";
	final static String MEASUREMENTTYPE_KEY_TEXT = "&units=";
	final static String CITY_KEY_TEXT_TEST = "melbourne";
	final static String MEASUREMENTTYPE_KEY_TEXT_TEST = "metric";



	
    @Override
    protected String doInBackground(String... params) {
        Log.i(TAG, "doInBackground");
        
        String address = SERVICE_ADDRESS + CITY_KEY_TEXT + CITY_KEY_TEXT_TEST + ",au" + MEASUREMENTTYPE_KEY_TEXT + MEASUREMENTTYPE_KEY_TEXT_TEST;		
		StringBuilder response = new StringBuilder();
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(address);
		try {
			HttpResponse execute = client.execute(httpGet);
			InputStream content = execute.getEntity().getContent();

			BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
			String bufferString = "";
			while ((bufferString = buffer.readLine()) != null) {
				response.append(bufferString);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.toString();
        
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i(TAG, "onPostExecute");
    }

//    @Override
//    protected void onPreExecute() {
//        Log.i(TAG, "onPreExecute");
//    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.i(TAG, "onProgressUpdate");
    }

}
