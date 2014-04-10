package com.example.flower;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
				goToSecondActivity(v);				
			}
		});
        
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				implicitViewURL(v);				
			}
		});
        
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				implicitSendText(v);				
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
	
	public void goToSecondActivity(View v) {
		// Explicit intent (via intent we do sort of navigations)
		Intent intent = new Intent(MainActivity.this, DetailActivity.class);
		startActivity(intent);

	}
	
	/**
	 * implicit activity to browse a URL
	 */
	public void implicitViewURL(View v){
		String url = "http://developer.android.com/index.html";
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
		startActivity(intent);
		
	}
	
	/**
	 * implicit activity to send a Text
	 */
	public void implicitSendText(View v){
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_TEXT, "This is the extra text from the flower.MainActivity");
		intent.setType("text/plain");
		startActivity(intent);
	}
	
	
	/**
	 * playing with activity life cycles
	 */
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "onResume");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(LOG_TAG, "onStart");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(LOG_TAG, "onPause");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(LOG_TAG, "onStop");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG, "onDestroy");
	}
}
