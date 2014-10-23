package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GenericUIProxy;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Miscellany.OnPauseListener;
import com.fffan911.galaxy_defense.View.Customs.BattlePanel;
import com.fffan911.galaxy_defense.View.Customs.BattleSeekBar;

public class BattleSeekBarController extends Controller 
implements OnSeekBarChangeListener, OnPauseListener{
	//Constants
	private static final String TAG = "BattleSeekBarController";
	
	//Constructor
	public BattleSeekBarController(BattleSeekBar seekBar){
		super(seekBar);
		seekBar.setOnSeekBarChangeListener(this);
		GameData.getInstance().addOnPauseListener(this);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return true;
	}
	
	//SeekBarChangeListener Methods
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		GenericProxyUser genericProxyUser = (GenericProxyUser)getView().getContext();
		GenericUIProxy genericUIProxy = genericProxyUser.getUIProxy();
		BattlePanel battlePanel = (BattlePanel)(genericUIProxy.findViewById(R.id.battle_panel));
		if (battlePanel.playerShipExists()) {
			PlayerShip playerShip = battlePanel.getPlayerShip();
			int toX = battlePanel.getWidth() * progress / 100;
			int toY = playerShip.getY();
			if (Math.abs(playerShip.getX() - toX) > 8) {
				battlePanel.getPlayerShip().getPosition().moveTo
				(toX, toY, playerShip.getMaxSpeed());
			}
		}
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {}
	
	//OnPauseListener Methods
	@Override
	public void onPause() {
		getView().setEnabled(false);
	}
	@Override
	public void onUnpause() {
		getView().setEnabled(true);
	}
}
