package com.fffan911.galaxy_defense.Model.Stages;

import java.util.List;

public class Script {
	//References
	private List<Cue> cueList;
	//Attributes
	private long scriptRunTime;
	//Constants
	private static final String TAG = "Script";
	
	//Constructor
	public Script(List<Cue> cueList) {
		this.cueList = cueList;
		this.scriptRunTime = 0l;
	}
	
	//Update Methods
	public void update(long updateTimeDiff) {
		scriptRunTime += updateTimeDiff;
		if (cueList.isEmpty()) return;
		if (scriptRunTime >= cueList.get(0).getEntranceTime()) {
			cueList.remove(0).getActor().linkToPanel();
		}
	}
	
	//Get Methods
	public List<Cue> getCueList() {
		return cueList;
	}
	public long getScriptRunTime() {
		return scriptRunTime;
	}
}
