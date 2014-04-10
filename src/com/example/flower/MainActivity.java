package com.example.flower;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.tecktalk_android.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flower_layout);
		
		/**
		 * Intentional error to test log cat
		 */
//		int[] testArray = new int[10];
//        int number = testArray[11];
        Log.d("MainActivity", "Activity created successfully!");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Log.d("MainActivity", "On create option menu triggered!");
		return super.onCreateOptionsMenu(menu);
	}
}
