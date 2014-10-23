package com.fffan911.galaxy_defense.Model.Physics;

import com.fffan911.galaxy_defense.Utility.MathUtility;

public class Position {
	//References
	private Vector vector;
	private PatternManager pattern;
	//Attributes
	private int x;
	private int y;
	private long targetTime;
	//Constants
	private static final String TAG = "Position";
	
	//Constructors
	public Position(int x, int y, float xSpd, float ySpd, float xAcc, float yAcc, float degrees){
		this.vector = new Vector(xSpd, ySpd, xAcc, yAcc, degrees);
		this.pattern = new PatternManager(this);
		this.x = x;
		this.y = y;
		this.targetTime = -1l;
	}
	public Position(int x, int y, float xSpd, float ySpd, float xAcc, float yAcc){
		this(x, y, xSpd, ySpd, xAcc, yAcc, 0);
	}
	public Position(int x, int y, float xSpd, float ySpd, float degrees){
		this(x, y, xSpd, ySpd, Vector.ZERO, Vector.ZERO, degrees);
	}
	public Position(int x, int y, float xSpd, float ySpd){
		this(x, y, xSpd, ySpd, Vector.ZERO, Vector.ZERO, 0);
	}
	public Position(int x, int y, float degrees){
		this(x, y, Vector.ZERO, Vector.ZERO, Vector.ZERO, Vector.ZERO, 0);
	}
	public Position(int x, int y){
		this(x, y, Vector.ZERO, Vector.ZERO, Vector.ZERO, Vector.ZERO, 0);
	}
	
	//Update Method
	public void update(long updateTimeDiff){
		if (updateTimeDiff > 100 || updateTimeDiff < 10) return;
		vector.update(updateTimeDiff);
		double mult = updateTimeDiff / 1000.0;
		double deltaX = getXSpeed() * mult;
		double deltaY = getYSpeed() * mult;
		if (Double.isNaN(deltaX) || Double.isNaN(deltaY)) return;
		x += deltaX;
		y += deltaY;
		if (targetTime != -1l && System.currentTimeMillis() > targetTime){
			targetTime = -1l;
			halt();
		}
	}
	
	//Calculation Methods
	public double distanceFrom(Position otherPosition){
		int xDiffSquared = MathUtility.squareNum(getX() - otherPosition.getX());
		int yDiffSquared = MathUtility.squareNum(getY() - otherPosition.getY());
		return MathUtility.squareRootNum(xDiffSquared + yDiffSquared);
	}
	
	//1D Motion Methods
	public void moveLeft(float speed){
		vector.moveLeft(speed);
	}
	public void moveRight(float speed){
		vector.moveRight(speed);
	}
	public void moveUp(float speed){
		vector.moveUp(speed);
	}
	public void moveDown(float speed){
		vector.moveDown(speed);
	}
	public void halt(){
		vector.halt();
	}
	
	//2D Motion Methods
	public void moveUpLeft(float speed){
		vector.moveUpLeft(speed);
	}
	public void moveUpLeft(float xSpeed, float ySpeed){
		vector.moveUpLeft(xSpeed, ySpeed);
	}
	public void moveUpRight(float speed){
		vector.moveUpRight(speed);
	}
	public void moveUpRight(float xSpeed, float ySpeed){
		vector.moveUpRight(xSpeed, ySpeed);
	}
	public void moveDownLeft(float speed){
		vector.moveDownLeft(speed);
	}
	public void moveDownLeft(float xSpeed, float ySpeed){
		vector.moveDownLeft(xSpeed, ySpeed);
	}
	public void moveDownRight(float speed){
		vector.moveDownRight(speed);
	}
	public void moveDownRight(float xSpeed, float ySpeed){
		vector.moveDownRight(xSpeed, ySpeed);
	}
	
