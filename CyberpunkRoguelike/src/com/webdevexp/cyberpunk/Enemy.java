package com.webdevexp.cyberpunk;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Enemy extends Character{
	
	public Enemy(float x, float y)
	{
		super(x,y);
	}
	
	public Enemy(String name, int totalHP, int totalMP, int currentHP, int currentMP, int EXP, float x, float y){
		super(x,y);
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer container, int delta) {
		// TODO Auto-generated method stub
		
	}
}
