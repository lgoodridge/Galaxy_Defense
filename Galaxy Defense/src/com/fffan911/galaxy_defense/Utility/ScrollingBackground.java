package com.fffan911.galaxy_defense.Utility;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ScrollingBackground {
	//References
	private Bitmap bitmap;
	//Attributes
	private float posX;
	private float posY;
	private float dX;
	private float dY;
	
	//Constructor
	public ScrollingBackground(Bitmap bitmap, float posX, float posY, float dX, float dY){
		this.bitmap = bitmap;
		this.posX = posX;
		this.posY = posY;
		this.dX = dX;
		this.dY = dY;
	}
	
	//Update Method
	public void update(long updateTimeDiff){
		double mult = updateTimeDiff / 1000.0;
		posX += dX * mult;
		posY += dY * mult;
		if (posX < -bitmap.getWidth()) posX += bitmap.getWidth();
		if (posX > bitmap.getWidth()) posX -= bitmap.getWidth();
		if (posY < -bitmap.getHeight()) posY += bitmap.getHeight();
		if (posY > bitmap.getHeight()) posY -= bitmap.getHeight();
	}
	
	//Render Method
	public void render(Canvas canvas){
		canvas.drawBitmap(bitmap, posX, posY, null);
		if (getBoundsOutLeft(canvas) > 0) {
			float newLeftEdge = getBoundsOutLeft(canvas) - bitmap.getWidth();
			canvas.drawBitmap(bitmap, newLeftEdge, posY, null);
		} else if (getBoundsOutRight(canvas) > 0) {
			float newLeftEdge = getRightEdge();
			canvas.drawBitmap(bitmap, newLeftEdge, posY, null);
		}
		if (getBoundsOutTop(canvas) > 0) {
			float newTopEdge = getBoundsOutTop(canvas) - bitmap.getHeight();
			canvas.drawBitmap(bitmap, posX, newTopEdge, null);
		} else if (getBoundsOutBottom(canvas) > 0) {
			float newTopEdge = getBottomEdge();
			canvas.drawBitmap(bitmap, posX, newTopEdge, null);
		}
	}
	
	//Boolean Methods
	public boolean isScrollingLeft(){
		return dX < 0;
	}
	public boolean isScrollingRight(){
		return dX > 0;
	}
	public boolean isScrollingUp(){
		return dY < 0;
	}
	public boolean isScrollingDown(){
		return dY > 0;
	}
	
	//Set Methods
	public void setBitmap(Bitmap newBitmap){
		bitmap = newBitmap;
	}
	public void setPosX(int newPosX){
		posX = newPosX;
	}
	public void setPosY(int newPosY){
		posY = newPosY;
	}
	public void setDX(int newDX){
		dX = newDX;
	}
	public void setDY(int newDY){
		dY = newDY;
	}
	
	//High-Level Get Methods
	public float getBoundsOutLeft(Canvas canvas){
		return getLeftEdge();
	}
	public float getBoundsOutRight(Canvas canvas){
		return canvas.getWidth() - getRightEdge();
	}
	public float getBoundsOutTop(Canvas canvas){
		return getTopEdge();
	}
	public float getBoundsOutBottom(Canvas canvas){
		return canvas.getHeight() - getBottomEdge();
	}
	
	//Get Methods
	public Bitmap getBitmap(){
		return bitmap;
	}
	public double getDX(){
		return dX;
	}
	public double getDY(){
		return dY;
	}
	public float getLeftEdge(){
		return posX;
	}
	public float getRightEdge(){
		return posX + bitmap.getWidth();
	}
	public float getTopEdge(){
		return posY;
	}
	public float getBottomEdge(){
		return posY + bitmap.getHeight();
	}
}
