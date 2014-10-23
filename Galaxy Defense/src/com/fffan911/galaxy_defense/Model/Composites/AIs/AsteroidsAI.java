package com.fffan911.galaxy_defense.Model.Composites.AIs;

import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;

public abstract class AsteroidsAI extends AI {
	
	//Constructors
	public AsteroidsAI(Enemy ownerEnemy) {
		super(ownerEnemy);
	}
	public AsteroidsAI() {
		super();
	}
}
