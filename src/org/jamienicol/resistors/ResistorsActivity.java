package org.jamienicol.resistors;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResistorsActivity extends Activity
{

	private Band hundredsDigitBand;
	private Band tensDigitBand;
	private Band onesDigitBand;
	private Band multiplierBand;

	private TextView resistanceView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		hundredsDigitBand = (Band)findViewById (R.id.hundredsDigitBand);
		tensDigitBand = (Band)findViewById (R.id.tensDigitBand);
		onesDigitBand = (Band)findViewById (R.id.onesDigitBand);
		multiplierBand = (Band)findViewById (R.id.multiplierBand);
		resistanceView = (TextView)findViewById (R.id.resistanceView);

		OnItemSelectedListener listener = new OnItemSelectedListener () {
			public void onItemSelected (AdapterView parent, View view, int position, long id) {
				updateResistance ();
			}

			public void onNothingSelected (AdapterView parent) {
			}
		};

		hundredsDigitBand.setOnItemSelectedListener (listener);
		tensDigitBand.setOnItemSelectedListener (listener);
		onesDigitBand.setOnItemSelectedListener (listener);
		multiplierBand.setOnItemSelectedListener (listener);
	}

	private void updateResistance () {
		final Resistance r = new Resistance ();
		hundredsDigitBand.processResistance (r);
		tensDigitBand.processResistance (r);
		onesDigitBand.processResistance (r);
		multiplierBand.processResistance (r);

		resistanceView.setText (r.toString ());
	}
}
