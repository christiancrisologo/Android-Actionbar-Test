/**
 * CREATED BY CYIANITE24 - for demo purposes
 */
package com.cyian.cyactionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener{

	private MenuItem menuItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "selected"  + arg0.getId(), Toast.LENGTH_SHORT)
		.show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
	@SuppressLint("NewApi")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {	
		case R.id.action_refresh:
			menuItem = item;
			menuItem.setActionView(R.layout.action_view);
			menuItem.expandActionView();
			actionRefresh();
			break;
		case R.id.action_search:
			menuItem = item;
			menuItem.setActionView(R.layout.action_view);
			menuItem.expandActionView();
			actionSearch();
			break;
		case R.id.action_help:
			actionHelp();
			break;
		case R.id.action_location_found:
			locationFound();
			break;
		case R.id.action_about:
			actionAbout();
			break;

		default:

			super.onOptionsItemSelected(menuItem);
		}
		return true;
	}

	protected void actionHelp(){
		Toast.makeText(this,"you have selected HELP",Toast.LENGTH_SHORT).show();
	}

	protected void actionAbout(){
		Toast.makeText(this,"you have selected ABOUT",Toast.LENGTH_SHORT).show();
	}

	protected void actionRefresh(){
		TestTask refresh_task = new TestTask();
		refresh_task.execute("action_refresh");
	}

	protected void actionSearch(){
		TestTask refresh_task = new TestTask();
		refresh_task.execute("action_search");
	}


	protected void locationFound(){
		Intent i = new Intent(MainActivity.this,LocationFound.class);
		startActivity(i);
	}

	/**
	 * DUMMY TASK TO DELAY
	 */
	private class TestTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// Simulate something long running
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		@SuppressLint("NewApi")
		@Override
		protected void onPostExecute(String result) {
			menuItem.collapseActionView();
			menuItem.setActionView(null);
		}
	};
}
