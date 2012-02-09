package com.webdevexp.cyberpunk;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public abstract class Character extends Entity{
	public Character(float x, float y) {
		// TODO Auto-generated constructor stub
		super(x,y);
	}
	

	protected String name;
	protected int totalHP;
	protected int totalMP;
	protected int currentHP;
	protected int currentMP;
	protected int EXP;
	protected Direction direction;
	protected Animation[] walkAnimation = new Animation[4];
	protected SpriteSheet sheet;
	
	protected enum Direction {
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
	
	protected String getName() {
		return name;
	}
	protected int getTotalHP() {
		return totalHP;
	}
	protected int getTotalMP() {
		return totalHP;
	}
	protected int getCurrentHP() {
		return currentHP;
	}
	protected int getCurrentMP() {
		return currentMP;
	}
	protected int getEXP() {
		return EXP;
	}
	protected void setName(String nameToUse) {
		name = nameToUse;
	}
	protected void setTotalHP(int newHP) {
		totalHP = newHP;
	}
	protected void setTotalMP(int newMP) {
		totalMP = newMP;
	}
	protected void setCurrentHP(int newHP) {
		currentHP = newHP;
	}
	protected void setCurrentMP(int newMP) {
		currentMP = newMP;
	}
	protected void setEXP(int newEXP) {
		EXP = newEXP;
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException{
		super.render(container, g);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException{
		super.update(container, delta);
	}
}
