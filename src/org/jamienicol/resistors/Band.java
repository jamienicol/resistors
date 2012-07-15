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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

public abstract class Band extends Gallery {

	private Context context;

	public Band (Context context) {
		this (context, null);
	}

	public Band (Context context, AttributeSet attrs) {
		this (context, attrs, 0);
	}

	public Band (Context context, AttributeSet attrs, int defStyle) {
		super (context, attrs, defStyle);

		this.context = context;

		setColours (new int[] {});
	}

	/* Limit the length of a fling gesture to 1 colour.
	 * Otherwise it's basically impossible to select a specific colour. */
	@Override
	public boolean onFling (MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

		/* fake a left or right keypress depending on the direction
		 * of the fling. I think use movePrevious () and moveNext ()
		 * would be cleaner than faking keypresses, but they are
		 * package scope. they're short functions (barely longer than
		 * this comment) so maybe they should be reproduced here.
		 * something just feels wrong faking keypresses,
		 * but it will do for now. */
		if (e1.getX () < e2.getX ()) {
			onKeyDown (KeyEvent.KEYCODE_DPAD_LEFT, null);
			return true;
		} else if (e1.getX () > e2.getX ()) {
			onKeyDown (KeyEvent.KEYCODE_DPAD_RIGHT, null);
			return true;
		}

		return false;
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
		setAdapter (new BandAdapter (context, colours));
	}
}
