package com.fffan911.galaxy_defense.Controller.Proxies;

import com.fffan911.galaxy_defense.R;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

public class MainMenuUIProxy extends GenericUIProxy {
	//References
	private PopupWindow creditsPopupWindow;
	private PopupWindow comingSoonPopupWindow;
	private View creditsPopupView;
	private View comingSoonPopupView;
	//Constants
	private static final String TAG = "MainMenuUIProxy";
	
	//Constructor
	public MainMenuUIProxy(Activity activity){
		super(activity);
		LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService
		(Activity.LAYOUT_INFLATER_SERVICE);
		creditsPopupWindow = new PopupWindow(activity);
		creditsPopupView = inflater.inflate(R.layout.credits_popup_layout, null);
		creditsPopupWindow.setContentView(creditsPopupView);
		comingSoonPopupWindow = new PopupWindow(activity);
		comingSoonPopupView = inflater.inflate(R.layout.coming_soon_popup_layout, null);
		comingSoonPopupWindow.setContentView(comingSoonPopupView);
	}
	
	//Popup Methods
	public void displayCreditsPopup(){
		closeAllPopups();
		creditsPopupWindow.showAtLocation(creditsPopupView, Gravity.CENTER, 0, 0);
		creditsPopupWindow.update(getScreenWidth()*3/4, getScreenHeight());
	}
    public void displayComingSoonPopup(int x, int y){
    	comingSoonPopupWindow.dismiss();
    	comingSoonPopupWindow.showAtLocation(comingSoonPopupView, 
    	Gravity.NO_GRAVITY, x, y);
    	comingSoonPopupWindow.update(100, 75);
    }
    public void closeCreditsPopup(){
		creditsPopupWindow.dismiss();
	}
    public void closeComingSoonPopup(){
    	comingSoonPopupWindow.dismiss();
    }
	@Override
	public void closeAllPopups(){
		super.closeAllPopups();
		closeCreditsPopup();
		closeComingSoonPopup();
	}
}
