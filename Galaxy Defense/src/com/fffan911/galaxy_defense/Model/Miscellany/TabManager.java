package com.fffan911.galaxy_defense.Model.Miscellany;

import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class TabManager implements OnTabChangeListener {
	private final FragmentActivity activity;
	private final TabHost tabHost;
	private final int containerID;
	private final HashMap<String, TabInfo> tabs;
	private TabInfo lastTab;
	private static final String TAG = TabManager.class.getSimpleName();
	
	public TabManager(FragmentActivity activity, TabHost tabHost, int containerID) {
		this.activity = activity;
		this.tabHost = tabHost;
		this.containerID = containerID;
		this.tabs = new HashMap<String, TabInfo>();
		tabHost.setOnTabChangedListener(this);
	}
	
	public void addTab(TabSpec tabSpec, Class<?> clss, Bundle args) {
		tabSpec.setContent(new TabFactory(activity));
		String tag = tabSpec.getTag();
		
		TabInfo info = new TabInfo(tag, clss, args);
		
		info.setFragment(activity.getSupportFragmentManager().findFragmentByTag(tag));
		if (info.getFragment() != null && !info.getFragment().isDetached()){
			FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
			ft.detach(info.getFragment());
			ft.commit();
		}
		
		tabs.put(tag, info);
		tabHost.addTab(tabSpec);
	}
	
	public void onTabChanged(String tabID){
		TabInfo newTab = tabs.get(tabID);
		if (newTab != lastTab) {
			FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
			if (lastTab != null) {
				if (lastTab.getFragment() != null) {
					ft.detach(lastTab.getFragment());
				}
			}
			if (newTab != null) {
				if (newTab.getFragment() == null) {
					newTab.setFragment(Fragment.instantiate(activity, 
					newTab.clss.getName(), newTab.args));
					ft.add(containerID, newTab.getFragment(), newTab.tag);
				} else {
					ft.attach(newTab.getFragment());
				}
			}
			
			lastTab = newTab;
			ft.commit();
			activity.getSupportFragmentManager().executePendingTransactions();
		}
	}
	
	static final class TabInfo {
		private final String tag;
		private final Class<?> clss;
		private final Bundle args;
		private Fragment fragment;
		
		TabInfo(String str, Class cl, Bundle bundle) {
			tag = str;
			clss = cl;
			args = bundle;
		}
		
		private Fragment getFragment(){
			return fragment;
		}
		private void setFragment(Fragment frag){
			fragment = frag;
		}
	}
	
	static class TabFactory implements TabContentFactory {
		private final Context context;
		
		public TabFactory (Context cont){
			context = cont;
		}
		
		public View createTabContent(String tag){
			View view = new View(context);
			view.setMinimumWidth(0);
			view.setMinimumHeight(0);
			return view;
		}
	}
}
