package com.fffan911.galaxy_defense.Model.Physics;

import com.fffan911.galaxy_defense.Utility.MathUtility;

public class PatternManager {
	//References
	private Position position;
	//Constants
	private static final String TAG = "PatternManager";
	
	//Constructor
	public PatternManager(Position position){
		this.position = position;
	}
	
	//Pattern Methods
	public void circleAroundTarget(int[] target, int radius, float speed){
		int x = position.getX();
		int y = position.getY();
		int cenX = target[0];
		int cenY = target[1];
		int relX = x - cenX;
		int relY = cenY - y;
		int xMoveDir = 0;
		if (relY > 0) xMoveDir = 1;
		else xMoveDir = -1;
		int yMoveDir = 0;
		if (relX < 0) yMoveDir = 1;
		else yMoveDir = -1;
		int precision = 5;
		int prosX = 0;
		int prosY = 0;
		int xSpd = 0;
		int ySpd = 0;
		if (Math.abs(relX) <= radius/2) {
			xSpd = (int)speed * Math.abs(relY) / radius;
			int xDisTrav = xSpd / precision;
			if (xMoveDir == 1) prosX = relX + xDisTrav;
			if (xMoveDir == -1) prosX = relX - xDisTrav;
			int calcY = MathUtility.pythagoreanSide(radius, prosX);
			if (xMoveDir == 1) prosY = calcY;
			if (xMoveDir == -1) prosY = -calcY;
		} else {
			ySpd = (int)speed * Math.abs(relX) / radius;
			int yDisTrav = ySpd / precision;
			if (yMoveDir == 1) prosY = relY + yDisTrav;
			if (yMoveDir == -1) prosY = relY - yDisTrav;
			int calcX = MathUtility.pythagoreanSide(radius, prosY);
			if (yMoveDir == 1) prosX = -calcX;
			if (yMoveDir == -1) prosX = calcX;
		}
		int toX = cenX + prosX;
		int toY = cenY - prosY;
		int[] nextPoint = {toX, toY};
		position.moveTo(nextPoint);
	}
}
