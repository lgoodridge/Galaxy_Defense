package com.fffan911.galaxy_defense.View.Customs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Controllers.CustomControllers.HealthBarController;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;

public class HealthBar extends View{
	//References
	private Controller controller;
	private ShapeDrawable healthDrawable;
	private ShapeDrawable armorDrawable;
	private ShapeDrawable shieldDrawable;
	//Attributes
	
	//Constants
	private static final String TAG = "HealthBar";
	
	//Construcutor
	public HealthBar(Context context, AttributeSet attrs){
		super(context, attrs);
		setController(new HealthBarController(this));
		healthDrawable = new ShapeDrawable(new RectShape());
		armorDrawable = new ShapeDrawable(new RectShape());
		shieldDrawable = new ShapeDrawable(new RectShape());
	}
	
	//Draw Methods
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		healthDrawable.getPaint().setColor(getHealthBarColor());
		healthDrawable.setBounds(0, getHealthBarStartHeight(), 
		getHealthBarWidth(), (getHeight() / 2) + (getHealthBarStartHeight())); 
		healthDrawable.draw(canvas);
		armorDrawable.getPaint().setColor(getArmorBarColor());
		armorDrawable.setBounds(0, getArmorBarStartHeight(), 
		getArmorBarWidth(), (getHeight() / 2) + (getArmorBarStartHeight()));
		armorDrawable.draw(canvas);
		shieldDrawable.getPaint().setColor(getShieldBarColor());
		shieldDrawable.setBounds(0, getShieldBarStartHeight(), 
		getShieldBarWidth(), (getHeight() / 2) + (getShieldBarStartHeight()));
		shieldDrawable.draw(canvas);
	}
	
	//Touch Methods
	@Override
	public boolean onTouchEvent(MotionEvent me){
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Set Methods
	private final void setController(Controller controller){
		this.controller = controller;
	}
	
	//Complex Get Methods
	private int getHealthBarColor() {
		int redAmount;
		int greenAmount;
		int percent = PlayerData.getInstance().getPlayerHealthPercentage();
		if (percent >= 50) greenAmount = 255;
		else greenAmount = percent * 255 / 50;
		if (percent <= 50) redAmount = 255;
		else redAmount = (100 - percent) * 255 / 50;
		return Color.rgb(redAmount, greenAmount, 0);
	}
	private int getArmorBarColor() {
		int blueAmount = PlayerData.getInstance().getPlayerArmorPercentage() * 255 / 100;
		return Color.rgb(255, 0, blueAmount);
	}
	private int getShieldBarColor() {
		int greenAmount = PlayerData.getInstance().getPlayerShieldsPercentage() * 255 / 100;
		return Color.rgb(0, greenAmount, 255);
	}
	private int getHealthBarWidth() {
		return PlayerData.getInstance().getPlayerHealthPercentage() * getWidth() / 100;
	}
	private int getArmorBarWidth() {
		return PlayerData.getInstance().getPlayerArmorPercentage() * getWidth() / 100;
	}
	private int getShieldBarWidth() {
		return PlayerData.getInstance().getPlayerShieldsPercentage() * getWidth() / 100;
	}
	private int getHealthBarStartHeight() {
		return getHeight() / 2;
	}
	private int getArmorBarStartHeight() {
		return getHeight() / 4;
	}
	private int getShieldBarStartHeight() {
		return 0;
	}
}
