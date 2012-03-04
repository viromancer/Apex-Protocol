package com.webdevexp.cyberpunk;

import it.marteEngine.Camera;
import it.marteEngine.World;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import de.matthiasmann.twl.Button;

import TWLSlick.RootPane;

public class InGameState extends World{
	public InGameState(int id, GameContainer container) {
		super(id, container);
		
		// TODO Auto-generated constructor stub
		gameContainer = container;
	}
	
	TiledMap map;
	protected int mapWidth;
	protected int mapHeight;
	public static Camera gameCamera;
	GameContainer gameContainer;
	Image HUDBackground;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		super.init(container, game);
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException{
		super.enter(container, game);
		
		clear();
		
		GlobalData.player.x = 48;
		GlobalData.player.y = 48;
		
		//currentLevel = new Level(new TiledMap("data/gametestmap.tmx"));
		GlobalData.currentLevel = new Level(0,0);
		GlobalData.currentLevel.load(GlobalData.currentLevelName, this);
//		map = new TiledMap("data/gametestmap.tmx");
//		this.setWidth(map.getWidth()* 16);
//		this.setHeight(map.getHeight() * 16);
		
		add(GlobalData.currentLevel);
		add(GlobalData.player);
		add(GlobalData.bulletFactory);
		add(new Enemy("test",4,0,0,144,144));
		
		gameCamera = new Camera(this,GlobalData.player,container.getWidth()/3,container.getHeight()/3-50,container.getWidth(),container.getHeight()+50,GlobalData.player.speed);
		
		
		setCamera(gameCamera);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		
		if(GlobalData.player.shouldTeleport){
			this.clear();
			GlobalData.currentLevel.load(GlobalData.currentLevelName, this);
			if(GlobalData.currentLevelName.equals("missionSelect"))
			{
				game.enterState(0);
			}
			else{
				add(GlobalData.player);
				gameCamera.cameraX = Math.max(0, GlobalData.player.x - container.getWidth()/2);
				gameCamera.cameraY = Math.max(0,GlobalData.player.y - container.getHeight()/2);
				
			}
			GlobalData.player.shouldTeleport = false;
		}
		
		if(GlobalData.player.matrixTeleport){
			if(!GlobalData.player.inMatrix){
				GlobalData.player.inMatrix = true;
				
				this.clear();
				GlobalData.currentLevel.load(GlobalData.matrixLevelName, this);
				add(GlobalData.player);
				
				GlobalData.player.matrixTeleport = false;				
			}
			else{
				GlobalData.player.inMatrix = false;
				
				this.clear();
				GlobalData.currentLevel.load(GlobalData.currentLevelName, this);
				
				add(GlobalData.currentLevel);
				add(GlobalData.player);
				add(GlobalData.bulletFactory);
				
				GlobalData.player.matrixTeleport = false;
				
			}
		}
		for(Bullet b : GlobalData.bulletFactory.bulletList){
			if(b.added == false){
				add(b);
				b.added = true;
			}
		}
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.scale(3, 3);
		g.setBackground(Color.black);
		HUDBackground.draw(0,0);
		super.render(container, game, g);
		//Level.map.render(0,0,(int)gameCamera.cameraX, (int)gameCamera.cameraY, 1280/16, 960/16);
	}
	
	@Override
	protected RootPane createRootPane() {
		
		RootPane rp = super.createRootPane();
		rp.setTheme("gameui");
		
		Button skillBtn1;
		Button skillBtn2;
		Button skillBtn3;
		Button skillBtn4;
		
		try {
			HUDBackground = new Image("data/HUDBackground.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		skillBtn1 = new Button("  1");
		skillBtn1.setPosition(220, gameContainer.getScreenHeight()-77);
		skillBtn1.setTheme("simplebutton");

		skillBtn1.setInnerSize(20, 35);
		skillBtn1.addCallback(new Runnable() {
            public void run() {
                System.out.println("It worked!");
            }
        });
		
		skillBtn2 = new Button("  2");
		skillBtn2.setPosition(260, gameContainer.getScreenHeight()-77);
		skillBtn2.setTheme("simplebutton");

		skillBtn2.setInnerSize(20, 35);
		skillBtn2.addCallback(new Runnable() {
            public void run() {
                System.out.println("It worked!");
            }
        });
		
		skillBtn3 = new Button("  3");
		skillBtn3.setPosition(300, gameContainer.getScreenHeight()-77);
		skillBtn3.setTheme("simplebutton");

		skillBtn3.setInnerSize(20, 35);
		skillBtn3.addCallback(new Runnable() {
            public void run() {
                System.out.println("It worked!");
            }
        });
		
		skillBtn4 = new Button("  4");
		skillBtn4.setPosition(340, gameContainer.getScreenHeight()-77);
		skillBtn4.setTheme("simplebutton");

		skillBtn4.setInnerSize(20, 35);
		skillBtn4.addCallback(new Runnable() {
            public void run() {
                System.out.println("It worked!");
            }
        });

        rp.add(skillBtn1);
        rp.add(skillBtn2);
        rp.add(skillBtn3);
        rp.add(skillBtn4);
		
		return rp;
	}
}
