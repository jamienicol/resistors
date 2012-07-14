package org.jamienicol.resistors;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Gallery;

public class Band extends Gallery {

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

	protected void setColours (int[] colours) {
		setAdapter (new BandAdapter (context, colours));
	}
}
