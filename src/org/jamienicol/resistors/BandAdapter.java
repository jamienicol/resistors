package org.jamienicol.resistors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.TextView;

public class BandAdapter extends BaseAdapter {

	private TextView[] views;

	public BandAdapter (Context context, int colours[]) {

		views = new TextView[colours.length];
		for (int i = 0; i < colours.length; i++) {
			views[i] = new TextView (context);
			views[i].setBackgroundColor (colours[i]);
			views[i].setLayoutParams (new Gallery.LayoutParams (280, 50));
			System.out.println ("creating colour box view");
		}
	}

	public int getCount () {
		return views.length;
	}

	public Object getItem (int position) {
		return position;
	}

	public long getItemId (int position) {
		return position;
	}

	public View getView (int position, View convertView, ViewGroup parent) {
		return views[position];
	}
}
