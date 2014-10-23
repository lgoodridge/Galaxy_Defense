package com.fffan911.galaxy_defense.View.Layouts;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.LayoutControllers.StageSelectorLayoutController;
import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Stages.Stage;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;
import com.fffan911.galaxy_defense.View.Buttons.BlueprintButton;
import com.fffan911.galaxy_defense.View.Buttons.CloseStageSelectorButton;
import com.fffan911.galaxy_defense.View.Buttons.ShopButton;
import com.fffan911.galaxy_defense.View.Buttons.StageButton;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StageSelectorLayout extends LinearLayout {
	//References
	private Controller controller;
	private boolean hasBeenInitialized;
	//Constants
	private final static String TAG = "StageSelectorLayout";
	
	//Constructor
	public StageSelectorLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.hasBeenInitialized = false;
		setWillNotDraw(false);
		setController(new StageSelectorLayoutController(this));
	}
	
	//Setup Methods
	private void setupStageSelectorPopup() {
		//Creating the header Layout
		LinearLayout headerLayout = new LinearLayout(getContext());
		headerLayout.setOrientation(LinearLayout.HORIZONTAL);
		headerLayout.setWeightSum(100);
		//Add Shop Button
		ShopButton shopButton = new ShopButton(getContext());
		shopButton.setLayoutParams(new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 50));
		headerLayout.addView(shopButton);
		//Add Blueprint Button
		BlueprintButton blueprintButton = new BlueprintButton(getContext());
		blueprintButton.setLayoutParams(new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 50));
		headerLayout.addView(blueprintButton);
		//Adding the Header Layout
		addView(headerLayout);
		//Add Stage Buttons and World Labels
		Stage[] loadedStages = StageManager.getInstance().getLoadedStages();
		int currentWorld = -1;
		int currentId = 0;
		LinearLayout horizontalLayout = new LinearLayout(getContext());
		for (int i = 0; i < loadedStages.length; i++) {
			Stage stage = loadedStages[i];
			//Necessary Setup for each new World
			if (stage.getWorldNumber() != currentWorld) {
				//Reset the World Number
				currentWorld = stage.getWorldNumber();
				//Add the World # Text View
				TextView worldView = new TextView(getContext());
				worldView.setText("World " + currentWorld);
				if (currentWorld == 0) {
					if (stage.getGameMode() == GameMode.STORY) worldView.setText("Tutorials");
					if (stage.getGameMode() == GameMode.ARCADE) worldView.setText("Practice Levels");
				}
				addView(worldView);
				//Add the horizontal Linear Layout for the StageButtons
				currentId++;
				horizontalLayout = new LinearLayout(getContext());
				horizontalLayout.setId(currentId);
				horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
				addView(horizontalLayout);
			}
			//Adding Stage Button
			StageButton stageButton = new StageButton(getContext(), stage.getWorldNumber(), 
			stage.getStageNumber());
			horizontalLayout.addView(stageButton);
			//Check for layout overflow
			int nextLayoutWidth = (horizontalLayout.getChildCount() + 1) * 70;
			if (nextLayoutWidth > getWidth()) {
				horizontalLayout = new LinearLayout(getContext());
				horizontalLayout.setId(currentId);
				horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
				addView(horizontalLayout);
			}
		}
		//Add Close Button
		CloseStageSelectorButton closeButton = new CloseStageSelectorButton(getContext());
		addView(closeButton);
		//Don't redraw anymore
		setWillNotDraw(true);
	}
	
	//Draw Methods
	@Override
	protected void onDraw(Canvas canvas) {
		if (!hasBeenInitialized) {
			setupStageSelectorPopup();
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
