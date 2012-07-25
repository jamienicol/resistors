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

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ResistorsActivity extends Activity
{
	private List<Band> bands;
	private TextView resistanceView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bands = new ArrayList<Band> ();

		SimpleOnPageChangeListener listener = new SimpleOnPageChangeListener () {
			public void onPageSelected (int position) {
				updateResistance ();
			}
		};

		/* find all the bands in the layout */
		ViewGroup mainLayout = (ViewGroup)findViewById (R.id.mainLayout);
		for (int i = 0; i < mainLayout.getChildCount (); i++) {
			View view = mainLayout.getChildAt (i);
			if (view instanceof Band) {
				Band band = (Band)view;
				bands.add (band);
				band.setOnPageChangeListener (listener);
			}
		}

		resistanceView = (TextView)findViewById (R.id.resistanceView);

		updateResistance ();
	}

	private void updateResistance () {
		final Resistance r = new Resistance ();
		for (Band band : bands) {
			band.processResistance (r);
		}
		resistanceView.setText (r.toString ());
	}
}
