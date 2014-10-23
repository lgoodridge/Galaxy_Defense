package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import android.view.MotionEvent;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericUIProxy;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Actors.PlayerTarget;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.View.Customs.BattlePanel;
import com.fffan911.galaxy_defense.View.Customs.BattleSeekBar;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class BattlePanelController extends Controller{
	//Constants
	private static final String TAG = "BattlePanelController";
	
	//Constructor
	public BattlePanelController(GamePanel panel){
		super(panel);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me){
		//Ensure Game is not Paused
		if (GameData.getInstance().isPaused()) return true;
		//Standard Touch Event Processing
		if (me.getAction() == MotionEvent.ACTION_DOWN || 
		me.getAction() == MotionEvent.ACTION_MOVE){
			//Get Panel and Player Target
			BattlePanel battlePanel = (BattlePanel)(getView());
			PlayerTarget playerTarget = battlePanel.getPlayerTarget();
			//Update Player Target position and display it
			playerTarget.setX((int)(me.getX()));
			playerTarget.setY((int)(me.getY()));
			playerTarget.setVisible(true);
			//If Player Ship exists, get the Player Ship and Battle Seekbar
			if (!battlePanel.playerShipExists()) return true;
			PlayerShip playerShip = battlePanel.getPlayerShip();
			GenericProxyUser gpu = (GenericProxyUser)(getView().getContext());
			GenericUIProxy genericUIProxy = gpu.getUIProxy();
			BattleSeekBar battleSeekBar = (BattleSeekBar)(genericUIProxy.findViewById
			(R.id.battle_seek_bar));
			//Move the Player Ship and Battle Seekbar to that x position
			playerShip.getPosition().moveTo((int)me.getX(), playerShip.getY());
			battleSeekBar.setProgress((int)(me.getX() * 100 / battlePanel.getWidth()));
			//If the player tapped on the top half of the screen - use special weapon
			if ((me.getAction() == MotionEvent.ACTION_DOWN) &&
			me.getY() < battlePanel.getHeight() / 2) {
				playerShip.shootSpecialWeapon();
			}
		} else if (me.getAction() == MotionEvent.ACTION_UP){
			//Hide Player Target
			BattlePanel battlePanel = (BattlePanel)(getView());
			PlayerTarget playerTarget = battlePanel.getPlayerTarget();
			playerTarget.setVisible(false);
		}
		return true;
	}
}
