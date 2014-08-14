[Back to Part 1](https://github.com/tokhi/androidTechTalkPresentation/blob/master/README.md)

######Widgets and Relative layout######
As you see below there are three widgets such as `TextView` (label) , `EditText` (text field) and a `Button`

first lets initialize the string variables in the `res/values/strings.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <string name="app_name">TeckTalk_Android</string>
    <string name="action_settings">Settings</string>
    <string name="hello_world">Hello world!</string>
    <string name="name_lable">Your Name:</string>
    <string name="ok_bttn">Ok</string>

</resources>
```

The layout:


```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button1"
        android:text="@string/name_lable" />
		<!--  alignBaseline: align the textview with the button.. no matter where you place them first -->
    <EditText
        android:id="@+id/editText1"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/button1"
        android:layout_toLeftOf="@+id/button1"
        android:layout_toRightOf="@+id/textView1"
        android:ems="10" >
	<!--  alignBaseline: align the texteditview with the button.. the same as textview -->
	<!--  toLeft of toRight of - between two components ( we use the relative adjustment so if we increase the text value of text view and the 
	the button edit text will be adjusted automatically -->
        <requestFocus />
    </EditText>

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:layout_marginTop="50dp"
        android:text="OK"
        android:onClick="displayNameViaToast"
         />
	 <!-- we want the  button to be on  top right -->
</RelativeLayout>
```
In above snipet the button aligned to the right top as soon as you click the button then the `displayNameViaToast` method will be invoked.

The `alignBaseline` aligns the `EditText` with the button and place the EditText the left of `button1` and to the right of `textView1`.

The `TextView` is also aligned with the `button1`


This is how the activity look like:

```java
package com.example.tecktalk_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

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
	
	public void displayNameViaToast(View view) {
		TextView nameTxtField = (TextView) findViewById(R.id.editText1);
		// the toast message display a toast message with the name from the text field
		Toast.makeText(this, "How you doing "+nameTxtField.getText().toString(), Toast.LENGTH_LONG).show();

	}

}

```
If you run the project and type your name in the text field then you see a toast message as below:

