package com.example.heegestureapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends Activity {
	private GestureView gestureView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gestureView = new GestureView(this);
		this.setContentView(gestureView);
		//setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		gestureView.gesture.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
}
