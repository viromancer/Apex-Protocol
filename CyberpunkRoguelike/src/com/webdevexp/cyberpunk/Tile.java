package com.webdevexp.cyberpunk;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Tile extends Entity{
	SpriteSheet tileSheet;
	public Image tileImage;
	
	public Tile(Image image, float x, float y, String type){
		super(x,y);
		tileImage = image;
		if(type.equals("wall")){
			setHitBox(0,0,16,16);
			addType(SOLID);
		}
	}
	
	@Override
	public void render(GameContainer container, Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tileImage, x, y);
	}

	@Override
	public void update(GameContainer container, int delta) {
		// TODO Auto-generated method stub
	}
	
}