	//Target Motion Methods
	public void moveTo(int toX, int toY, int time){
		targetTime = System.currentTimeMillis() + time;
		float secs = (float)time / 1000f;
		float deltaX = toX - x;
		float deltaY = toY - y;
		if (deltaX < 0) toggleXDirection();
		if (deltaY < 0) toggleYDirection();
		setXSpeed(deltaX / secs);
		setYSpeed(deltaY / secs);
	}
	public void moveTo(int[] toPos, int time){
		moveTo(toPos[0], toPos[1], time);
	}
	public void moveTo(int toX, int toY, float speed){
		float deltaX = toX - x;
		float deltaY = toY - y;
		float deltaTot = MathUtility.hypotenuse(deltaX, deltaY);
		int calcTime = (int)(deltaTot * 1000.0f / speed);
		moveTo(toX, toY, calcTime);
	}
	public void moveTo(int[] toPos, float speed){
		moveTo(toPos[0], toPos[1], speed);
	}
	public void moveTo(int toX, int toY){
		float speed = MathUtility.hypotenuse(vector.getXSpeed(), vector.getYSpeed());
		if (speed > 0) moveTo(toX, toY, speed);
	}
	public void moveTo(int[] toPos){
		moveTo(toPos[0], toPos[1]);
	}
	
	public void moveInDirection(float degrees, float speed){
		setXSpeed(MathUtility.sin(degrees) * speed);
		setYSpeed(MathUtility.cos(degrees) * speed * -1);
	}
	
	//Rotate Methods
	public void rotateLeftTurn(float rotateSpeed){
		vector.rotate(-90, rotateSpeed);
	}
	public void rotateRightTurn(float rotateSpeed){
		vector.rotate(90, rotateSpeed);
	}
	public void rotate180(float rotateSpeed){
		vector.rotate(180, rotateSpeed);
	}
	public void rotate(float rotDegrees, float rotateSpeed){
		vector.rotate(rotDegrees, rotateSpeed);
	}
	public void rotateTo(float newDegrees, float rotateSpeed){
		vector.rotateTo(newDegrees, rotateSpeed);
	}
	public void continuousRotate(int rotDirection, float rotateSpeed){
		vector.continuousRotate(rotDirection, rotateSpeed);
	}
	
	//Toggle Direction Methods
	public void toggleXDirection(){
		vector.toggleXDirection();
	}
	public void toggleYDirection(){
		vector.toggleYDirection();
	}
	public void toggleBothDirections(){
		toggleXDirection();
		toggleYDirection();
	}
	
	//Set Methods
	public void setX(int newX){
		x = newX;
	}
	public void setY(int newY){
		y = newY;
	}
	public void setPosition(int[] newPos){
		x = newPos[0];
		y = newPos[1];
	}
	public void setDegrees(float newDegrees){
		vector.setDegrees(newDegrees);
	}
	public void setXDirection(int newXDir){
		vector.setXDirection(newXDir);
	}
	public void setYDirection(int newYDir){
		vector.setYDirection(newYDir);
	}
	public void setDirection(int[] newDir){
		vector.setDirection(newDir);
	}
	public void setXSpeed(float newXSpd){
		vector.setXSpeed(newXSpd);
	}
	public void setYSpeed(float newYSpd){
		vector.setYSpeed(newYSpd);
	}
	public void setSpeed(float[] newSpd){
		vector.setSpeed(newSpd);
	}
	public void setXAcceleration(float newXAcc){
		vector.setXAcceleration(newXAcc);
	}
	public void setYAcceleration(float newYAcc){
		vector.setYAcceleration(newYAcc);
	}
	public void setAcceleration(float[] newAcc){
		vector.setAcceleration(newAcc);
	}
	
	//Get Methods
	public Vector getVector(){
		return vector;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int[] getPosition(){
		int[] position = {x, y};
		return position;
	}
	public float getDegrees(){
		return vector.getDegrees();
	}
	public int getXDirection(){
		return vector.getXDirection();
	}
	public int getYDirection(){
		return vector.getYDirection();
	}
	public int[] getDirection(){
		return vector.getDirection();
	}
	public float getXSpeed(){
		return vector.getXSpeed();
	}
	public float getYSpeed(){
		return vector.getYSpeed();
	}
	public float[] getSpeed(){
		return vector.getSpeed();
	}
	public float getXAcceleration(){
		return vector.getXAcceleration();
	}
	public float getYAcceleration(){
		return vector.getYAcceleration();
	}
	public float[] getAcceleration(){
		return vector.getAcceleration();
	}
}
