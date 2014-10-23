package com.fffan911.galaxy_defense.Controller.Fragments;

import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.View.Buttons.BuyButton;
import com.fffan911.galaxy_defense.View.Buttons.DetailsButton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ShopFragment extends Fragment {
	//Constants
	private static final String TAG = "ShopFragment";
	
	//Fragment Methods
	@Override
	public void onCreate(Bundle savedInstanceState){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + "...");
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	Bundle savedInstanceState){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + " View...");
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		Log.d(TAG, "Parent Activity successfully created...");
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onDestroy(){
		Log.d(TAG, "Destroying " + getClass().getSimpleName() + "...");
		super.onDestroy();
	}
	@Override
	public void onStop(){
		Log.d(TAG, "Stopping " + getClass().getSimpleName() + "...");
		super.onStop();
	}
	
	//Shop Construction Methods
	protected View createPurchasableLayout(Purchasable purchasable, boolean weaponPurchasable) {
		LinearLayout purchasableLayout = new LinearLayout(getActivity());
		purchasableLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
		LinearLayout.LayoutParams.WRAP_CONTENT));
		purchasableLayout.setOrientation(LinearLayout.HORIZONTAL);
		purchasableLayout.setPadding(50, 20, 50, 0);
		purchasableLayout.setWeightSum(100);
		
		TextView nameTextView = new TextView(getActivity());
		nameTextView.setLayoutParams(new LinearLayout.LayoutParams(0,
		getActivity().getWindowManager().getDefaultDisplay().getHeight() / 6, 30));
		nameTextView.setText(purchasable.getName());
		
		TextView costTextView = new TextView(getActivity());
		costTextView.setLayoutParams(new LinearLayout.LayoutParams(0,
		LinearLayout.LayoutParams.WRAP_CONTENT, 30));
		costTextView.setText(purchasable.getCostString());
		
		DetailsButton detailsButton = new DetailsButton(getActivity(), purchasable.getDetails());
		detailsButton.setLayoutParams(new LinearLayout.LayoutParams(0, 
		LinearLayout.LayoutParams.WRAP_CONTENT, 25));
		
		BuyButton buyButton = new BuyButton(getActivity(), purchasable);
		buyButton.setHasWeaponPurchasableStored(weaponPurchasable);
		buyButton.setLayoutParams(new LinearLayout.LayoutParams(0,
		LinearLayout.LayoutParams.WRAP_CONTENT, 15));
		
		purchasableLayout.addView(nameTextView);
		purchasableLayout.addView(costTextView);
		purchasableLayout.addView(detailsButton);
		purchasableLayout.addView(buyButton);
		
		return purchasableLayout;
	}
}
