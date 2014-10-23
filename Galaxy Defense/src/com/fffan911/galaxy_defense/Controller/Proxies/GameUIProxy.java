package com.fffan911.galaxy_defense.Controller.Proxies;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Activities.GameActivity;
import com.fffan911.galaxy_defense.View.Customs.GamePanel;
import com.fffan911.galaxy_defense.View.Customs.HealthBar;
import com.fffan911.galaxy_defense.View.Customs.ScoreTextView;

import android.app.Activity;
import android.util.Log;

public class GameUIProxy extends GenericUIProxy {
	//Constants
	private static final String TAG = "GameUIProxy";
	
	//Constructor
	public GameUIProxy(GameActivity activity) {
		super(activity);
	}
	
	//Get Methods
	public GamePanel getGamePanel(){
		if (findViewById(R.id.battle_panel) != null) {
			return (GamePanel)(findViewById(R.id.battle_panel));
		}
		return (GamePanel)(findViewById(R.id.asteroids_panel));
	}
	public HealthBar getHealthBar() {
		return (HealthBar)(findViewById(R.id.health_bar));
	}
	public ScoreTextView getScoreView() {
		return (ScoreTextView)(findViewById(R.id.score_text_view));
	}
}
