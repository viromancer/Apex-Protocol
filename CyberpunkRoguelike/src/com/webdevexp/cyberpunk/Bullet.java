package com.webdevexp.cyberpunk;

import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import it.marteEngine.entity.Entity;

public class Bullet extends Entity{
	public float distance = 0;
	public float velocityX;
	public float velocityY;
	public float angle;
	public final float SPEED = .25f;
	public boolean added;
	
	public Bullet(float x, float y, float anglePassed) {
		super(x, y);
		added = false;
		angle = anglePassed;
		setHitBox(0,0,1,1);
		addType("BULLET");
	}
	
	@Override
	public void update(GameContainer container, int delta){
		for(int i = 0; i<delta; i++){
			velocityX = (float) (SPEED * Math.cos(angle));
			velocityY = (float) (SPEED * Math.sin(angle));
			x += velocityX;
			y += velocityY;
			distance += (SPEED);
			
			if(collide(Entity.SOLID,x,y) != null){
				this.destroy();
			}
			
			if(distance >= 350){
				this.destroy();
			}
			
		}
		if(collide("ENEMY",x,y) != null){
			this.destroy();
		}
		//System.out.println(x +", "+y);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.drawOval(x, y, 1, 1);
	}
}
