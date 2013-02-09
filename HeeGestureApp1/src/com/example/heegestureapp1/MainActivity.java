package com.example.heegestureapp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity implements OnGestureListener {
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
	
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "left1", Toast.LENGTH_SHORT).show();
			gestureView.moveLeft();
		}
		if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "right1", Toast.LENGTH_SHORT).show();
			gestureView.moveRight();
		}
		if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "up1", Toast.LENGTH_SHORT).show();
			gestureView.moveUp();
		}
		if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE) {
			Toast.makeText(this, "down1", Toast.LENGTH_SHORT).show();
			gestureView.moveDown();
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
