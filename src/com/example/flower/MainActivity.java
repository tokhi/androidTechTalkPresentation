package com.example.flower;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tecktalk_android.R;

public class MainActivity extends Activity {

	private static final String LOG_TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flower_layout);
		
		/**
		 * Intentional error to test log cat
		 */
//		int[] testArray = new int[10];
//        int number = testArray[11];
        Log.d(LOG_TAG, "Activity created successfully!");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Log.d(LOG_TAG, "On create option menu triggered!");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, "You tapped the "+item.getTitle(), Toast.LENGTH_LONG).show();
		return super.onOptionsItemSelected(item);
	}
}
