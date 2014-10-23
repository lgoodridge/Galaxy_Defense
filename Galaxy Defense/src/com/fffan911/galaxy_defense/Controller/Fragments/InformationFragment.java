package com.fffan911.galaxy_defense.Controller.Fragments;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintProxyUser;
import com.fffan911.galaxy_defense.Controller.Proxies.BlueprintUIProxy;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Composites.Composite;
import com.fffan911.galaxy_defense.Model.Composites.Accessories.Accessory;
import com.fffan911.galaxy_defense.Model.Composites.Parts.BarrelType;
import com.fffan911.galaxy_defense.Model.Composites.Parts.WeaponBarrel;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.View.Buttons.InformationButton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class InformationFragment extends Fragment {
	//Constants
	private static final String TAG = "InformationFragment";
	
	//Information Fragment Construction
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	Bundle savedInstanceState) {
		//Setting up for layout construction
		Log.d(TAG, "Creating " + getClass().getSimpleName() + " View...");
		super.onCreateView(inflater, container, savedInstanceState);
		LinearLayout informationLayout = (LinearLayout)inflater.inflate(R.layout.information_fragment_layout, container, false);
		LinearLayout informationButtonLayout = (LinearLayout)informationLayout.findViewById(R.id.information_button_layout);
		
		//Adding the Ship Information Button
		InformationButton shipInfoButton = new InformationButton(getActivity(), "SHIP");
		shipInfoButton.setId(9988);
		shipInfoButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
		shipInfoButton.setPadding(30, 10, 30, 10);
		informationButtonLayout.addView(shipInfoButton);
		
		//Adding the Parts Information Button
		InformationButton partsInfoButton = new InformationButton(getActivity(), "PARTS");
		partsInfoButton.setId(9989);
		partsInfoButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
		informationButtonLayout.addView(partsInfoButton);
		
		//Adding the Special Information Button
		InformationButton specialInfoButton = new InformationButton(getActivity(), "SPECIAL");
		specialInfoButton.setId(9990);
		specialInfoButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
		informationButtonLayout.addView(specialInfoButton);
		
		//Adding the Weapon Information Buttons
		InformationButton weaponInfoButton;
		for (int i = 1; i < 7; i++) {
			if (PlayerData.getInstance().hasWeaponInSlot(i)) {
				weaponInfoButton = new InformationButton(getActivity(), PlayerData.getInstance().getWeaponFromSlot(i));
				weaponInfoButton.setId(9990 + i);
				weaponInfoButton.setText("            ");
				weaponInfoButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
				informationButtonLayout.addView(weaponInfoButton);
			}
		}
		
		//Returning the view
		return informationLayout;
	}
	public void storeInformationInButtons() {
		//Getting the necessary resources
		BlueprintProxyUser blueprintProxyUser = (BlueprintProxyUser)(getActivity());
		BlueprintUIProxy blueprintUIProxy = blueprintProxyUser.getUIProxy();
		PlayerShip playerShip = blueprintUIProxy.getDisplayPanel().getPlayerShip();
		
		//Storing the Ship Info Button
		String shipInformation = compileShipInformation(playerShip);
		InformationButton shipInfoButton = (InformationButton)(blueprintUIProxy.getInformationLayout().findViewById(9988));
		shipInfoButton.setInformationText(shipInformation);
		
		//Storing the Parts Info Button
		String partsInformation = compilePartsInformation(playerShip);
		InformationButton partsInfoButton = (InformationButton)(blueprintUIProxy.getInformationLayout().findViewById(9989));
		partsInfoButton.setInformationText(partsInformation);
		
		//Storing the Special Info Button
		InformationButton specialInfoButton = (InformationButton)(blueprintUIProxy.getInformationLayout().findViewById(9990));
		if (PlayerData.getInstance().getSpecialWeapon() == null) {
			specialInfoButton.setInformationText("No Special Weapon Equipped.");
		} else {
			String specialInformation = PlayerData.getInstance().getSpecialWeapon().getDetails() + "\n\n--------------------\n\n" +
			"Special Ammo Remaining: " + PlayerData.getInstance().getSpecialsRemaining();
			specialInfoButton.setInformationText(specialInformation);
		}
		
		//Storing the Weapon Info Button
		InformationButton weaponInfoButton;
		for (int i = 1; i < 7; i++) {
			if (PlayerData.getInstance().hasWeaponInSlot(i)) {
				String weaponInformation = PlayerData.getInstance().getWeaponFromSlot(i).getDetails();
				weaponInfoButton = (InformationButton)(blueprintUIProxy.getInformationLayout().findViewById(9990 + i));
				weaponInfoButton.setInformationText(weaponInformation);
			}
		}
	}
	
	//Fragment Methods
	@Override
	public void onCreate(Bundle savedInstanceState){
		Log.d(TAG, "Creating " + getClass().getSimpleName() + "...");
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		Log.d(TAG, "Parent Activity successfully created...");
		super.onActivityCreated(savedInstanceState);
		//Store the information in the buttons, once activity has been fully created
		storeInformationInButtons();
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
	
	//Information Compiling Methods
	private String compileShipInformation(PlayerShip playerShip) {
		return "*****   SUMMARY   *****" +
		"\n\nMax Health: " + playerShip.getMaxHealth() +
		"\nMax Armor: " + playerShip.getMaxArmor() + 
		"\nMax Shields: " + playerShip.getMaxShields() +
		"\nShield Recharge Delay: " + playerShip.getShieldDelay() +
		"\nShield Recharge Rate:" + playerShip.getShieldRechargeRate() +
		"\nSpeed: " + playerShip.getMaxSpeed() +
		"\n\n*****   DETAILS   *****" +
		"\n\nMax Health Base: " + (playerShip.getBaseMaxHealth() + playerShip.getEquipmentMaxHealthAddition()) +
		"\nMax Health Multiplier: " + (playerShip.getBaseMaxHealthMultiplier() * playerShip.getEquipmentMaxHealthMultiplier()) +
		"\nMax Armor Base: " + (playerShip.getBaseMaxArmor() + playerShip.getEquipmentMaxArmorAddition()) + 
		"\nMax Armor Multiplier: " + (playerShip.getBaseMaxArmorMultiplier() * playerShip.getEquipmentMaxArmorMultiplier()) +
		"\nMax Shields Base: " + (playerShip.getBaseMaxShields() + playerShip.getEquipmentMaxShieldsAddition()) +
		"\nMax Shields Multiplier: " + (playerShip.getBaseMaxShieldsMultiplier() * playerShip.getEquipmentMaxShieldsMultiplier()) +
		"\nShield Recharge Delay Base: " + (playerShip.getBaseShieldDelay() + playerShip.getEquipmentShieldDelayAddition()) +
		"\nShield Recharge Delay Multiplier: " + (playerShip.getBaseShieldDelayMultiplier() * playerShip.getEquipmentShieldDelayMultiplier()) +
		"\nShield Recharge Rate Base: " + (playerShip.getBaseShieldRechargeRate() + playerShip.getEquipmentShieldRechargeRateAddition()) +
		"\nShield Recharge Rate Multiplier: " + (playerShip.getBaseShieldRechargeRateMultiplier() * playerShip.getEquipmentShieldRechargeRateMultiplier()) +
		"\nSpeed Base: " + (playerShip.getBaseMaxSpeed() + playerShip.getEquipmentSpeedAddition()) +
		"\nSpeed Multiplier: " + (playerShip.getBaseMaxSpeedMultiplier() * playerShip.getEquipmentSpeedMultiplier()) +
		"\n\nWeapon Damage Addition: " + (playerShip.getBaseWeaponDamageAddition() + playerShip.getEquipmentWeaponDamageAddition()) +
		"\nWeapon Damage Multiplier: " + (playerShip.getBaseWeaponDamageMultiplier() * playerShip.getEquipmentWeaponDamageMultiplier()) +
		"\nWeapon Reload Time Reduction: " + (playerShip.getBaseWeaponReloadTimeReduction() + playerShip.getEquipmentWeaponReloadTimeReduction()) +
		"\nWeapon Reload Time Multiplier: " + (playerShip.getBaseWeaponReloadTimeMultiplier() * playerShip.getEquipmentWeaponReloadTimeMultiplier()) +
		"\nWeapon Speed Addition: " + (playerShip.getWeaponSpeedAddition() + playerShip.getEquipmentWeaponSpeedAddition()) +
		"\nWeapon Speed Multiplier: " + (playerShip.getWeaponSpeedMultiplier() * playerShip.getEquipmentWeaponSpeedMultiplier()) +
		"\nWeapon Acceleration Addition: " + (playerShip.getWeaponAccelerationAddition() + playerShip.getEquipmentWeaponAccelerationAddition()) +
		"\nWeapon Acceleration Multiplier: " + (playerShip.getWeaponAccelerationMultiplier() * playerShip.getEquipmentWeaponAccelerationMultiplier()) + 
		"\n\n";
	}
	private String compilePartsInformation(PlayerShip playerShip) {
		String partsInformation = "";
		partsInformation = partsInformation.concat("SHIP COMPONENTS:\n\n--------------------\n\n");
		for (Composite composite : playerShip.getAllComposites()) {
			partsInformation = partsInformation.concat(Composite.getDetailsAndUpgrades(composite) + "\n\n--------------------\n\n");
		}
		partsInformation = partsInformation.concat("WEAPON BARRELS:\n\n--------------------\n\n");
		for (WeaponBarrel weaponBarrel : playerShip.getAllWeaponBarrels()) {
			if (weaponBarrel.getBarrelType() == BarrelType.VOID) continue;
			partsInformation = partsInformation.concat(weaponBarrel.getBarrelType().name() + " WEAPON BARREL\n\n" + 
			Composite.getDetailsAndUpgrades(weaponBarrel) + "\n\n--------------------\n\n");
		}
		partsInformation = partsInformation.concat("OTHER UPGRADES:\n\n--------------------\n\n");
		for (Accessory accessory : playerShip.getOwnedAccessories()) {
			partsInformation = partsInformation.concat(Composite.getDetailsAndUpgrades(accessory) + "\n\n--------------------\n\n");
		}
		return partsInformation;
	}
}
