package com.fffan911.galaxy_defense.Model.Stages.StoryStages;

import java.util.ArrayList;
import java.util.List;

import com.fffan911.galaxy_defense.Controller.Proxies.GenericProxyUser;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Grunt;
import com.fffan911.galaxy_defense.Model.Data.GameMode;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Stages.Cue;
import com.fffan911.galaxy_defense.Model.Stages.World;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;

public class StoryStage_0_1 extends StoryStage {
	//Constants
	private static final String TAG = "StoryStage_0_1";
	
	//Constructor
	public StoryStage_0_1() {
		super(World.ZERO, 1, "Battle");
	}
	
	//Stage Methods
	@Override
	public List<Cue> constructCueList(GamePanel panel) {
		List<Cue> cueList = new ArrayList<Cue>();
		Enemy enemy = new Grunt(panel, new Position(50, 200));
		enemy.randomizeSpeed();
		cueList.add(new Cue(enemy, 0));
		enemy = new Grunt(panel, new Position(100, 100));
		enemy.randomizeSpeed();
		cueList.add(new Cue(enemy, 0));
		enemy = new Grunt(panel, new Position(300, 150));
		enemy.randomizeSpeed();
		cueList.add(new Cue(enemy, 5000));
		enemy = new Grunt(panel, new Position(200, 50));
		enemy.randomizeSpeed();
		cueList.add(new Cue(enemy, 9000));
		return cueList;
	}
	@Override
	public void onVictory() {
		GenericProxyUser gpu = (GenericProxyUser)(getPanel().getContext());
		gpu.getProxy().switchToShop();
	}
	@Override
	public void onDefeat() {}
	@Override
	public boolean victoryConditionReached() {
		return false;
		//return getStageRunTime() > 3000;
	}
	@Override
	public boolean defeatConditionReached() {
		return false;
	}
	@Override
	public GameMode getGameMode() {
		return GameMode.STORY;
	}
}
