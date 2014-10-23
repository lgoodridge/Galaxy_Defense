package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import android.view.MotionEvent;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Actors.PlayerTarget;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Utility.MathUtility;
import com.fffan911.galaxy_defense.View.Customs.AsteroidsPanel;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class AsteroidsPanelController extends Controller{
	//Constants
	private static final String TAG = "AsteroidsPanelController";
	
	//Constructor
	public AsteroidsPanelController(GamePanel panel){
		super(panel);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me){
		//Ensure Game is not Paused
		if (GameData.getInstance().isPaused()) return true;
		//Process Touch Event
		if (me.getAction() == MotionEvent.ACTION_DOWN || 
		me.getAction() == MotionEvent.ACTION_MOVE){
			//Get Panel and Player Ship
			AsteroidsPanel asteroidsPanel = (AsteroidsPanel)(getView());
			PlayerShip playerShip = asteroidsPanel.getPlayerShip();
			if (!asteroidsPanel.playerShipExists()) return true;
			//Calculate rotation degrees
			float dx = me.getX() - playerShip.getX();
			float dy = playerShip.getY() - me.getY();
			float degrees = MathUtility.displacementToDegrees(dx, dy);
			//Rotate Player Ship and start shooting
			playerShip.getPosition().rotateTo(degrees, playerShip.getMaxRotateSpeed());
			playerShip.setIsShooting(true);
			//Update Player Target position and display it
			PlayerTarget playerTarget = asteroidsPanel.getPlayerTarget();
			playerTarget.setX((int)(me.getX()));
			playerTarget.setY((int)(me.getY()));
			playerTarget.setVisible(true);
		} else if (me.getAction() == MotionEvent.ACTION_UP) {
			//Hide Player Target
			AsteroidsPanel asteroidsPanel = (AsteroidsPanel)(getView());
			PlayerTarget playerTarget = asteroidsPanel.getPlayerTarget();
			playerTarget.setVisible(false);
			//Tell Player Ship to stop shooting
			if (!asteroidsPanel.playerShipExists()) return true;
			PlayerShip playerShip = asteroidsPanel.getPlayerShip();
			playerShip.setIsShooting(false);
		}
		return true;
	}
}
