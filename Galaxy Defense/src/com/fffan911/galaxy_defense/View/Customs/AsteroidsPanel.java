package com.fffan911.galaxy_defense.View.Customs;

import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.AsteroidsPanelController;
import com.fffan911.galaxy_defense.Model.Physics.Position;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

public class AsteroidsPanel extends GamePanel {
	//Constants
	private static final String TAG = "AsteroidsPanel";
	
	//Constructor
	public AsteroidsPanel(Context context, AttributeSet attrs){
		super(context, attrs);
		setController(new AsteroidsPanelController(this));
	}
	
	//GamePanel Methods
	@Override
	public Position getPlayerShipStartingPosition(){
		return new Position(getXCenter(), getYCenter());
	}
}
