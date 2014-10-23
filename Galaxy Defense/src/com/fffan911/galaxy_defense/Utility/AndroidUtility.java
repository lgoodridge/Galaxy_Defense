package com.fffan911.galaxy_defense.Utility;

import com.fffan911.galaxy_defense.R;

import android.app.Activity;

public class AndroidUtility {
	//Activity Transition Methods
	public static final void fadeTransition(Activity activity){
		activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}
	public static final void hyperspaceTransition(Activity activity){
		activity.overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_in);
	}
	public static final void zoomTransition(Activity activity){
		activity.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
	}
}
