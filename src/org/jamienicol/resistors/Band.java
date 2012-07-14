package org.jamienicol.resistors;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Gallery;

public class Band extends Gallery {

    private int[] colours = {};

	public Band (Context context) {
		this (context, null);
	}

	public Band (Context context, AttributeSet attrs) {
		this (context, attrs, 0);
	}

	public Band (Context context, AttributeSet attrs, int defStyle) {
		super (context, attrs, defStyle);
		setAdapter (new BandAdapter (context, colours));
	}
}
