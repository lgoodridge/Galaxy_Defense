package com.fffan911.galaxy_defense.Controller.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Miscellany.Vendor;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.Model.Weapons.Weapon;
import com.fffan911.galaxy_defense.View.Buttons.DetailsButton;

public class ShopWeaponsFragment extends ShopFragment {
	//Constants
	private static final String TAG = "ShopWeaponsFragment";
	
	//Shop Construction
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	Bundle savedInstanceState){
		//Getting the weapon fragment layout
		super.onCreateView(inflater, container, savedInstanceState);
		View weaponLayout = inflater.inflate(R.layout.shop_weapons_fragment_layout, container, false);
		
		//Adding the Standard Weapon Replacements
		LinearLayout standardWeaponReplacementsLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_standard_weapon_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableStandardWeaponPurchasables()) {
			standardWeaponReplacementsLayout.addView(createPurchasableLayout(purchasable, true));
		}
		
		//Adding the Special Weapon Replacments
		LinearLayout specialWeaponReplacementsLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_special_weapon_replacements_layout);
		for (Purchasable purchasable : Vendor.getInstance().getAvailableSpecialWeaponPurchasables()) {
			specialWeaponReplacementsLayout.addView(createPurchasableLayout(purchasable, false));
		}
		
		//Adding the Currently Equipped Information
		if (PlayerData.getInstance().getSpecialWeapon() != null) {
			TextView currentlyEquippedSpecialTextView = (TextView)weaponLayout.findViewById(R.id.shop_weapon_special_currently_equipped_text_view);
			currentlyEquippedSpecialTextView.setText(PlayerData.getInstance().getSpecialWeapon().getName() + " " + 
			PlayerData.getInstance().getSpecialWeapon().getLevelString());
			DetailsButton currentlyEquippedSpecialDetailsButton = (DetailsButton)weaponLayout.findViewById
			(R.id.shop_weapon_special_currently_equipped_details_button);
			currentlyEquippedSpecialDetailsButton.setDetailsText(Weapon.getDetailsAndUpgrade(PlayerData.getInstance().getSpecialWeapon()));
		}
		if (PlayerData.getInstance().getWeaponFromSlot(1) != null) {
			TextView currentlyEquippedSlotOneTextView = (TextView)weaponLayout.findViewById(R.id.shop_weapon_slot_one_currently_equipped_text_view);
			currentlyEquippedSlotOneTextView.setText(PlayerData.getInstance().getWeaponFromSlot(1).getName() + " " + 
			PlayerData.getInstance().getWeaponFromSlot(1).getLevelString());
			DetailsButton currentlyEquippedSlotOneDetailsButton = (DetailsButton)weaponLayout.findViewById
			(R.id.shop_weapon_slot_one_currently_equipped_details_button);
			currentlyEquippedSlotOneDetailsButton.setDetailsText(Weapon.getDetailsAndUpgrade(PlayerData.getInstance().getWeaponFromSlot(1)));
		}
		
		if (PlayerData.getInstance().getWeaponFromSlot(2) != null) {
			TextView currentlyEquippedSlotTwoTextView = (TextView)weaponLayout.findViewById(R.id.shop_weapon_slot_two_currently_equipped_text_view);
			currentlyEquippedSlotTwoTextView.setText(PlayerData.getInstance().getWeaponFromSlot(2).getName() + " " + 
			PlayerData.getInstance().getWeaponFromSlot(2).getLevelString());
			DetailsButton currentlyEquippedSlotTwoDetailsButton = (DetailsButton)weaponLayout.findViewById
			(R.id.shop_weapon_slot_two_currently_equipped_details_button);
			currentlyEquippedSlotTwoDetailsButton.setDetailsText(Weapon.getDetailsAndUpgrade(PlayerData.getInstance().getWeaponFromSlot(2)));
		}
		
		if (PlayerData.getInstance().getWeaponFromSlot(3) != null) {
			TextView currentlyEquippedSlotThreeTextView = (TextView)weaponLayout.findViewById(R.id.shop_weapon_slot_three_currently_equipped_text_view);
			currentlyEquippedSlotThreeTextView.setText(PlayerData.getInstance().getWeaponFromSlot(3).getName() + " " + 
			PlayerData.getInstance().getWeaponFromSlot(3).getLevelString());
			DetailsButton currentlyEquippedSlotThreeDetailsButton = (DetailsButton)weaponLayout.findViewById
			(R.id.shop_weapon_slot_three_currently_equipped_details_button);
			currentlyEquippedSlotThreeDetailsButton.setDetailsText(Weapon.getDetailsAndUpgrade(PlayerData.getInstance().getWeaponFromSlot(3)));
		}
		
		if (PlayerData.getInstance().getWeaponFromSlot(4) != null) {
			TextView currentlyEquippedSlotFourTextView = (TextView)weaponLayout.findViewById(R.id.shop_weapon_slot_four_currently_equipped_text_view);
			currentlyEquippedSlotFourTextView.setText(PlayerData.getInstance().getWeaponFromSlot(4).getName() + " " + 
			PlayerData.getInstance().getWeaponFromSlot(4).getLevelString());
			DetailsButton currentlyEquippedSlotFourDetailsButton = (DetailsButton)weaponLayout.findViewById
			(R.id.shop_weapon_slot_four_currently_equipped_details_button);
			currentlyEquippedSlotFourDetailsButton.setDetailsText(Weapon.getDetailsAndUpgrade(PlayerData.getInstance().getWeaponFromSlot(4)));
		}
		
		if (PlayerData.getInstance().getWeaponFromSlot(5) != null) {
			TextView currentlyEquippedSlotFiveTextView = (TextView)weaponLayout.findViewById(R.id.shop_weapon_slot_five_currently_equipped_text_view);
			currentlyEquippedSlotFiveTextView.setText(PlayerData.getInstance().getWeaponFromSlot(5).getName() + " " + 
			PlayerData.getInstance().getWeaponFromSlot(5).getLevelString());
			DetailsButton currentlyEquippedSlotFiveDetailsButton = (DetailsButton)weaponLayout.findViewById
			(R.id.shop_weapon_slot_five_currently_equipped_details_button);
			currentlyEquippedSlotFiveDetailsButton.setDetailsText(Weapon.getDetailsAndUpgrade(PlayerData.getInstance().getWeaponFromSlot(5)));
		}
		
		if (PlayerData.getInstance().getWeaponFromSlot(6) != null) {
			TextView currentlyEquippedSlotSixTextView = (TextView)weaponLayout.findViewById(R.id.shop_weapon_slot_six_currently_equipped_text_view);
			currentlyEquippedSlotSixTextView.setText(PlayerData.getInstance().getWeaponFromSlot(6).getName() + " " + 
			PlayerData.getInstance().getWeaponFromSlot(6).getLevelString());
			DetailsButton currentlyEquippedSlotSixDetailsButton = (DetailsButton)weaponLayout.findViewById
			(R.id.shop_weapon_slot_six_currently_equipped_details_button);
			currentlyEquippedSlotSixDetailsButton.setDetailsText(Weapon.getDetailsAndUpgrade(PlayerData.getInstance().getWeaponFromSlot(6)));
		}
		
		//Adding the Upgrades or Evolutions
		LinearLayout slotOneUpgradesLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_weapon_slot_one_upgrades_layout);
		addUpgradeView(slotOneUpgradesLayout, 1);
		
		LinearLayout slotTwoUpgradesLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_weapon_slot_two_upgrades_layout);
		addUpgradeView(slotTwoUpgradesLayout, 2);
		
		LinearLayout slotThreeUpgradesLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_weapon_slot_three_upgrades_layout);
		addUpgradeView(slotThreeUpgradesLayout, 3);
		
		LinearLayout slotFourUpgradesLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_weapon_slot_four_upgrades_layout);
		addUpgradeView(slotFourUpgradesLayout, 4);
		
		LinearLayout slotFiveUpgradesLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_weapon_slot_five_upgrades_layout);
		addUpgradeView(slotFiveUpgradesLayout, 5);
		
		LinearLayout slotSixUpgradesLayout = (LinearLayout)weaponLayout.findViewById(R.id.shop_weapon_slot_six_upgrades_layout);
		addUpgradeView(slotSixUpgradesLayout, 6);
		
		//Returning the View
		return weaponLayout;
	}
	
	private void addUpgradeView(LinearLayout slotUpgradeLayout, int slot) {
		if (PlayerData.getInstance().getWeaponFromSlot(slot) == null) return;
		if (PlayerData.getInstance().getWeaponFromSlot(slot).getLevel() == 5 || PlayerData.getInstance().getWeaponFromSlot(slot).getLevel() == 10) {
			for (Purchasable purchasable : PlayerData.getInstance().getWeaponFromSlot(slot).getPurchasableEvolutions()) {
				if (!purchasable.alreadyPurchased()) {
					purchasable.setWeaponSlot(slot);
					slotUpgradeLayout.addView(createPurchasableLayout(purchasable, false));
				}
			}
		} else {
			for (Purchasable purchasable : PlayerData.getInstance().getWeaponFromSlot(slot).getPurchasableUpgrades()) {
				if (!purchasable.alreadyPurchased()) {
					purchasable.setWeaponSlot(slot);
					slotUpgradeLayout.addView(createPurchasableLayout(purchasable, false));
				}
			}
		}
	}
}
