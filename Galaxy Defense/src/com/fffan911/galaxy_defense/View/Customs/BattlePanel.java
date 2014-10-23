package com.fffan911.galaxy_defense.View.Customs;

import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.BattlePanelController;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Physics.Position;

import android.content.Context;
import android.util.AttributeSet;

public class BattlePanel extends GamePanel{
	//Constants
	private static final String TAG = "BattlePanel";
	
	//Constructor
	public BattlePanel(Context context, AttributeSet attrs){
		super(context, attrs);
		setController(new BattlePanelController(this));
	}
	
	//GamePanel Methods
	@Override
	public Position getPlayerShipStartingPosition(){
		return new Position(getXCenter(), getHeight() - (PlayerShip.SIZE / 2));
	}
}
