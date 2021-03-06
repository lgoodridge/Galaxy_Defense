package com.fffan911.galaxy_defense.View.Customs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.ScoreTextViewController;

public class ScoreTextView extends TextView {
	//Reference
	private Controller controller;
	//Constants
	private static final String TAG = "ScoreTextView";
	
	//Construcutor
	public ScoreTextView(Context context, AttributeSet attrs){
		super(context, attrs);
		setController(new ScoreTextViewController(this));
		setText("Score: --");
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
