package com.fffan911.galaxy_defense.Model.Actors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;

import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Utility.Animation;
import com.fffan911.galaxy_defense.Utility.RandomUtility;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public abstract class Actor {
	//References
	private GamePanel panel;
	private Position position;
	private Animation animation;
	private Animation background;
	private Matrix matrix;
	//Constants
	private static final float DEFAULT_MAX_SPEED = 200.0f;
	private static final String TAG = "Actor";
	
	//Constructor
	public Actor(GamePanel panel, Position initialPosition) {
		this.panel = panel;
		this.position = initialPosition;
		this.animation = constructAnimation(panel);
		this.background = null;
		this.matrix = new Matrix();
		panel.linkActor(this);
	}
	public Actor() {}
	
	//Construct Methods
	protected final Animation constructAnimation(GamePanel panel){
		return new Animation(getAnimationBitmaps(panel), getAnimationFramePeriod());
	}
	
	//Actor Methods
	public void update(long updateTimeDiff){
		position.update(updateTimeDiff);
		if (hasBackground()) background.update(updateTimeDiff);
		animation.update(updateTimeDiff);
	}
	public void render(Canvas canvas){
		Bitmap bitmap = getCurrentBitmap();
		matrix.reset();
		matrix.postTranslate(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2);
		matrix.postRotate(position.getDegrees());
		matrix.postTranslate(getX(), getY());
		if (hasBackground()) {
			Bitmap backgroundBitmap = getCurrentBackgroundBitmap();
			canvas.drawBitmap(backgroundBitmap, matrix, null);
		}
		canvas.drawBitmap(bitmap, matrix, null);
	}
	public void deref(){
		panel.unlinkActor(this);
	}
	
	//Link and Unlink Methods
	public void linkToPanel() {
		panel.linkActor(this);
	}
	public void unlinkFromPanel() {
		panel.unlinkActor(this);
	}
	
	//Randomize Methods
	public void randomizeSpeedAndPosition() {
		randomizePosition();
		randomizeSpeed();
	}
	public void randomizePosition() {
		int randomX = RandomUtility.randomInt(0, getPanel().getWidth());
		int randomY = RandomUtility.randomInt(0, getPanel().getHeight());
		getPosition().setX(randomX);
		getPosition().setY(randomY);
	}
	public void randomizeSpeed() {
		float randomXSpeed = RandomUtility.randomFloat(0.0f, DEFAULT_MAX_SPEED);
		float randomYSpeed = RandomUtility.randomFloat(0.0f, DEFAULT_MAX_SPEED);
		getPosition().setXSpeed(randomXSpeed);
		getPosition().setYSpeed(randomYSpeed);
	}
	
	//Interaction Methods
	public double distanceFrom(Actor otherActor){
		return getPosition().distanceFrom(otherActor.getPosition());
	}
	
	//Set Methods
	public void setX(int newX){
		position.setX(newX);
	}
	public void setY(int newY){
		position.setY(newY);
	}
	protected void setPanel(GamePanel panel) {
		this.panel = panel;
	}
	protected void setPosition(Position position) {
		this.position = position;
	}
	protected void setAnimation(Animation animation) {
		this.animation = animation;
	}
	protected void setBackground(Animation background) {
		this.background = background;
	}
	protected void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}
	
	//Boolean Methods
	public boolean isPositionOccupied(int x, int y){
		return isPixelOccupied(getPixel(x, y));
	}
	public boolean isPixelOccupied(int pixel){
		return pixel != Color.TRANSPARENT;
	}
	public boolean hasBackground() {
		return background != null;
	}
	
	//Complex Get Methods
	public int getLeftEdge(){
		return getX() - getWidth()/2;
	}
	public int getRightEdge(){
		return getX() + getWidth()/2;
	}
	public int getTopEdge(){
		return getY() - getHeight()/2;
	}
	public int getBottomEdge(){
		return getY() + getHeight()/2;
	}
	public int getPixel(int x, int y){
		int convX = x - getLeftEdge();
		int convY = y - getRightEdge();
		if (convX < 0 || convX >= getWidth() ||
			convY < 0 || convY >= getHeight()){
			return Color.TRANSPARENT;
		}
		return getCurrentBitmap().getPixel(convX, convY);
	}
	
	//Get Methods
	public GamePanel getPanel(){
		return panel;
	}
	public Position getPosition(){
		return position;
	}
	public Bitmap getCurrentBitmap(){
		return animation.getCurrentBitmap();
	}
	public Bitmap getCurrentBackgroundBitmap(){
		return background.getCurrentBitmap();
	}
	public Animation getAnimation(){
		return animation;
	}
	public Animation getBackground() {
		return background;
	}
	public int getX(){
		return position.getX();
	}
	public int getY(){
		return position.getY();
	}
	public int getWidth(){
		return getCurrentBitmap().getWidth();
	}
	public int getHeight(){
		return getCurrentBitmap().getHeight();
	}
	
	//Abstract Methods
	public abstract void handleCollision(Actor actor);
	public abstract void handleBoundsCollision(String edge);
	public abstract Bitmap[] getAnimationBitmaps(GamePanel panel);
	public abstract int getAnimationFramePeriod();
	public abstract int getScoreValue();
	public abstract String getName();
	public abstract String getDescription();
	
	//Log Methods
	public String toString(){
		return getName() + ":\n" + getDescription();
	}
}
