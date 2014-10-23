package com.fffan911.galaxy_defense.Controller.Proxies;

import com.fffan911.galaxy_defense.R;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

public class GenericUIProxy {
	//References
	protected Activity activity;
	private PopupWindow optionsPopupWindow;
	private PopupWindow controlsPopupWindow;
	private PopupWindow stageSelectorPopupWindow;
	private View optionsPopupView;
	private View controlsPopupView;
	private View stageSelectorPopupView;
	//Constants
	private static final String TAG = "GenericUIProxy";
	
	//Constructor
	public GenericUIProxy(Activity activity){
		this.activity = activity;
		LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService
		(Activity.LAYOUT_INFLATER_SERVICE);
		optionsPopupWindow = new PopupWindow(activity);
		optionsPopupView = inflater.inflate(R.layout.options_popup_layout, null);
		optionsPopupWindow.setContentView(optionsPopupView);
		controlsPopupWindow = new PopupWindow(activity);
		controlsPopupView = inflater.inflate(R.layout.controls_popup_layout, null);
		controlsPopupWindow.setContentView(controlsPopupView);
	}
	
	//Popup Methods
	public void displayOptionsPopup() {
		closeAllPopups();
		optionsPopupWindow.showAtLocation(optionsPopupView,
		Gravity.CENTER, 0, 0);
		optionsPopupWindow.update(getScreenWidth()/2, getScreenHeight());
	}
	public void displayControlsPopup() {
		closeAllPopups();
		controlsPopupWindow.showAtLocation(controlsPopupView,
		Gravity.CENTER, 0, 0);
		controlsPopupWindow.update(getScreenWidth()*3/4, getScreenHeight());
	}
	public void displayStageSelectorPopup() {
		closeAllPopups();
		LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService
		(Activity.LAYOUT_INFLATER_SERVICE);
		stageSelectorPopupWindow = new PopupWindow(activity);
		stageSelectorPopupView = inflater.inflate(R.layout.stage_selector_popup_layout, null);
		stageSelectorPopupWindow.setContentView(stageSelectorPopupView);
		stageSelectorPopupWindow.showAtLocation(stageSelectorPopupView,
		Gravity.CENTER, 0, 0);
		stageSelectorPopupWindow.update(getScreenWidth()*3/4, getScreenHeight());
	}
	public void closeOptionsPopup() {
		optionsPopupWindow.dismiss();
	}
	public void closeControlsPopup() {
		controlsPopupWindow.dismiss();
	}
	public void closeStageSelectorPopup() {
		if (stageSelectorPopupWindow != null) stageSelectorPopupWindow.dismiss();
	}
	public void closeAllPopups() {
		closeOptionsPopup();
		closeControlsPopup();
		closeStageSelectorPopup();
	}
	
	//View Methods
	public View findViewById(int viewId){
		return activity.findViewById(viewId);
	}
	
	//Get Methods
	public int getScreenWidth(){
		return activity.getWindowManager().getDefaultDisplay().getWidth();
	}
	public int getScreenHeight(){
		return activity.getWindowManager().getDefaultDisplay().getHeight();
	}
}
