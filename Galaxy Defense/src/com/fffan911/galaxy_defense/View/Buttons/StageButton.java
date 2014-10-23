package com.fffan911.galaxy_defense.View.Buttons;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.ButtonControllers.StageButtonController;
import com.fffan911.galaxy_defense.Model.Stages.Stage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class StageButton extends Button {
	//References
	private Controller controller;
	private int worldNum;
	private int stageNum;
	//Constants
	private final static String TAG = "StageButton";
	
	//Constructor
	public StageButton(Context context, int worldNum, int stageNum) {
		super(context);
		this.worldNum = worldNum;
		this.stageNum = stageNum;
		setController(new StageButtonController(this));
		setText(worldNum + "-" + stageNum);
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
	
	//Get Methods
	public int getWorldNum() {
		return worldNum;
	}
	public int getStageNum() {
		return stageNum;
	}
}
