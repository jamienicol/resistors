/*
 * Copyright (C) 2012 Jamie Nicol <jamie@thenicols.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
			views[i].setLayoutParams (new Gallery.LayoutParams (280, Gallery.LayoutParams.FILL_PARENT));
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
