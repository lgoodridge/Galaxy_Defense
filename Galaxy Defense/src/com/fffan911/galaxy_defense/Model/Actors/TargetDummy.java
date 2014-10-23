package com.fffan911.galaxy_defense.Model.Actors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Utility.Animation;
import com.fffan911.galaxy_defense.Utility.RandomUtility;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class TargetDummy extends Actor {
	//Attributes
	private float maxSpeed;
	//Constants
	private static final String TAG = "TargetDummy";
	
	//Constructor
	public TargetDummy(GamePanel panel, Position initialPosition,float maxSpeed) {
		super(panel, initialPosition);
		this.maxSpeed = maxSpeed;
	}
	public TargetDummy(GamePanel panel, Position initialPosition) {
		this(panel, initialPosition, 200.0f);
	}
	
	//Movement Methods
	public void moveHorizontally() {
		int direction = RandomUtility.chooseBetweenTwoNumbers(-1, 1);
		getPosition().setXSpeed(maxSpeed * direction);
		getPosition().setYSpeed(0);
	}
	public void moveVertically() {
		int direction = RandomUtility.chooseBetweenTwoNumbers(-1, 1);
		getPosition().setXSpeed(0);
		getPosition().setYSpeed(maxSpeed * direction);
	}
	
	//Actor Methods
	@Override
	public void handleCollision(Actor actor) {}
	@Override
	public void handleBoundsCollision(String edge) {
		if (edge.equals("Left") || edge.equals("Right")) {
			getPosition().toggleXDirection();
		}
		if (edge.equals("Top") || edge.equals("Bottom")) {
			getPosition().toggleYDirection();
		}
	}
	@Override
	public void deref() {
		super.deref();
		GameData.getInstance().addScore(getScoreValue());
	}
	
	//Get Methods
	@Override
	public Bitmap[] getAnimationBitmaps(GamePanel panel) {
		Bitmap[] bitmapArray = new Bitmap[1];
		bitmapArray[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource
		(panel.getResources(), R.drawable.target_dummy), 60, 60, true);
		return bitmapArray;
	}
	@Override
	public int getAnimationFramePeriod() {
		return Animation.SINGLE_FRAME;
	}
	@Override
	public int getScoreValue() {
		return 100;
	}
	@Override
	public String getName() {
		return "Target Dummy";
	}
	@Override
	public String getDescription() {
		return "A dummy whose sole purpose is to be shot at.";
	}
}
