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

import java.text.DecimalFormat;

public class Resistance {

	private double ohms;
	private double tolerance;

	public Resistance () {
		ohms = 0;
		tolerance = 0;
	}

	public double getOhms () {
		return ohms;
	}

	public void setOhms (double ohms) {
		this.ohms = ohms;
	}

	public double getTolerance () {
		return tolerance;
	}

	public void setTolerance (double tolerance) {
		this.tolerance = tolerance;
	}

	@Override
	public String toString () {

		/* calculate the significand and base 10 exponent for
		 * the value ohms. limit the exponent to multiples of 3 */
		double significand = ohms;
		int exponent = 0;
		if (significand != 0) {

			while (significand < 1.0) {
				significand *= 1000;
				exponent -= 3;
			}

			while (significand >= 1000.0) {
				significand /= 1000;
				exponent += 3;
			}
		}

		/* select the SI prefix for the calculated exponent */
		String prefix;
		switch (exponent) {
		case -3:
			prefix = "m";
			break;
		case 0:
			prefix = "";
			break;
		case 3:
			prefix = "k";
			break;
		case 6:
			prefix = "M";
			break;
		case 9:
			prefix = "G";
			break;
		default:
			prefix = "";
			break;
		}

		/* round the significand to 2 decimal places at most,
		 * append the prefix and the ohm symbol,
		 * then append the tolerance as a plus or minus percentage */
		DecimalFormat significandFormat = new DecimalFormat ("0.##");
		DecimalFormat toleranceFormat = new DecimalFormat ("0.##");
		return String.format ("%s %s\u2126 \u00B1%s%%",
		                      significandFormat.format (significand),
		                      prefix,
		                      toleranceFormat.format (tolerance));
	}
}
