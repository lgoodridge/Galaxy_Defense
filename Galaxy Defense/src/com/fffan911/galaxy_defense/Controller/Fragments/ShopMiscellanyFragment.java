package com.fffan911.galaxy_defense.Controller.Fragments;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Miscellany.Vendor;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShopMiscellanyFragment extends ShopFragment {
	//Constants
	private static final String TAG = "ShopMiscellanyFragment";
	
	//Shop Construction
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		//Getting the miscellany fragment layout
		super.onCreateView(inflater, container, savedInstanceState);
		View miscellanyLayout = inflater.inflate(R.layout.shop_miscellany_fragment_layout, container, false);
		
		//Adding the purchasables
		LinearLayout accessoryLayout = (LinearLayout)miscellanyLayout.findViewById(R.id.shop_miscellany_accessory_items_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableAccessoryPurchasables()) {
			accessoryLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout limitedEditionLayout = (LinearLayout)miscellanyLayout.findViewById(R.id.shop_miscellany_limited_edition_items_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableLimitedEditionPurchasables()) {
			limitedEditionLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		//Check for any empty layouts - add a message if so
		if (Vendor.getInstance().getAvailableAccessoryPurchasables().isEmpty()) {
			TextView noItemsTextView = new TextView(getActivity());
			noItemsTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
			LinearLayout.LayoutParams.WRAP_CONTENT));
			noItemsTextView.setText("Sorry! No upgrades available at the moment!");
			noItemsTextView.setPadding(10, 20, 0, 20);
			accessoryLayout.addView(noItemsTextView);
		}
		if (Vendor.getInstance().getAvailableLimitedEditionPurchasables().isEmpty()) {
			TextView noItemsTextView = new TextView(getActivity());
			noItemsTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
			LinearLayout.LayoutParams.WRAP_CONTENT));
			noItemsTextView.setText("Sorry! No Items here at the moment!");
			noItemsTextView.setPadding(10, 20, 0, 20);
			limitedEditionLayout.addView(noItemsTextView);
		}
		
		//Returning the view
		return miscellanyLayout;
	}
}
