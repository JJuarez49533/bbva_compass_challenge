package com.challenge.joel.bbva.util;

public class Constants {
    public static final int REQUEST_LOCATION_CODE = 99;
    public final static int PROXIMITY_RADIUS = 10000;
    public final static String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json";
    public final static String MAPS_KEY = "AIzaSyBGaOD1HmDfa2tFq5RG9Gp61qNTO4an5G4";

    public static String getUrl(double latitude , double longitude , String nearbyPlace) {

        StringBuilder googlePlaceUrl = new StringBuilder(BASE_URL);
        googlePlaceUrl.append("?location=").append(latitude).append(",").append(longitude);
        googlePlaceUrl.append("&radius=").append("10000");
        googlePlaceUrl.append("&type=").append("BBVA+Compass");
        googlePlaceUrl.append("&sensor=true");
        googlePlaceUrl.append("&key=").append(MAPS_KEY);

        String googlePlaceUrlString = googlePlaceUrl.toString();
        return googlePlaceUrlString;
    }

}
