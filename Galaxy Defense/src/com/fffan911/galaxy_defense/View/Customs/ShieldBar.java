package com.fffan911.galaxy_defense.View.Customs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.ShieldBarController;

public class ShieldBar extends View {
	//Reference
	private Controller controller;
	//Constants
	private static final String TAG = "ShieldBar";
	
	//Construcutor
	public ShieldBar(Context context, AttributeSet attrs){
		super(context, attrs);
		setController(new ShieldBarController(this));
	}
	
	//BAD - CHANGE THIS
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		ShapeDrawable drawable = new ShapeDrawable(new RectShape());
		drawable.getPaint().setColor(0xff00FFFF);
		drawable.setBounds(0, 0, getContext().getResources().getDisplayMetrics().widthPixels/4,
		getContext().getResources().getDisplayMetrics().heightPixels/10); 
		drawable.draw(canvas);
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
