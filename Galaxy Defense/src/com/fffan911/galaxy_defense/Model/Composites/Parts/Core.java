package com.fffan911.galaxy_defense.Model.Composites.Parts;

import com.fffan911.galaxy_defense.Model.Composites.Composite;

public abstract class Core extends Composite {
	
	//Non-Standard Composite Defaults
	@Override
	public int getMaxHealthAddition() {
		return 0;
	}
	@Override
	public int getMaxArmorAddition() {
		return 0;
	}
	@Override
	public float getMaxHealthMultiplier() {
		return 1.0f;
	}
	@Override
	public float getMaxArmorMultiplier() {
		return 1.0f;
	}
}
