package org.jamienicol.resistors;

import android.content.Context;
import android.util.AttributeSet;
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
