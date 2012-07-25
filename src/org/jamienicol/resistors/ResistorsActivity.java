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
import android.widget.TextView;

public class ResistorsActivity extends Activity
{

	private Band hundredsDigitBand;
	private Band tensDigitBand;
	private Band onesDigitBand;
	private Band multiplierBand;
	private Band toleranceBand;

	private TextView resistanceView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		hundredsDigitBand = (Band)findViewById (R.id.hundredsDigitBand);
		tensDigitBand = (Band)findViewById (R.id.tensDigitBand);
		onesDigitBand = (Band)findViewById (R.id.onesDigitBand);
		multiplierBand = (Band)findViewById (R.id.multiplierBand);
		toleranceBand = (Band)findViewById (R.id.toleranceBand);
		resistanceView = (TextView)findViewById (R.id.resistanceView);

		SimpleOnPageChangeListener listener = new SimpleOnPageChangeListener () {
			public void onPageSelected (int position) {
				updateResistance ();
			}
		};

		hundredsDigitBand.setOnPageChangeListener (listener);
		tensDigitBand.setOnPageChangeListener (listener);
		onesDigitBand.setOnPageChangeListener (listener);
		multiplierBand.setOnPageChangeListener (listener);
		toleranceBand.setOnPageChangeListener (listener);

		updateResistance ();
	}

	private void updateResistance () {
		final Resistance r = new Resistance ();
		hundredsDigitBand.processResistance (r);
		tensDigitBand.processResistance (r);
		onesDigitBand.processResistance (r);
		multiplierBand.processResistance (r);
		toleranceBand.processResistance (r);

		resistanceView.setText (r.toString ());
	}
}
