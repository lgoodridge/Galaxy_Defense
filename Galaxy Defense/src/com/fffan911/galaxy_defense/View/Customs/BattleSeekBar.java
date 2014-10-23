package com.fffan911.galaxy_defense.View.Customs;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.BattleSeekBarController;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class BattleSeekBar extends SeekBar{
	//Attributes
	private boolean hasBeenInitialized;
	//Reference
	private Controller controller;
	//Constants
	private static final String TAG = "BattleSeekBar";
	
	//Construcutor
	public BattleSeekBar(Context context, AttributeSet attrs){
		super(context, attrs);
		setMax(100);
		setProgress(50);
		setProgressDrawable(getResources().getDrawable(R.drawable.seekbar_progress_laser));
		setController(new BattleSeekBarController(this));
		hasBeenInitialized = false;
	}
	
	//Draw Methods
	@Override
	protected void onDraw(Canvas canvas){
		if (!hasBeenInitialized) {
			Bitmap rawThumb = BitmapFactory.decodeResource(getResources(), R.drawable.seekbar_thumb);
			Bitmap scaledThumb = Bitmap.createScaledBitmap(rawThumb, getMeasuredWidth()/10,
			getMeasuredHeight(), true);
			Drawable thumbDrawable = new BitmapDrawable(getResources(), scaledThumb);
			thumbDrawable.setBounds(getMeasuredWidth()/2, 0, getMeasuredWidth()/2 + 
			thumbDrawable.getIntrinsicWidth(), thumbDrawable.getIntrinsicHeight());
			setThumb(thumbDrawable);
			hasBeenInitialized = true;
		}
		super.onDraw(canvas);
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me){
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private final void setController(Controller controller){
		this.controller = controller;
	}
}
