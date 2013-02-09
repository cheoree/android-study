package com.example.heegestureapp1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class GestureView extends View {
	private final int STEP = 50;
	private Bitmap image;
	private int x, y;
	
	public GestureView(Context context) {
		super(context);
		
		image = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher);
		x = y = 50;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(image,  50, 50, null);
		super.onDraw(canvas);
	}
	
	public void moveLeft() {
		x -= STEP;
		this.invalidate();
	}
	
	public void moveRight() {
		x += STEP;
		this.invalidate();
	}
	
	public void moveUp() {
		y -= STEP;
		this.invalidate();
	}
	
	public void moveDown() {
		y += STEP;
		this.invalidate();
	}
}
