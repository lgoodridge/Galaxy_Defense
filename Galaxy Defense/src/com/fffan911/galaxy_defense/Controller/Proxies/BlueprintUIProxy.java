package com.fffan911.galaxy_defense.Controller.Proxies;

import android.view.ViewGroup;
import android.widget.TextView;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Activities.BlueprintActivity;
import com.fffan911.galaxy_defense.View.Customs.DisplayPanel;

public class BlueprintUIProxy extends GenericUIProxy {
	//Constants
	private static final String TAG = "BlueprintUIProxy";
	
	//Constructor
	public BlueprintUIProxy(BlueprintActivity activity) {
		super(activity);
	}
	
	//Get Methods
	public ViewGroup getDisplayLayout() {
		return (ViewGroup)activity.findViewById(R.id.display_fragment);
	}
	public ViewGroup getInformationLayout() {
		return (ViewGroup)activity.findViewById(R.id.information_fragment);
	}
	public DisplayPanel getDisplayPanel() {
		return (DisplayPanel)getDisplayLayout().findViewById(R.id.display_panel);
	}
	public TextView getInformationTextView() {
		return (TextView)getInformationLayout().findViewById(R.id.information_text_view);
	}
}
