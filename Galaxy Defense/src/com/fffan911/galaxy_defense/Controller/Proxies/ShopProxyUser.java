package com.fffan911.galaxy_defense.Controller.Proxies;

public interface ShopProxyUser extends GenericProxyUser{
	ShopProxy getProxy();
	ShopUIProxy getUIProxy();
	void refreshCurrentTab();
	void refreshShipTab();
	void refreshWeaponsTab();
	void refreshMiscellanyTab();
}
