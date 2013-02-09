package com.example.heesoundplayapp;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnGestureListener {
	private static final int FLING_MIN_DISTANCE = 100;
	private static final int FLING_LIMIT_VELOCITY = 200;
	private static final int NUM_OF_MUSIC = 4;
	
	private GestureDetector gesture;
	private LinearLayout linear;
	private MediaPlayer [] musics;
	
	private int musicIndex;
	
	private static final String LTAG = "[APP-DEBUG]";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int [] music_ids = {
				R.raw.music1, R.raw.music2, R.raw.music3, R.raw.music4
		};
		
		musics = new MediaPlayer[NUM_OF_MUSIC];
		for (int i = 0; i < musics.length; ++i) {
			musics[i] = MediaPlayer.create(this, music_ids[i]);
			final int ii = i;
			musics[i].setOnPreparedListener(new OnPreparedListener() {
			    @Override
			    public void onPrepared(MediaPlayer mp) {
			        Log.d(LTAG, "Media prepared " + ii);
			    }
			});
		}
		musicIndex = 0;
		
		gesture = new GestureDetector(this);
		
		linear = new LinearLayout(this);
		linear.setGravity(Gravity.CENTER_VERTICAL);
		linear.setBackgroundColor(Color.MAGENTA);
		
		TextView text = new TextView(this);
		text.setTextSize(50);
		text.setTextColor(Color.WHITE);
		text.setGravity(Gravity.CENTER);
		text.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		text.setText("Ready");
		
		linear.addView(text);
		
		setContentView(linear);
		
		Log.d(LTAG, "onCreate complete");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(LTAG, "onTouchEvent");
		gesture.onTouchEvent(event);
		
		if (event.getAction() == MotionEvent.ACTION_UP) {
			Log.d(LTAG, "acitonUp");
			linear.setBackgroundColor(Color.MAGENTA);
		}
		
		return super.onTouchEvent(event);
	}
	
	@Override
	public boolean onDown(MotionEvent e) {
		Log.d(LTAG, "onDown");
		linear.setBackgroundColor(Color.YELLOW);
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.d(LTAG, "onFling");
		if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_LIMIT_VELOCITY) {
			Log.d(LTAG, "prevPlay");
			this.prevPlay();
		} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_LIMIT_VELOCITY) {
			Log.d(LTAG, "nextPlay");
			this.nextPlay();
		} else if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_LIMIT_VELOCITY) {
			Log.d(LTAG, "pause");
			this.pause();
		}
		return false;
	}

//	private void startPlay() {
//		musics[musicIndex].start();
//	}
	
	private void prevPlay() {
		musics[musicIndex].stop();
		if (--musicIndex < 0) {
			musicIndex = NUM_OF_MUSIC - 1;
		}
		Log.d(LTAG, "musicIndex:" + musicIndex);
		musics[musicIndex].start();
	}
	
	private boolean pause = false;
	
	private void nextPlay() {
		if (pause) {
			pause = false;
		} else {
			musics[musicIndex].stop();
			musicIndex = (musicIndex + 1) % NUM_OF_MUSIC;
		}
		Log.d(LTAG, "musicIndex:" + musicIndex);
		musics[musicIndex].start();
	}
	
	private void pause() {
		if (musics[musicIndex].isPlaying() ) {
			pause = true;
			Log.d(LTAG, "paused");
			musics[musicIndex].pause();
		}
	}
	
//	private void stop() {
//		musics[musicIndex].stop();
//	}
	
	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
