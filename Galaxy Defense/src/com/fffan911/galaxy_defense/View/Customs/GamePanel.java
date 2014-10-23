package com.fffan911.galaxy_defense.View.Customs;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.fffan911.galaxy_defense.R;
import com.fffan911.galaxy_defense.Controller.Controllers.Controller;
import com.fffan911.galaxy_defense.Controller.Proxies.GameProxyUser;
import com.fffan911.galaxy_defense.Model.Actors.Actor;
import com.fffan911.galaxy_defense.Model.Actors.PlayerShip;
import com.fffan911.galaxy_defense.Model.Actors.PlayerTarget;
import com.fffan911.galaxy_defense.Model.Actors.Enemies.Enemy;
import com.fffan911.galaxy_defense.Model.Data.GameData;
import com.fffan911.galaxy_defense.Model.Data.PlayerData;
import com.fffan911.galaxy_defense.Model.Miscellany.GameThread;
import com.fffan911.galaxy_defense.Model.Physics.Position;
import com.fffan911.galaxy_defense.Model.Physics.Vector;
import com.fffan911.galaxy_defense.Model.Stages.StageManager;
import com.fffan911.galaxy_defense.Model.Weapons.Beam;
import com.fffan911.galaxy_defense.Model.Weapons.Laser;
import com.fffan911.galaxy_defense.Model.Weapons.PlasmaCannon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponFactory;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponEvolutions.FluxCannon;
import com.fffan911.galaxy_defense.Model.Weapons.WeaponUpgrades.SpeedReducerWeaponUpgrade;
import com.fffan911.galaxy_defense.Utility.ScrollingBackground;

public abstract class GamePanel extends SurfaceView implements Callback {
	//References
	private PlayerShip playerShip;
	private PlayerTarget playerTarget;
	private GameThread thread;
	private List<Actor> linkedActors;
	private Controller controller;
	private ScrollingBackground background;
	//Collision Rects
	private Rect actorOneRect;
	private Rect actorTwoRect;
	//Attributes
	private String averageFPS;
	//Constants
	private static final String TAG = "GamePanel";
	
	//Constructor
	public GamePanel(Context context, AttributeSet attrs){
		super(context, attrs);
		//Panel setup
		getHolder().addCallback(this);
		setFocusable(true);
		//Init Attributes
		averageFPS = "N/A";
		//Init References
		playerShip = null;
		playerTarget = null;
		thread = null;
		Bitmap backgroundBitmap = BitmapFactory.decodeResource(getResources(), 
		R.drawable.space_background);
		background = new ScrollingBackground(backgroundBitmap, -100, 0, 0, 25.0f);
		linkedActors = new ArrayList<Actor>();
		//Init Collision Rects
		actorOneRect = new Rect();
		actorTwoRect = new Rect();
		//Ensure Weapon Factory is initialized
		WeaponFactory.getInstance();
	}
	
