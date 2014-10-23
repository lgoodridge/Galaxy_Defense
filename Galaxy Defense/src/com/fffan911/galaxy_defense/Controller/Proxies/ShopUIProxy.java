package com.fffan911.galaxy_defense.Controller.Proxies;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Model.Purchasables.Purchasable;
import com.fffan911.galaxy_defense.View.Buttons.ConfirmBuyButton;
import com.fffan911.galaxy_defense.View.Buttons.ConfirmBuyWeaponButton;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ShopUIProxy extends GenericUIProxy {
	//References
	private PopupWindow detailsPopupWindow;
	private PopupWindow buyPopupWindow;
	private PopupWindow buyWeaponPopupWindow;
	private PopupWindow notEnoughMoneyPopupWindow;
	private PopupWindow alreadyPurchasedPopupWindow;
	private View detailsPopupView;
	private View buyPopupView;
	private View buyWeaponPopupView;
	private View notEnoughMoneyPopupView;
	private View alreadyPurchasedPopupView;
	//Constants
	private static final String TAG = "ShopUIProxy";
	
	//Constructor
	public ShopUIProxy(Activity activity) {
		super(activity);
		LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService
		(Activity.LAYOUT_INFLATER_SERVICE);
		detailsPopupWindow = new PopupWindow(activity);
		detailsPopupView = inflater.inflate(R.layout.shop_details_popup_layout, null);
		detailsPopupWindow.setContentView(detailsPopupView);
		buyPopupWindow = new PopupWindow(activity);
		buyPopupView = inflater.inflate(R.layout.buy_popup_layout, null);
		buyPopupWindow.setContentView(buyPopupView);
		notEnoughMoneyPopupWindow = new PopupWindow(activity);
		buyWeaponPopupWindow = new PopupWindow(activity);
		buyWeaponPopupView = inflater.inflate(R.layout.buy_weapon_popup_layout, null);
		buyWeaponPopupWindow.setContentView(buyWeaponPopupView);
		notEnoughMoneyPopupView = inflater.inflate(R.layout.not_enough_money_popup_layout, null);
		notEnoughMoneyPopupWindow.setContentView(notEnoughMoneyPopupView);
		alreadyPurchasedPopupWindow = new PopupWindow(activity);
		alreadyPurchasedPopupView = inflater.inflate(R.layout.already_purchased_popup_layout, null);
		alreadyPurchasedPopupWindow.setContentView(alreadyPurchasedPopupView);
	}
	
	//Popup Methods
	public void displayDetailsPopup(String text) {
		closeAllPopups();
		TextView detailsTextView = (TextView)detailsPopupView.findViewById(R.id.shop_details_popup_text_view);
		detailsTextView.setText(text);
		detailsPopupWindow.showAtLocation(detailsPopupView, Gravity.CENTER, 0, 0);
		detailsPopupWindow.update(getScreenWidth()*3/4, getScreenHeight());
	}
	public void displayBuyPopup(Purchasable purchasable, String text) {
		closeAllPopups();
		TextView buyTextView = (TextView)buyPopupView.findViewById(R.id.buy_popup_text_view);
		buyTextView.setText(text);
		ConfirmBuyButton confirmBuyButton = (ConfirmBuyButton)buyPopupView.findViewById(R.id.confirm_buy_button);
		confirmBuyButton.setStoredPurchasable(purchasable);
		buyPopupWindow.showAtLocation(buyPopupView, Gravity.CENTER, 0, 0);
		buyPopupWindow.update(getScreenWidth()*3/4, getScreenHeight());
	}
	public void displayBuyWeaponPopup(Purchasable purchasable, String text) {
		closeAllPopups();
		TextView buyWeaponTextView = (TextView)buyWeaponPopupView.findViewById(R.id.buy_weapon_popup_text_view);
		buyWeaponTextView.setText(text);
		ConfirmBuyWeaponButton confirmBuyWeaponButton = (ConfirmBuyWeaponButton)buyWeaponPopupView.findViewById(R.id.confirm_buy_weapon_button);
		confirmBuyWeaponButton.setStoredPurchasable(purchasable);
		buyWeaponPopupWindow.showAtLocation(buyWeaponPopupView, Gravity.CENTER, 0, 0);
		buyWeaponPopupWindow.update(getScreenWidth()*3/4, getScreenHeight());
	}
	public void displayNotEnoughMoneyPopup() {
		closeAllPopups();
		notEnoughMoneyPopupWindow.showAtLocation(notEnoughMoneyPopupView, Gravity.CENTER, 0, 0);
		notEnoughMoneyPopupWindow.update(getScreenWidth()/3, getScreenHeight()/3);
	}
	public void displayAlreadyPurchasedPopup() {
		closeAllPopups();
		alreadyPurchasedPopupWindow.showAtLocation(alreadyPurchasedPopupView, Gravity.CENTER, 0, 0);
		alreadyPurchasedPopupWindow.update(getScreenWidth()/3, getScreenHeight()/3);
	}
	public void closeDetailsPopup() {
		detailsPopupWindow.dismiss();
	}
	public void closeBuyPopup() {
		buyPopupWindow.dismiss();
	}
	public void closeBuyWeaponPopup() {
		buyWeaponPopupWindow.dismiss();
	}
	public void closeNotEnoughMoneyPopup() {
		notEnoughMoneyPopupWindow.dismiss();
	}
	public void closeAlreadyPurchasedPopup() {
		alreadyPurchasedPopupWindow.dismiss();
	}
	
	@Override
	public void closeAllPopups() {
		super.closeAllPopups();
		closeDetailsPopup();
		closeBuyPopup();
		closeBuyWeaponPopup();
		closeNotEnoughMoneyPopup();
		closeAlreadyPurchasedPopup();
	}
}
