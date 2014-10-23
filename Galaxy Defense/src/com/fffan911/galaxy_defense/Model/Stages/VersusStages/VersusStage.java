package com.fffan911.galaxy_defense.Model.Stages.VersusStages;

import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Stages.Stage;
import com.fffan911.galaxy_defense.Model.Stages.World;

public abstract class VersusStage extends Stage {
	
	//Constructor
	public VersusStage(World world, int stageNumber, String stageType) {
		super(world, stageNumber, stageType);
	}

	//Get Methods
	public GameMode getGameMode() {
		return GameMode.VERSUS;
	}
}
