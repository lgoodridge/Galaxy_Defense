package com.fffan911.galaxy_defense.Controller.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fffan911.galaxy_defense.R;

public class AsteroidsSideFragment extends SideFragment {
	//Constants
	private static final String TAG = "AsteroidsSideFragment";
	
	//Fragment Methods
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.asteroids_side_fragment_layout, container, false);
	}
}
