package com.cyian.cyactionbar;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

@SuppressLint("NewApi")
public class LocationFound extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_found);
		

		// get action bar  
		ActionBar actionBar = getActionBar();
		
		actionBar.setIcon(R.drawable.map_icon_96x96);
		// Enabling Up / Back navigation
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
}