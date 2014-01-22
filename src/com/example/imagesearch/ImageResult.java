package com.example.imagesearch;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ImageResult implements Serializable {
	private static final long serialVersionUID = -6352886494570520471L;
	private String fullUrl;
	private String thumbUrl;
	
	public ImageResult(JSONObject json) throws JSONException{
		this.fullUrl = json.getString("url");
		this.thumbUrl = json.getString("tbUrl");
		Log.d("DEBUG", "Full URL -> " + this.fullUrl);
		Log.d("DEBUG", "Thumb URL -> " + this.thumbUrl);
	}
	
	public String getFullUrl() {
		return fullUrl;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}

	public String toString() {
		return this.thumbUrl;
	}

	public static ArrayList<ImageResult> fromJSONArray(JSONArray array) {
		ArrayList<ImageResult> results = new ArrayList<ImageResult>();
		for(int i = 0; i < array.length(); i++){
			try{
				results.add(new ImageResult(array.getJSONObject(i)));
			}catch (JSONException e){
				e.printStackTrace();
			}
		}
		return results;
	}
	
}
