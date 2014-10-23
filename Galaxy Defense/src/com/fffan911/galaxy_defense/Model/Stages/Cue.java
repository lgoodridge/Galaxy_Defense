package com.fffan911.galaxy_defense.Model.Stages;

import com.fffan911.galaxy_defense.Model.Actors.Actor;

public class Cue {
	//Attributes and References
	private Actor actor;
	private long entranceTime;
	
	//Constructor
	public Cue(Actor actor, long entranceTime) {
		actor.unlinkFromPanel();
		this.actor = actor;
		this.entranceTime = entranceTime;
	}
	
	//Get Methods
	public Actor getActor() {
		return actor;
	}
	public long getEntranceTime() {
		return entranceTime;
	}
}
