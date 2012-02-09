package com.webdevexp.cyberpunk;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;


public class Player extends Character{
	//declare constants for readability in animations
	
	private final float _SPEED = .1f;
	private InputComponent _input;
	private AnimationComponent _anim;
	public boolean shouldTeleport = false;
	
	public Player(float x, float y){
		super(x,y);
		setHitBox(2, 6, 12, 10);
		speed = new Vector2f(8.0f,3.0f);
		addType(PLAYER);
		
		_input = new InputComponent();
		_anim = new AnimationComponent("data/hero2.png",16,16,this);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) {
		// TODO Auto-generated method stub
		_anim.render(g);
	}

	@Override
	public void update(GameContainer container, int delta) {
		// TODO Auto-generated method stub
		_input.update(container, this);
	}

	
}
