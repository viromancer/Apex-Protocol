package com.webdevexp.cyberpunk;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.webdevexp.cyberpunk.Character.Direction;

public class AnimationComponent {
	
	private SpriteSheet sheet;
	private final int _left = 0, _right = 1, _up = 2, _down = 3; 
	private Character character;
	
	public AnimationComponent(String sheetFile, int tileWidth, int tileHeight, Character theCharacter){
		try {
			sheet = new SpriteSheet(sheetFile,16,16);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		character = theCharacter;
		
		character.direction = Direction.LEFT;
		character.walkAnimation[_left] = new Animation();
		character.walkAnimation[_left].setAutoUpdate(true);
		character.walkAnimation[_right] = new Animation();
		character.walkAnimation[_right].setAutoUpdate(true);
		character.walkAnimation[_up] = new Animation();
		character.walkAnimation[_up].setAutoUpdate(true);
		character.walkAnimation[_down] = new Animation();
		character.walkAnimation[_down].setAutoUpdate(true);
		
		
		
		for (int frame=0;frame<2;frame++) {
			character.walkAnimation[_down].addFrame(sheet.getSprite(frame,0), 200);
		}
		for (int frame=0;frame<2;frame++) {
			character.walkAnimation[_right].addFrame(sheet.getSprite(frame,1), 200);
		}
		for (int frame=0;frame<2;frame++) {
			character.walkAnimation[_left].addFrame(sheet.getSprite(frame,2), 200);
		}
		for (int frame=0;frame<2;frame++) {
			character.walkAnimation[_up].addFrame(sheet.getSprite(frame,3), 200);
		}
	}
	
	public void render(Graphics g){
		switch (character.direction){
		case  UP:
			g.drawAnimation(character.walkAnimation[_up], character.x, character.y);
			break;
		case  DOWN:
			g.drawAnimation(character.walkAnimation[_down], character.x, character.y);
			break;
		case  LEFT:
			g.drawAnimation(character.walkAnimation[_left], character.x, character.y);
			break;
		case  RIGHT:
			g.drawAnimation(character.walkAnimation[_right], character.x, character.y);
			break;
		}
	}
}
