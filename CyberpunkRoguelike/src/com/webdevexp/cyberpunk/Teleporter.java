package com.webdevexp.cyberpunk;


import it.marteEngine.entity.Entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;

public class Teleporter extends Entity{
	private float width, height;
	private float exitX, exitY;
	private String exitMap;
	
	public Teleporter(float x, float y, float w, float h, float exit_x, float exit_y, String exit_map) {
		super( x, y);
		// TODO Auto-generated constructor stub
		width = w;
		height = h;
		exitX = exit_x;
		exitY = exit_y;
		exitMap = exit_map;
		
		setHitBox(0.0f, 0.0f, Math.round(width), Math.round(height));
		addType("TELEPORT");
	}
	
	@Override
	public void collisionResponse(Entity other){
		other.x = exitX*16;
		other.y = exitY*16;
		GlobalData.currentLevel = exitMap;
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.drawRect(x, y, width, height);
	}

}
