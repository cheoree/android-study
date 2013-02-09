package com.example.heegestureapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class GestureView extends View {
	private static final int STEP = 50;
	private static final int FLING_MIN_DISTANCE = 100;
	private static final int FLING_LIMIT_VELOCITY = 200;
	
	private Bitmap girlImage;
	private int x, y;
	
	public GestureDetector gesture;
	
	public GestureView(Context context) {
		super(context);
		girlImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher);
		
		gesture = new GestureDetector(new OnGesture());
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		x = w / 2 - girlImage.getWidth() / 2;
		y = h / 2 - girlImage.getHeight() / 2;
		
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(girlImage, x, y, null);
		super.onDraw(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		gesture.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	
	private void moveLeft() {
		x = Math.max(0, x - STEP);
		this.invalidate();
	}
	
	private void moveRight() {
		x = Math.min(this.getWidth() - girlImage.getWidth(), x + STEP);
		this.invalidate();
	}
	
	private void moveUp() {
		y = Math.max(0,  y - STEP);
		this.invalidate();
	}
	
	private void moveDown() {
		y = Math.min(this.getHeight() - girlImage.getHeight(), y + STEP);
		this.invalidate();
	}
	
	class OnGesture implements OnGestureListener {
		@Override
		public boolean onDown(MotionEvent e) {
			return false;
		}
		
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_LIMIT_VELOCITY) {
				GestureView.this.moveLeft();
			} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_LIMIT_VELOCITY) {
				GestureView.this.moveRight();
			}
			
			if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_LIMIT_VELOCITY) {
				GestureView.this.moveUp();
			} else if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_LIMIT_VELOCITY) {
				GestureView.this.moveDown();
			}
			
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
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
}
