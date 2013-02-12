package com.example.heegestureapp1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * 여기서는 메인뷰가 GestureListener를 구현
 * @author baecheolhee
 *
 */
public class MainActivity extends Activity implements OnGestureListener {
	private String TAG = this.getClass().getSimpleName();
	
	private static final int FLING_MIN_DISTANCE = 100;
	private GestureDetector gesture;
	private GestureView gestureView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gestureView = new GestureView(this);
		gesture = new GestureDetector(this);
		
		setContentView(gestureView);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		gesture.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		Log.d(TAG, "onFling");
		if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "left1", Toast.LENGTH_SHORT).show();
			gestureView.moveLeft();
			Log.d(TAG, "left");
		}
		if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "right1", Toast.LENGTH_SHORT).show();
			gestureView.moveRight();
			Log.d(TAG, "right");
		}
		if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "up1", Toast.LENGTH_SHORT).show();
			gestureView.moveUp();
			Log.d(TAG, "up");
		}
		if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "down1", Toast.LENGTH_SHORT).show();
			gestureView.moveDown();
			Log.d(TAG, "down");
		}
		
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
