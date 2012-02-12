package com.webdevexp.cyberpunk;

import it.marteEngine.Camera;
import it.marteEngine.World;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class InGameState extends World{
	public InGameState(int id, GameContainer container) {
		super(id, container);
		// TODO Auto-generated constructor stub
	}

	Player player;
	public Level currentLevel = null;
	TiledMap map;
	protected int mapWidth;
	protected int mapHeight;
	public Camera gameCamera;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		super.init(container, game);
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException{
		super.enter(container, game);
		
		clear();
		
		player = new Player(48,48);
		
		//currentLevel = new Level(new TiledMap("data/gametestmap.tmx"));
		currentLevel = Level.load("gametestmap", this);
		map = new TiledMap("data/gametestmap.tmx");
		this.setWidth(map.getWidth()* 16);
		this.setHeight(map.getHeight() * 16);
		
		add(player);
		
		gameCamera = new Camera(this,player,container.getWidth()/2,container.getHeight()/2,container.getWidth()-100,container.getHeight()-100,player.speed);
		
		setCamera(gameCamera);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		
		if(player.shouldTeleport){
			this.clear();
			currentLevel = Level.load(GlobalData.currentLevel, this);
			add(player);
			gameCamera.cameraX = Math.max(0, player.x - container.getWidth()/2);
			gameCamera.cameraY = Math.max(0,player.y - container.getHeight()/2);
			player.shouldTeleport = false;
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.scale(2, 2);
		g.setBackground(Color.black);
		super.render(container, game, g);
	}
}
