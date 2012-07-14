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
}
