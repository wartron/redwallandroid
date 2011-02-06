package com.kudzu.android.redwall.pro;


import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class WallpaperAdapter extends ArrayAdapter<Wallpaper> {
	int resource;

	public WallpaperAdapter(Context _context, int _resource, List<Wallpaper> _items) {
		super(_context, _resource, _items);
		resource = _resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout newsView;
		Wallpaper item = getItem(position);
		
		String title = item.getTitle();
		String url = item.getImg();
		Bitmap thumb = item.getThumb();



		if (convertView == null) {
			newsView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, newsView, true);
		} else {
			newsView = (LinearLayout) convertView;
		}

		
		TextView txtTitle = (TextView)newsView.findViewById(R.id.txtTitle);
		
		ImageView imgView = (ImageView)newsView.findViewById(R.id.thumb);

		imgView.setImageBitmap(thumb);
		txtTitle.setText(title);
		
		return newsView;
	}
}