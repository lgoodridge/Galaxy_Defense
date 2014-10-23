package com.fffan911.galaxy_defense.Model.Actors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class PlayerTarget extends Actor {
	//Attributes
	private boolean isVisible;
	//Constants
	public static final float ROTATE_SPEED = 150.0f;
	private static final int SIZE = 100;
	private static final String TAG = "PlayerTarget";
	
	//Constructor
	public PlayerTarget(GamePanel panel, Position initialPosition) {
		super(panel, initialPosition);
		getPosition().continuousRotate(1, ROTATE_SPEED);
		isVisible = false;
	}
	
	//Actor Methods
	@Override
	public void render(Canvas canvas){
		if (isVisible) super.render(canvas);
	}
	@Override
	public void handleCollision(Actor actor) {}
	@Override
	public void handleBoundsCollision(String edge) {}
	
	//Boolean Methods
	public boolean isVisibile(){
		return isVisible;
	}
	
	//Set Methods
	public void setVisible(boolean bool){
		isVisible = bool;
	}
	
	//Get Methods
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		Bitmap[] bitmapArray = new Bitmap[2];
		bitmapArray[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.player_target_one), SIZE, SIZE, true);
		bitmapArray[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.player_target_two), SIZE, SIZE, true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return 1000;
	}
	@Override
	public int getScoreValue() {
		return 0;
	}
	@Override
	public String getName() {
		return "Player Target";
	}
	@Override
	public String getDescription() {
		return "A target reticule indicating where the player ship is currently aiming";
	}
}
