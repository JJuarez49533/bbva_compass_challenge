package com.challenge.joel.bbva;

import android.os.AsyncTask;
import android.util.Log;

import com.challenge.joel.bbva.util.DataParser;
import com.challenge.joel.bbva.util.DownloadURL;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;


class NearbyPlacesTask extends AsyncTask<String, String, String> {

    private String googlePlacesData;
    private WeakReference<NearbyPlacesTask.MapListener> reference;
    String url;

    public NearbyPlacesTask(NearbyPlacesTask.MapListener listener) {
        this.reference = new WeakReference<MapListener>(listener);
    }

    @Override
    protected String doInBackground(String... urls){
        url = urls[0];

        DownloadURL downloadURL = new DownloadURL();
        try {
            googlePlacesData = downloadURL.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String s){

        List<HashMap<String, String>> nearbyPlaceList;
        DataParser parser = new DataParser();
        nearbyPlaceList = parser.parse(s);
        Log.d("nearbyplacesdata","called parse method");
        MapListener listener = reference.get();
        listener.onMapsResult(nearbyPlaceList);
    }

    public interface MapListener {
        void onMapsResult(List<HashMap<String, String>> nearbyPlaceList);
    }
}
