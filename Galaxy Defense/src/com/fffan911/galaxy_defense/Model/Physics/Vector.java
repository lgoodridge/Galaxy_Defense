package com.fffan911.galaxy_defense.Model.Physics;

import com.fffan911.galaxy_defense.Utility.MathUtility;

public class Vector {
	//Attributes
	private float degrees;
	private float xSpd;
	private float ySpd;
	private float xAcc;
	private float yAcc;
	//Target Attributes
	private float targetDegrees;
	private float targetRotateSpeed;
	private int targetRotateDirection;
	//Continuous Attributes
	private float continuousRotateSpeed;
	private int continuousRotateDirection;
	//Constants
	public static final int DIR_UP = -1;
	public static final int DIR_DOWN = 1;
	public static final int DIR_RIGHT = 1;
	public static final int DIR_LEFT = -1;
	public static final float ZERO = 0.0f;
	private static final String TAG = "Vector";
	
	//Constructors
	public Vector(float xSpd, float ySpd, float xAcc, float yAcc, float degrees){
		this.degrees = degrees;
		this.xSpd = xSpd;
		this.ySpd = ySpd;
		this.xAcc = xAcc;
		this.yAcc = yAcc;
		this.targetDegrees = 0;
		this.targetRotateSpeed = 0;
		this.targetRotateDirection = 0;
		this.continuousRotateSpeed = 0;
		this.continuousRotateDirection = 0;
	}
	public Vector(float xSpd, float ySpd, float xAcc, float yAcc){
		this(xSpd, ySpd, xAcc, yAcc, 0);
	}
	public Vector (float xSpd, float ySpd, float degrees){
		this(xSpd, ySpd, ZERO, ZERO, degrees);
	}
	public Vector (float xSpd, float ySpd){
		this(xSpd, ySpd, ZERO, ZERO, 0);
	}
	public Vector(){
		this (ZERO, ZERO, ZERO, ZERO, 0);
	}
	
	//Update Method
	public void update(long updateTimeDiff){
		float mult = (float)(updateTimeDiff / 1000.0);
		xSpd += xAcc * mult;
		ySpd += yAcc * mult;
		degrees = MathUtility.wrapDegrees(degrees + (targetRotateSpeed * 
		targetRotateDirection * mult) + (continuousRotateSpeed * 
		continuousRotateDirection * mult));
		if (hasReachedTarget()) stopTargetRotation();
	}
	
	//1D Motion Methods
	public void moveLeft(float speed){
		xSpd = Math.abs(speed) * DIR_LEFT;
		ySpd = ZERO;
	}
	public void moveRight(float speed){
		xSpd = Math.abs(speed) * DIR_RIGHT;
		ySpd = ZERO;
	}
	public void moveUp(float speed){
		xSpd = ZERO;
		ySpd = Math.abs(speed) * DIR_UP;
	}
	public void moveDown(float speed){
		xSpd = ZERO;
		ySpd = Math.abs(speed) * DIR_DOWN;
	}
	public void halt(){
		xSpd = ZERO;
		ySpd = ZERO;
	}
	
	//2D Motion Methods
	public void moveUpLeft(float xSpeed, float ySpeed){
		xSpd = Math.abs(xSpeed) * DIR_LEFT;
		ySpd = Math.abs(ySpeed) * DIR_UP;
	}
	public void moveUpLeft(float speed){
		moveUpLeft(speed, speed);
	}
	public void moveUpRight(float xSpeed, float ySpeed){
		xSpd = Math.abs(xSpeed) * DIR_RIGHT;
		ySpd = Math.abs(ySpeed) * DIR_UP;
	}
	public void moveUpRight(float speed){
		moveUpRight(speed, speed);
	}
	public void moveDownLeft(float xSpeed, float ySpeed){
		xSpd = Math.abs(xSpeed) * DIR_LEFT;
		ySpd = Math.abs(ySpeed) * DIR_DOWN;
	}
	public void moveDownLeft(float speed){
		moveDownLeft(speed, speed);
	}
	public void moveDownRight(float xSpeed, float ySpeed){
		xSpd = Math.abs(xSpeed) * DIR_RIGHT;
		ySpd = Math.abs(ySpeed) * DIR_UP;
	}
	public void moveDownRight(float speed){
		moveDownRight(speed, speed);
	}
	
