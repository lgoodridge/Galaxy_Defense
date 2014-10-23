package com.fffan911.galaxy_defense.Model.Stages.StoryStages;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Model.Actors.TargetDummy;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Grunt;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Stages.Cue;
import com.fffan911.galaxy_defense.Model.Stages.World;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class StoryStage_0_2 extends StoryStage {
	//Constants
	private static final String TAG = "StoryStage_0_2";
	
	//Constructor
	public StoryStage_0_2() {
		super(World.ZERO, 2, "Asteroids");
	}
	
	//Stage Methods
	@Override
	public List<Cue> constructCueList(GamePanel panel) {
		List<Cue> cueList = new ArrayList<Cue>();
		Enemy enemy = new Grunt(panel, new Position(50, 200), 97);
		enemy.randomizeSpeed();
		cueList.add(new Cue(enemy, 0));
		TargetDummy targetDummy = new TargetDummy(panel, new Position(0, 0));
		targetDummy.randomizeSpeedAndPosition();
		cueList.add(new Cue(targetDummy, 0));
		for (int i = 0; i < 100; i++) {
			targetDummy = new TargetDummy(panel, new Position(0, 0));
			targetDummy.randomizeSpeedAndPosition();
			cueList.add(new Cue(targetDummy, 3000 + i * 720));
		}
		return cueList;
	}
	@Override
	public void onVictory() {
		GenericProxyUser gpu = (GenericProxyUser)(getPanel().getContext());
		gpu.getProxy().switchToMainMenu();
		gpu.getUIProxy().displayControlsPopup();
	}
	@Override
	public void onDefeat() {}
	@Override
	public boolean victoryConditionReached() {
		return getStageRunTime() > 3000;
	}
	@Override
	public boolean defeatConditionReached() {
		return false;
	}
}
