package com.example.imagesearch;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageResult {
	private String fullUrl;
	private String thumbUrl;
	
	public ImageResult(JSONObject json) throws JSONException{
		this.fullUrl = json.toString();
		this.thumbUrl = json.toString();
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
