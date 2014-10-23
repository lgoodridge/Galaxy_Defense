package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.DetailsButtonController;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class DetailsButton extends Button {
	//References
	private Controller controller;
	private String detailsText;
	//Constants
	private static final String TAG = "DetailsButton";
	
	//Constructors
	public DetailsButton(Context context) {
		super(context);
		setController(new DetailsButtonController(this));
		setText("Details");
		setDetailsText("");
		setBackgroundDrawable(getResources().getDrawable(R.drawable.blue_button_background));
	}
	public DetailsButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setController(new DetailsButtonController(this));
		setText("Details");
		setDetailsText("");
		setBackgroundDrawable(getResources().getDrawable(R.drawable.blue_button_background));
	}
	public DetailsButton(Context context, String detailsText) {
		this(context);
		setDetailsText(detailsText);
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private final void setController(Controller controller) {
		this.controller = controller;
	}
	public void setDetailsText(String detailsText) {
		this.detailsText = detailsText;
	}
	
	//Get Methods
	public String getDetailsText() {
		return detailsText;
	}
}
