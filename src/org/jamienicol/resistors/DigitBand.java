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
import android.util.AttributeSet;

public class DigitBand extends Band {

	public DigitBand (Context context) {
		this (context, null);
	}

	public DigitBand (Context context, AttributeSet attrs) {
		this (context, attrs, 0);
	}

	public DigitBand (Context context, AttributeSet attrs, int defStyle) {
		super (context, attrs, defStyle);

		final int[] colour_ids = {
			context.getResources ().getColor (R.color.band_black),
			context.getResources ().getColor (R.color.band_brown),
			context.getResources ().getColor (R.color.band_red),
			context.getResources ().getColor (R.color.band_orange),
			context.getResources ().getColor (R.color.band_yellow),
			context.getResources ().getColor (R.color.band_green),
			context.getResources ().getColor (R.color.band_blue),
			context.getResources ().getColor (R.color.band_purple),
			context.getResources ().getColor (R.color.band_gray),
			context.getResources ().getColor (R.color.band_white)
		};

		setColours (colour_ids);
	}

	@Override
	public void processResistance (Resistance running_value) {
		double ohms = running_value.getOhms ();
		running_value.setOhms (ohms * 10 + getSelectedItemPosition ());
	}
}
