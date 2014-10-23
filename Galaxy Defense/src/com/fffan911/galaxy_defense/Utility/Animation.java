package com.fffan911.galaxy_defense.Utility;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class Animation {
	//Attributes and References
	private ArrayList<Bitmap> bitmaps;
	private int currFrameNumber;
	private int framePeriod;
	private long currGameTime;
	private long lastFrameShift;
	//Constants
	public static final int SINGLE_FRAME = -1;
	
	//Constructors
	public Animation(Bitmap[] bitmaps, int framePeriod){
		this.bitmaps = new ArrayList<Bitmap>();
		this.currFrameNumber = 1;
		this.framePeriod = framePeriod;
		this.currGameTime = System.currentTimeMillis();
		this.lastFrameShift = System.currentTimeMillis();
		if (bitmaps != null) {
			for (Bitmap bitmap : bitmaps) this.bitmaps.add(bitmap);
		}
	}
	public Animation(int framePeriod){
		this(null, framePeriod);
	}
	
	//Update Method
	public void update(long updateTimeDiff){
		currGameTime += updateTimeDiff;
		if (framePeriod == SINGLE_FRAME) return;
		if (currGameTime - lastFrameShift > framePeriod) {
			currFrameNumber = currFrameNumber % getNumberOfBitmaps() + 1;
			lastFrameShift = currGameTime;
		}
	}
	
	//Add + Remove methods
	public void addBitmap(Bitmap bitmap){
		bitmaps.add(bitmap);
	}
	public void removeBitmap(Bitmap bitmap){
		bitmaps.remove(bitmap);
	}
	
	//Set Methods
	public void setCurrentFrameNumber(int newFrameNumber) {
		currFrameNumber = newFrameNumber;
	}
	
	//Get methods
	public Bitmap getCurrentBitmap(){
		return bitmaps.get(currFrameNumber-1);
	}
	public int getNumberOfBitmaps(){
		return bitmaps.size();
	}
}
