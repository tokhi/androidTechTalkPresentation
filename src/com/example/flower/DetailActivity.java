package com.example.flower;

import java.io.File;

import com.example.tecktalk_android.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		// back button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Uri videoUri = Uri.parse("android.resource://" + this.getPackageName()
				+ "/" + R.drawable.documentariesandyou);
		VideoView mVideoView = (VideoView) findViewById(R.id.videoView1);
		Log.d("MainActivity", Environment.getExternalStorageDirectory()
				.getAbsolutePath());
		File clip = new File(Environment.getExternalStorageDirectory(),
				"documentariesandyou.mp4");
		Log.d("MainActivity", clip.getAbsolutePath());
		if (clip.exists()) {
			Log.d("MainActivity", videoUri.getPath());
			mVideoView.setVideoPath(clip.getAbsolutePath());
			MediaController ctlr = new MediaController(this);
			ctlr.setMediaPlayer(mVideoView);
			mVideoView.setMediaController(ctlr);
			mVideoView.requestFocus();
			mVideoView.start();
		} else
			Log.d("MainActivity", "Clip not exist!");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem item = menu.add(R.string.external_url);
		item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				String url = "http://developer.android.com/index.html";
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(intent);
				return false;
			}
		});
		return super.onCreateOptionsMenu(menu);
	}

}
