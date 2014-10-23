package com.fffan911.galaxy_defense.Model.Stages.ArcadeStages;

import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Stages.Stage;
import com.fffan911.galaxy_defense.Model.Stages.World;

public abstract class ArcadeStage extends Stage {
	
	//Comstructor
	public ArcadeStage(World world, int stageNumber, String stageType) {
		super(world, stageNumber, stageType);
	}

	//Constructor
	public GameMode getGameMode() {
		return GameMode.ARCADE;
	}
}