	//Rotate Methods
	public void rotateTo(float newDegrees, float rotateSpeed){
		if (Math.abs(degrees - newDegrees) < 10 || Math.abs(degrees - newDegrees) > 350) {
			degrees = newDegrees;
		} else {
			targetDegrees = newDegrees;
			targetRotateSpeed = rotateSpeed;
			targetRotateDirection = computeTargetRotateDirection();
		}
	}
	public void rotate(float rotDegrees, float rotateSpeed){
		rotateTo(MathUtility.wrapDegrees(degrees + rotDegrees), rotateSpeed);
	}
	public void continuousRotate(int rotDirection, float rotateSpeed){
		continuousRotateDirection = rotDirection;
		continuousRotateSpeed = rotateSpeed;
	}
	public void stopAllRotation(){
		stopTargetRotation();
		stopContinuousRotation();
	}
	public void stopTargetRotation(){
		targetRotateSpeed = 0.0f;
	}
	public void stopContinuousRotation(){
		continuousRotateSpeed = 0.0f;
	}
	
	//Target Computing Methods
	public int computeTargetRotateDirection(){
		float diff = targetDegrees - degrees;
		int direction = 0;
		if (diff > 0) direction = 1;
		else direction = -1;
		if (Math.abs(diff) > 180) direction *= -1;
		return direction;
	}
	public boolean hasReachedTarget(){
		return computeTargetRotateDirection() != targetRotateDirection;
	}
	
	//Toggle Direction Methods
	public void toggleXDirection(){
		xSpd *= -1;
	}
	public void toggleYDirection(){
		ySpd *= -1;
	}
	public void toggleBothDirections(){
		toggleXDirection();
		toggleYDirection();
	}
	
	//Set Methods
	public void setDegrees(float newDegrees){
		degrees = newDegrees;
	}
	public void setXDirection(int newXDir){
		xSpd = Math.abs(xSpd) * newXDir;
	}
	public void setYDirection(int newYDir){
		ySpd = Math.abs(ySpd) * newYDir;
	}
	public void setDirection(int[] newDir){
		setXDirection(newDir[0]);
		setYDirection(newDir[1]);
	}
	public void setXSpeed(float newXSpd){
		xSpd = newXSpd;
	}
	public void setYSpeed(float newYSpd){
		ySpd = newYSpd;
	}
	public void setSpeed(float[] newSpd){
		setXSpeed(newSpd[0]);
		setYSpeed(newSpd[1]);
	}
	public void setXAcceleration(float newXAcc){
		xAcc = newXAcc;
	}
	public void setYAcceleration(float newYAcc){
		yAcc = newYAcc;
	}
	public void setAcceleration(float[] newAcc){
		setXAcceleration(newAcc[0]);
		setYAcceleration(newAcc[1]);
	}
	
	//Get Methods
	public float getDegrees(){
		return degrees;
	}
	public int getXDirection(){
		return (int)(xSpd / Math.abs(xSpd));
	}
	public int getYDirection(){
		return (int)(ySpd / Math.abs(ySpd));
	}
	public int[] getDirection(){
		int[] direction = {getXDirection(), getYDirection()};
		return direction;
	}
	public float getXSpeed(){
		return xSpd;
	}
	public float getYSpeed(){
		return ySpd;
	}
	public float[] getSpeed(){
		float[] speed = {xSpd, ySpd};
		return speed;
	}
	public float getXAcceleration(){
		return xAcc;
	}
	public float getYAcceleration(){
		return yAcc;
	}
	public float[] getAcceleration(){
		float[] acceleration = {xAcc, yAcc};
		return acceleration;
	}
}
