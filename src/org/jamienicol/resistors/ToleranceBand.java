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

public class ToleranceBand extends Band {

	private static final double[] tolerances = {
		0.05,
		0.1,
		0.25,
		0.5,
		1,
		2,
		5,
		10
	};

	public ToleranceBand (Context context) {
		this (context, null);
	}

	public ToleranceBand (Context context, AttributeSet attrs) {
		this (context, attrs, 0);
	}

	public ToleranceBand (Context context, AttributeSet attrs, int defStyle) {
		super (context, attrs, defStyle);

		final int[] colour_ids = {
			context.getResources ().getColor (R.color.band_gray),
			context.getResources ().getColor (R.color.band_purple),
			context.getResources ().getColor (R.color.band_blue),
			context.getResources ().getColor (R.color.band_green),
			context.getResources ().getColor (R.color.band_brown),
			context.getResources ().getColor (R.color.band_red),
			context.getResources ().getColor (R.color.band_gold),
			context.getResources ().getColor (R.color.band_silver)
		};

		setColours (colour_ids);
	}

	@Override
	public void processResistance (Resistance running_value) {
		double tolerance = tolerances[getSelectedItemPosition ()];
		running_value.setTolerance (tolerance);
	}
}
