package com.example.heegestureapp1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

public class GestureView extends View {
	private String TAG = this.getClass().getSimpleName();
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
		Log.d(TAG, "onDraw");
		
		// 여기서는 좌표 고정. 다음 프로젝트에서 x, y 변수
		canvas.drawBitmap(image,  50, 50, null);
		super.onDraw(canvas);
	}
	
	public void moveLeft() {
		x -= STEP;
		// 해당 뷰를 강제로 무효화 시켜 다시 onDraw를 호출 하게 함.
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