	//SurfaceView Methods
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Canvas c = getHolder().lockCanvas();
		draw(c);
		getHolder().unlockCanvasAndPost(c);
		//Tell StageManager everything is ready
		Log.d(TAG, "Panel Loaded.");
		StageManager.getInstance().setActivityLoaded(true);
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "Surface is being destoyed.");
		deref();
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
	
	//Game Panel Methods
	public void update(long updateTimeDiff){
		background.update(updateTimeDiff);
		for (Actor actor : linkedActors){
			actor.update(updateTimeDiff);
		}
	}
	public void render(Canvas canvas){
		background.render(canvas);
		for (Actor actor : linkedActors){
			actor.render(canvas);
		}
		displayFPS(canvas);
	}
	public void deref(){
		while(linkedActors.size() > 0){
			linkedActors.get(0).deref();
		}
		GameData.getInstance().unpause();
	}
	
	//Display Methods
	private void displayFPS(Canvas canvas){
		if (canvas != null){
			Paint paint = new Paint();
			paint.setARGB(255, 255, 255, 255);
			canvas.drawText(averageFPS, getWidth()-40, 20, paint);
		}
	}
	public void displayPauseMessage(Canvas canvas){
		if (canvas != null){
			Paint paint = new Paint();
			paint.setARGB(255, 255, 255, 255);
			paint.setTextSize(20);
			canvas.drawText("PAUSED", getWidth()/2-20, getHeight()/2, paint);
		}
	}
	
	//Collision Methods
	public void checkForCollisions(){
		for (int i = 0; i < linkedActors.size(); i++){
			for (int j = i+1; j < linkedActors.size(); j++){
				if (hasCollided(linkedActors.get(i), linkedActors.get(j))){
					distributeCollisions(linkedActors.get(i), linkedActors.get(j));
				}
			}
		}
	}
	public void distributeCollisions(Actor actorOne, Actor actorTwo){
		actorOne.handleCollision(actorTwo);
		actorTwo.handleCollision(actorOne);
	}
	public boolean hasCollided(Actor actorOne, Actor actorTwo) {
		actorOneRect.set(actorOne.getLeftEdge(), actorOne.getTopEdge(), 
		actorOne.getRightEdge(), actorOne.getBottomEdge());
		actorTwoRect.set(actorTwo.getLeftEdge(), actorTwo.getTopEdge(), 
		actorTwo.getRightEdge(), actorTwo.getBottomEdge());
		if (Rect.intersects(actorOneRect, actorTwoRect)) return true;
		return false;
	}
	public void checkForBoundsCollisions(){
		for (int i = 0; i < linkedActors.size(); i++){
			checkActorForBoundsCollision(linkedActors.get(i));
		}
	}
	public void checkActorForBoundsCollision(Actor actor){
		if (actor.getLeftEdge() < 0 && actor.getPosition().
		getXDirection() == Vector.DIR_LEFT) {
			actor.handleBoundsCollision("Left");
		}
		if (actor.getRightEdge() > getWidth() && actor.getPosition().
		getXDirection() == Vector.DIR_RIGHT) {
			actor.handleBoundsCollision("Right");
		}
		if (actor.getTopEdge() < 0 && actor.getPosition().
		getYDirection() == Vector.DIR_UP) {
			actor.handleBoundsCollision("Top");
		}
		if (actor.getBottomEdge() > getHeight() && actor.getPosition().
		getYDirection() == Vector.DIR_DOWN) {
			actor.handleBoundsCollision("Bottom");
		}
	}
	
	//Create Methods
	public void createPlayerShip(){
		playerShip = new PlayerShip(this);
	}
	public void createPlayerTarget(){
		playerTarget = new PlayerTarget(this, new Position(0, 0));
	}
	
	//Touch Event Method
	public boolean onTouchEvent(MotionEvent me){
		super.onTouchEvent(me);
		return controller.onTouchEvent(me);
	}
	
	//Actor Link + Unlink Methods
	public void linkActor(Actor actor){
		linkedActors.add(actor);
	}
	public void unlinkActor(Actor actor){
		linkedActors.remove(actor);
	}
	public void unlinkPlayerShip(){
		playerShip = null;
	}
	
	//Boolean Methods
	public boolean playerShipExists(){
		return playerShip != null;
	}
	public boolean isActorLinked(Actor actor){
		return linkedActors.contains(actor);
	}
	
	//Set Methods
	public void setAverageFPS(String newFPS){
		averageFPS = newFPS;
	}
	public void setThread(GameThread thread){
		this.thread = thread;
	}
	public final void setController(Controller controller){
		this.controller = controller;
	}
	
	//Complex Get Methods
	public int getNumberOfEnemiesRemaining() {
		int numEnemies = 0;
		for (Actor actor: linkedActors) {
			if (actor instanceof Enemy) numEnemies++;
		}
		return numEnemies;
	}
	
	//Get Methods
	public PlayerShip getPlayerShip(){
		return playerShip;
	}
	public PlayerTarget getPlayerTarget(){
		return playerTarget;
	}
	public List<Actor> getLinkedActors(){
		return linkedActors;
	}
	public GameThread getThread(){
		return thread;
	}
	public String getAverageFPS(){
		return averageFPS;
	}
	public int getXCenter(){
		return getWidth() / 2;
	}
	public int getYCenter(){
		return getHeight() / 2;
	}
	
	//Abstract Methods
	public abstract Position getPlayerShipStartingPosition();
}
