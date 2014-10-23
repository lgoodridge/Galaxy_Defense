package com.fffan911.galaxy_defense.Model.Stages.ArcadeStages;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.Model.Actors.TargetDummy;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Stages.Cue;
import com.fffan911.galaxy_defense.Model.Stages.World;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class ArcadeStage_0_1 extends ArcadeStage {
	//Constants
	private static final String TAG = "ArcadeStage_0_1";
	
	//Constructor
	public ArcadeStage_0_1(){
		super(World.ZERO, 1, "Asteroids");
	}
	
	//Stage Methods
	@Override
	public List<Cue> constructCueList(GamePanel panel) {
		List<Cue> cueList = new ArrayList<Cue>();
		TargetDummy targetDummy;
		for (int i = 0; i < 100; i++) {
			targetDummy = new TargetDummy(panel, new Position(0, 0));
			targetDummy.randomizeSpeedAndPosition();
			cueList.add(new Cue(targetDummy, 3000 + i * 720));
		}
		return cueList;
	}
	@Override
	public void onVictory() {}
	@Override
	public void onDefeat() {}
	@Override
	public boolean victoryConditionReached() {
		return this.getStageRunTime() > 75000;
	}
	@Override
	public boolean defeatConditionReached() {
		return false;
	}

}
