package com.fffan911.galaxy_defense.Controller.Fragments;

import com.fffan911.galaxy_defense.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BattleSideFragment extends SideFragment {
	//Constants
	private static final String TAG = "BattleSideFragment";
	
	//Fragment Methods
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.battle_side_fragment_layout, container, false);
	}
}
