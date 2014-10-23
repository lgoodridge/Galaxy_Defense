package com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers;

import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.GameUIProxy;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Miscellany.OnPauseListener;
import com.fffan911.galaxy_defense.Utility.MathUtility;
import com.fffan911.galaxy_defense.View.Customs.SideJoystick;

public class SideJoystickController extends Controller implements OnPauseListener{
	//Constants
	private static final String TAG = "SideJoystickController";
	
	//Constructor
	public SideJoystickController(View view){
		super(view);
		GameData.getInstance().addOnPauseListener(this);
	}
	
	//Controller Method
	@Override
	public boolean onTouchEvent(MotionEvent event){
		//If its disabled - don't do anything
		if (!getView().isEnabled()) return true;
		//If you touch or move the joystick - perform calculations
		if (event.getAction() == MotionEvent.ACTION_DOWN ||
			event.getAction() == MotionEvent.ACTION_MOVE) {
			SideJoystick sideJoystick = (SideJoystick)(getView());
			//Calculating the displacement and the degrees
			float dx = event.getX() - sideJoystick.getXMid();
			float dy = sideJoystick.getYMid() - event.getY();
			float degrees = MathUtility.displacementToDegrees(dx, dy);
			//Calculating the Joystick circle displacement + multiplier
			float distance = MathUtility.hypotenuse(dx, dy);
			if (distance > sideJoystick.getHandleRadius()) {
				dx = sideJoystick.getHandleRadius() * MathUtility.sin(degrees);
				dy = sideJoystick.getHandleRadius() * MathUtility.cos(degrees);
			}
			distance = MathUtility.hypotenuse(dx, dy);
			float displacementMultiplier = distance / sideJoystick.getHandleRadius();
			//Setting the Joystick circle displacement + Invalidation
			sideJoystick.setCircleX(sideJoystick.getXMid() + dx);
			sideJoystick.setCircleY(sideJoystick.getYMid() - dy);
			sideJoystick.invalidate();
			//Getting the GameUIProxy
			GameProxyUser gameProxyUser = (GameProxyUser)(sideJoystick.getContext());
			GameUIProxy gameUIProxy = gameProxyUser.getUIProxy();
			//Move the Player Ship
			PlayerShip playerShip = gameUIProxy.getGamePanel().getPlayerShip();
			if (playerShip != null) {
				playerShip.getPosition().moveInDirection(degrees, 
				playerShip.getMaxSpeed() * displacementMultiplier);
			}
		//If you release the Joystick - move circle back to center + stop player ship
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			//Move circle back to center + Invalidation
			SideJoystick sideJoystick = (SideJoystick)(getView());
			sideJoystick.moveCircleBackToCenter();
			sideJoystick.invalidate();
			//Getting the GameUIProxy
			GameProxyUser gameProxyUser = (GameProxyUser)(sideJoystick.getContext());
			GameUIProxy gameUIProxy = gameProxyUser.getUIProxy();
			//Stop Moving the Player Ship
			PlayerShip playerShip = gameUIProxy.getGamePanel().getPlayerShip();
			if (playerShip != null) {
				playerShip.getPosition().halt();
			}
		}
		return true;
	}
	
	//OnPauselistener Methods
	@Override
	public void onPause() {
		getView().setEnabled(false);
	}
	@Override
	public void onUnpause() {
		getView().setEnabled(true);
	}
}
