package com.cp.dma.dma_android_xml;

import android.os.AsyncTask;
import android.util.Log;


public class AsyncTaskOne extends AsyncTask<String, Void, Void> {
	
	private String TAG = "AsyncTaskOne";

	
    @Override
    protected Void doInBackground(String... params) {
        Log.i(TAG, "doInBackground");
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Log.i(TAG, "onPostExecute");
    }

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.i(TAG, "onProgressUpdate");
    }

}
