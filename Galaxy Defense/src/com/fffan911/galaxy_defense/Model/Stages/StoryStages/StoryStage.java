package com.fffan911.galaxy_defense.Model.Stages.StoryStages;

import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Stages.Stage;
import com.fffan911.galaxy_defense.Model.Stages.World;

public abstract class StoryStage extends Stage {
	
	//Constructor
	public StoryStage(World world, int stageNumber, String stageType) {
		super(world, stageNumber, stageType);
	}
	
	//Get Methods
	@Override
	public GameMode getGameMode() {
		return GameMode.STORY;
	}
}
