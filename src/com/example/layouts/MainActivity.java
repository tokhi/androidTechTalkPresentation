package com.example.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tecktalk_android.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.linear_layout);
		setContentView(R.layout.code_layout);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
		for (int i = 0; i < 3; i++) {
	    	   Button button = new Button(this);
	           button.setText(R.string.click_me);
	           button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d("MainActivity", "button clicked!");
					
				}
			});
	           layout.addView(button);
	       }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
