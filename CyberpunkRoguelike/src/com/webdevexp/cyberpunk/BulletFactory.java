package com.webdevexp.cyberpunk;

import it.marteEngine.entity.Entity;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

public class BulletFactory extends Entity{
	public static ArrayList<Bullet> bulletList;
	
	public BulletFactory(float x, float y){
		super(x,y);
		bulletList = new ArrayList<Bullet>();
	}
	
	public Bullet createBullet(float x, float y, float angle){
		Bullet bulletToAdd = new Bullet(x,y,angle);
		bulletList.add(bulletToAdd);
		return bulletToAdd;
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		// TODO Auto-generated method stub
		for(int i = 0; i<delta; i++){
		}
	}
}
