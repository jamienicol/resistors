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
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public abstract class Band extends ViewPager {

	private int defaultColourIndex;

	public Band (Context context) {
		this (context, null);
	}

	public Band (Context context, AttributeSet attrs) {
		this (context, attrs, 0);
	}

	public Band (Context context, AttributeSet attrs, int defStyle) {
		super (context, attrs);

		TypedArray a = context.obtainStyledAttributes (attrs,
		                                               R.styleable.Band,
		                                               defStyle,
		                                               0);
		defaultColourIndex = a.getInt (R.styleable.Band_default_colour_index, 0);

		setColours (new int[] {});
	}

	/* This function takes the running value of resistance for all previous
	 * bands and adds its own contribution to the overall resistance.
	 *
	 * Should be called on each band from left to right as you would read
	 * the resistor. i.e. The digit bands, from most significant to least
	 * significant, followed by the multiplier, the tolerance, and finally
	 * the temperature coefficient. */
	public abstract void processResistance (Resistance running_value);

	protected void setColours (int[] colours) {
		setAdapter (new BandAdapter (colours));
		setCurrentItem (defaultColourIndex, false);
	}
}
