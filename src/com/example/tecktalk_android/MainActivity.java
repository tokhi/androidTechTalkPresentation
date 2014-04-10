package com.example.tecktalk_android;

import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Cursor cursor = getContentResolver().query(
	            ContactsContract.Contacts.CONTENT_URI, null, null, null, Phone.DISPLAY_NAME + " ASC");
		
		String contactID = cursor.getString(cursor.getColumnIndex(BaseColumns._ID));
		Log.d("MainActivity", contactID);
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(contactID));
		intent.setData(uri);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void displayNameViaToast(View view) {
		TextView nameTxtField = (TextView) findViewById(R.id.editText1);
		Toast.makeText(this, "How you doing "+nameTxtField.getText().toString(), Toast.LENGTH_LONG).show();

	}

}
