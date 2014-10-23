package com.fffan911.galaxy_defense.Model.Composites.AIs;

import com.fffan911.galaxy_defense.Model.Actors.Actor;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;

public abstract class AI {
	//References
	private Enemy ownerEnemy;
	
	//Constructors
	public AI(Enemy ownerEnemy) {
		this.ownerEnemy = ownerEnemy;
	}
	public AI() {
		this(null);
	}
	
	//Deref Method
	public void deref() {
		ownerEnemy = null;
	}
	
	//Set Methods
	public final void setOwnerEnemy(Enemy enemy) {
		ownerEnemy = enemy;
	}
	
	//Get Methods
	public Enemy getOwnerEnemy() {
		return ownerEnemy;
	}
	
	//Abstract Methods
	public abstract void update(long updateTimeDiff);
	public abstract void handleCollision(Actor actor);
	public abstract void handleBoundsCollision(String edge);
	public abstract String getName();
	public abstract String getDescription();
}
