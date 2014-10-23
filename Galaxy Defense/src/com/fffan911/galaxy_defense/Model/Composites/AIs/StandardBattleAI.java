package com.fffan911.galaxy_defense.Model.Composites.AIs;

import com.fffan911.galaxy_defense.Model.Actors.Actor;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;
import com.fffan911.galaxy_defense.Utility.RandomUtility;

public class StandardBattleAI extends BattleAI {
	//Constants
	private static final String TAG = "StandardBattleAI";
	
	//Constructors
	public StandardBattleAI(Enemy ownerEnemy) {
		super(ownerEnemy);
	}
	public StandardBattleAI() {
		super();
	}
	
	//AI Methods
	@Override
	public void update(long updateTimeDiff) {
		int random = RandomUtility.randomInt(1, 100);
		if (random < 5) {
			getOwnerEnemy().equipWeapon(getOwnerEnemy().getOwnedWeapons()[0]);
			getOwnerEnemy().shoot();
		}
	}
	@Override
	public void handleCollision(Actor actor) {
		//MAKE THIS DO SOMETHING
	}
	@Override
	public void handleBoundsCollision(String edge) {
		//MAKE THIS DO SOMTHING
		if (edge.equals("Left") || edge.equals("Right")) {
			getOwnerEnemy().getPosition().toggleXDirection();
		}
		if (edge.equals("Top") || edge.equals("Bottom")) {
			getOwnerEnemy().getPosition().toggleYDirection();
		}
	}
	
	//Get Methods
	@Override
	public String getName() {
		return "Standard Battle AI";
	}
	@Override
	public String getDescription() {
		return "The default enemy archetype. Expresses no special behaviors";
	}
}
