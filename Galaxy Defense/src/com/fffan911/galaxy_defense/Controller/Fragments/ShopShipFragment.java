package com.fffan911.galaxy_defense.Controller.Fragments;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Miscellany.Vendor;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.View.Buttons.BuyButton;
import com.fffan911.galaxy_defense.View.Buttons.DetailsButton;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShopShipFragment extends ShopFragment {
	//Constants
	private static final String TAG = "ShopShipFragment";
	
	//Shop Construction
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//Getting the ship fragment layout
		super.onCreateView(inflater, container, savedInstanceState);
		View shipLayout = inflater.inflate(R.layout.shop_ship_fragment_layout, container, false);
		
		//Adding the Currently Equipped Information
		TextView currentlyEquippedBodyTextView = (TextView)shipLayout.findViewById(R.id.shop_ship_body_currently_equipped_text_view);
		currentlyEquippedBodyTextView.setText(PlayerData.getInstance().getEquippedBody().getName());
		DetailsButton currentlyEquippedBodyDetailsButton = (DetailsButton)shipLayout.findViewById(R.id.shop_ship_body_currently_equipped_details_button);
		currentlyEquippedBodyDetailsButton.setDetailsText(Composite.getDetailsAndUpgrades(PlayerData.getInstance().getEquippedBody()));
		
		TextView currentlyEquippedArmorTextView = (TextView)shipLayout.findViewById(R.id.shop_ship_armor_currently_equipped_text_view);
		currentlyEquippedArmorTextView.setText(PlayerData.getInstance().getEquippedArmor().getName());
		DetailsButton currentlyEquippedArmorDetailsButton = (DetailsButton)shipLayout.findViewById(R.id.shop_ship_armor_currently_equipped_details_button);
		currentlyEquippedArmorDetailsButton.setDetailsText(Composite.getDetailsAndUpgrades(PlayerData.getInstance().getEquippedArmor()));
		
		TextView currentlyEquippedShieldTextView = (TextView)shipLayout.findViewById(R.id.shop_ship_shield_currently_equipped_text_view);
		currentlyEquippedShieldTextView.setText(PlayerData.getInstance().getEquippedShield().getName());
		DetailsButton currentlyEquippedShieldDetailsButton = (DetailsButton)shipLayout.findViewById(R.id.shop_ship_shield_currently_equipped_details_button);
		currentlyEquippedShieldDetailsButton.setDetailsText(Composite.getDetailsAndUpgrades(PlayerData.getInstance().getEquippedShield()));
		
		TextView currentlyEquippedCoreTextView = (TextView)shipLayout.findViewById(R.id.shop_ship_core_currently_equipped_text_view);
		currentlyEquippedCoreTextView.setText(PlayerData.getInstance().getEquippedCore().getName());
		DetailsButton currentlyEquippedCoreDetailsButton = (DetailsButton)shipLayout.findViewById(R.id.shop_ship_core_currently_equipped_details_button);
		currentlyEquippedCoreDetailsButton.setDetailsText(Composite.getDetailsAndUpgrades(PlayerData.getInstance().getEquippedCore()));
		
		TextView currentlyEquippedSingleWeaponBarrelTextView = (TextView)shipLayout.findViewById
		(R.id.shop_ship_single_weapon_barrel_currently_equipped_text_view);
		currentlyEquippedSingleWeaponBarrelTextView.setText(PlayerData.getInstance().getEquippedSingleWeaponBarrel().getName());
		DetailsButton currentlyEquippedSingleWeaponBarrelDetailsButton = (DetailsButton)shipLayout.findViewById
		(R.id.shop_ship_single_weapon_barrel_currently_equipped_details_button);
		currentlyEquippedSingleWeaponBarrelDetailsButton.setDetailsText(Composite.getDetailsAndUpgrades
		(PlayerData.getInstance().getEquippedSingleWeaponBarrel()));
		
		TextView currentlyEquippedDoubleWeaponBarrelTextView = (TextView)shipLayout.findViewById
		(R.id.shop_ship_double_weapon_barrel_currently_equipped_text_view);
		currentlyEquippedDoubleWeaponBarrelTextView.setText(PlayerData.getInstance().getEquippedDoubleWeaponBarrel().getName());
		DetailsButton currentlyEquippedDoubleWeaponBarrelDetailsButton = (DetailsButton)shipLayout.findViewById
		(R.id.shop_ship_double_weapon_barrel_currently_equipped_details_button);
		currentlyEquippedDoubleWeaponBarrelDetailsButton.setDetailsText(Composite.getDetailsAndUpgrades
		(PlayerData.getInstance().getEquippedDoubleWeaponBarrel()));
		
		TextView currentlyEquippedLauncherWeaponBarrelTextView = (TextView)shipLayout.findViewById
		(R.id.shop_ship_launcher_weapon_barrel_currently_equipped_text_view);
		currentlyEquippedLauncherWeaponBarrelTextView.setText(PlayerData.getInstance().getEquippedLauncherWeaponBarrel().getName());
		DetailsButton currentlyEquippedLauncherWeaponBarrelDetailsButton = (DetailsButton)shipLayout.findViewById
		(R.id.shop_ship_launcher_weapon_barrel_currently_equipped_details_button);
		currentlyEquippedLauncherWeaponBarrelDetailsButton.setDetailsText(Composite.getDetailsAndUpgrades
		(PlayerData.getInstance().getEquippedLauncherWeaponBarrel()));
		
		//Adding the replacements
		LinearLayout bodyReplacementsLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_body_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableBodyPurchasables()) {
			bodyReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout armorReplacementsLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_armor_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableArmorPurchasables()) {
			armorReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout shieldReplacementsLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_shield_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableShieldPurchasables()) {
			shieldReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout coreReplacementsLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_core_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableCorePurchasables()) {
			coreReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout singleWeaponBarrelReplacementsLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_single_weapon_barrel_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableSingleWeaponBarrelPurchasables()) {
			singleWeaponBarrelReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout doubleWeaponBarrelReplacementsLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_double_weapon_barrel_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableDoubleWeaponBarrelPurchasables()) {
			doubleWeaponBarrelReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout launcherWeaponBarrelReplacementsLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_launcher_weapon_barrel_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableLauncherWeaponBarrelPurchasables()) {
			launcherWeaponBarrelReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		//Adding the Upgrades
		LinearLayout bodyUpgradesLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_body_upgrades_layout);
		for (Purchasable purchasable : PlayerData.getInstance().getEquippedBody().getPurchasableUpgrades()) {
			if (!purchasable.alreadyPurchased()) bodyUpgradesLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout armorUpgradesLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_armor_upgrades_layout);
		for (Purchasable purchasable : PlayerData.getInstance().getEquippedArmor().getPurchasableUpgrades()) {
			if (!purchasable.alreadyPurchased()) armorUpgradesLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout shieldUpgradesLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_shield_upgrades_layout);
		for (Purchasable purchasable : PlayerData.getInstance().getEquippedShield().getPurchasableUpgrades()) {
			if (!purchasable.alreadyPurchased()) shieldUpgradesLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout coreUpgradesLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_core_upgrades_layout);
		for (Purchasable purchasable : PlayerData.getInstance().getEquippedCore().getPurchasableUpgrades()) {
			if (!purchasable.alreadyPurchased()) coreUpgradesLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout singleWeaponBarrelUpgradesLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_single_weapon_barrel_upgrades_layout);
		for (Purchasable purchasable : PlayerData.getInstance().getEquippedSingleWeaponBarrel().getPurchasableUpgrades()) {
			if (!purchasable.alreadyPurchased()) singleWeaponBarrelUpgradesLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout doubleWeaponBarrelUpgradesLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_double_weapon_barrel_upgrades_layout);
		for (Purchasable purchasable : PlayerData.getInstance().getEquippedDoubleWeaponBarrel().getPurchasableUpgrades()) {
			if (!purchasable.alreadyPurchased()) doubleWeaponBarrelUpgradesLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		LinearLayout launcherWeaponBarrelUpgradesLayout = (LinearLayout)shipLayout.findViewById(R.id.shop_ship_launcher_weapon_barrel_upgrades_layout);
		for (Purchasable purchasable : PlayerData.getInstance().getEquippedLauncherWeaponBarrel().getPurchasableUpgrades()) {
			if (!purchasable.alreadyPurchased()) launcherWeaponBarrelUpgradesLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		//Returning the view
		return shipLayout;
	}
}
