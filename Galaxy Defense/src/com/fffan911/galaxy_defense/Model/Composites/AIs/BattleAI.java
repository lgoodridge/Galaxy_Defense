package com.fffan911.galaxy_defense.Model.Composites.AIs;

import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;

public abstract class BattleAI extends AI {
	
	//Constructors
	public BattleAI(Enemy ownerEnemy) {
		super(ownerEnemy);
	}
	public BattleAI() {
		super();
	}
}
