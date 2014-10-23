package com.fffan911.galaxy_defense.View.Customs;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.SideJoystickController;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

public class SideJoystick extends SurfaceView {
	//References
	private Controller controller;
	private final Paint handlePaint;
	private final Paint circlePaint;
	//Attributes
	private float circleX;
	private float circleY;
	private boolean isFirstDraw;
	//Decoration Bitmaps
	private Bitmap backgroundDecoration;
	private Bitmap handleDecoration;
	private Bitmap circleDecoration;
	//Constants
	private static final String TAG = "SideJoystick";
	
	//Constructor
	public SideJoystick(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new SideJoystickController(this));
		setWillNotDraw(false);
		Paint handlePaint = new Paint();
		handlePaint.setColor(Color.DKGRAY);
		Paint circlePaint = new Paint();
		circlePaint.setColor(Color.WHITE);
		this.handlePaint = handlePaint;
		this.circlePaint = circlePaint;
		this.circleX = -1;
		this.circleY = -1;
		this.isFirstDraw = true;
	}
	
	//Init Methods
	private final void initDecorationBitmaps(){
		this.backgroundDecoration = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(getResources(), R.drawable.side_joystick_background), getWidth(), getHeight(), true);
		this.handleDecoration = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(getResources(), R.drawable.side_joystick_handle), (int)getHandleRadius()*2, 
		(int)getHandleRadius()*2, true);
		this.circleDecoration = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(getResources(), R.drawable.side_joystick_circle), (int)getCircleRadius()*2, 
		(int)getCircleRadius()*2, true);
	}
	
	//Draw Methods
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		//If this is the first drawing:
		if (isFirstDraw){
			moveCircleBackToCenter();
			initDecorationBitmaps();
			isFirstDraw = false;
		}
		//Drawing the Circles + Decorations
		//canvas.drawBitmap(backgroundDecoration, 0, 0, null);
		canvas.drawCircle(getXMid(), getYMid(), getHandleRadius(), handlePaint);
		canvas.drawBitmap(handleDecoration, getXMid()-getHandleRadius(), 0, null);
		canvas.drawCircle(circleX, circleY, getCircleRadius(), circlePaint);
		canvas.drawBitmap(circleDecoration, circleX-getCircleRadius(), 
		circleY-getCircleRadius(), null);
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me){
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Move Methods
	public void moveCircleBackToCenter(){
		circleX = getXMid();
		circleY = getYMid();
	}
	
	//Set Methods
	private final void setController(Controller controller){
		this.controller = controller;
	}
	public void setCircleX(float newCircleX){
		circleX = newCircleX;
	}
	public void setCircleY(float newCircleY){
		circleY = newCircleY;
	}
	
	//Get Methods
	public float getHandleRadius(){
		return Math.min(getWidth(), getHeight()) / 2.0f;
	}
	public float getCircleRadius(){
		return getHandleRadius() / 2.0f;
	}
	public final float getXMid(){
		return getWidth() / 2.0f;
	}
	public final float getYMid(){
		return getHeight() / 2.0f;
	}
}
