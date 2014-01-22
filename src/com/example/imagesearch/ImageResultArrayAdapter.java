package com.example.imagesearch;

import java.util.List;

import com.loopj.android.image.SmartImageView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ImageResultArrayAdapter extends ArrayAdapter<ImageResult> {

	public ImageResultArrayAdapter(Context context, List<ImageResult> images) {
		super(context, R.layout.item_image_result, images);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageResult imageInfo = this.getItem(position);
		SmartImageView svImage;
		if(convertView ==null){
			//Log.d("DEBUG", "GOT NULL");
			LayoutInflater inflater = LayoutInflater.from(getContext());
			svImage = (SmartImageView) inflater.inflate(R.layout.item_image_result, parent, false);
		} else {
			svImage = (SmartImageView) convertView;
			svImage.setImageResource(android.R.color.transparent);
		}
		if(svImage == null){
			Log.d("DEBUG", "GOT NULL");
		}
		
		svImage.setImageUrl(imageInfo.getThumbUrl());
		
		return svImage;
	}

}
