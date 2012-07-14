package org.jamienicol.resistors;

public class Resistance {

	private double ohms;

	public Resistance () {
		ohms = 0;
	}

	public double getOhms () {
		return ohms;
	}

	public void setOhms (double ohms) {
		this.ohms = ohms;
	}

	@Override
	public String toString () {
		/* round to 2 decimal places.
		 * \u2126 is the Ohm symbol */
		return String.format ("%.2f \u2126", ohms);
	}
}
