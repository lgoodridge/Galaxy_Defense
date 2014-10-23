package com.fffan911.galaxy_defense.Model.Elements;

import com.fffan911.galaxy_defense.Model.Actors.Ship;

public class FireElement extends Element {
	//Constants
	private static final String TAG = "FireElement";
	
	//Constructors
	public FireElement(int level) {
		super(level);
	}
	public FireElement() {
		super();
	}
	
	//Action Methods
	@Override
	protected void activateEffect(long updateTimeDiff, Ship ship) {
		// TODO Auto-generated method stub
	}
	@Override
	public void elementAlreadyActiveEffect(Ship ship, Element activeElement) {
		// TODO Auto-generated method stub
	}
	
	//Determine Methods
	@Override
	protected long detActiveTime() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected boolean detIsTimeless() {
		return false;
	}
	
	//Get Methods
	@Override
	public String getName() {
		return "Flame";
	}
	@Override
	public String getSummary() {
		return "Sets target on fire, causing continual damage to health. Deals critical " +
		"damage to unexposed targets.";
	}
	@Override
	public String getLevelEffectChart() {
		return "Effects by Level:\n " +
		"Level 1: Extra damage dealt to unexposed targets.\n" +
		"Level 10: Target briefly catches fire, dealing small damage to health over time.\n" +
		"Level 50: \"Restless Flame\" - Each shot not only resets the burn timer, but adds a small amount to it.\n" +
		"Level 100: \"Rekindling Flame\" - Each shot violently sets the target aflame anew, resulting in a small explosion.";
	}
}
