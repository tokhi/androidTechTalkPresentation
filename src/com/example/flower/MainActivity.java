package com.example.flower;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.tecktalk_android.R;

public class MainActivity extends Activity {

	private static final String LOG_TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flower_layout);
		
		Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goToSecondActivity();				
			}
		});
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
		/**
    	 * Debugin your app
    	 */
    	String iteration = "Iteration ";
    	for (int i = 0; i < 4; i++) {
    		String msg = iteration+i;
			Log.d(LOG_TAG, msg);
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void goToSecondActivity() {
		// Explicit intent (via intent we do sort of navigations)
		Intent intent = new Intent(MainActivity.this, DetailActivity.class);
		startActivity(intent);

	}
}
