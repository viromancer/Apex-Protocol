package com.webdevexp.cyberpunk;

import it.marteEngine.entity.Entity;
import it.marteEngine.tween.LinearMotion;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Enemy extends Character{
	private AnimationComponent _anim;
	private final float _SPEED = .05f;
	int totalHP, totalMP, currentHP, currentMP, EXP;
	public Light light;
	
	public Enemy(float x, float y)
	{
		super(x,y);
		
	}
	
	public Enemy(String enemyName, int totalEnemyHP, int totalEnemyMP, int worthEXP, float x, float y){
		super(x,y);
		name = enemyName;
		totalHP = totalEnemyHP;
		totalMP = totalEnemyMP;
		currentHP = totalHP;
		currentMP = totalMP;
		EXP = worthEXP;
		
		setHitBox(2, 1, 14, 15);
		speed = new Vector2f(8.0f,3.0f);
		addType("ENEMY");
		
		//need to change this to be dynamic, should be able to create the animation correctly from the constructor for any image
		_anim = new AnimationComponent("data/bot2.png",16,16,this);
	}
	
	@Override
	public void collisionResponse(Entity other){
		if(other.isType("BULLET")){
			currentHP--;
			this.world.add(new ScrollingCombatText(x,y, "-1","DAMAGE"));
		}
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		// TODO Auto-generated method stub
		_anim.render(g);
		if(currentHP <= 0){
			this.world.add(new ScrollingCombatText(GlobalData.player.x,GlobalData.player.y, "+"+EXP+" exp"));
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//super.update(container,  delta);
		// TODO Auto-generated method stub
		for(int i = 0; i<delta; i++){
			if(currentHP <= 0){
				GlobalData.lightMap.removeLight(light);
				this.destroy();
			}
			else{
				if(this.x < GlobalData.player.x && collide(Entity.SOLID, x+_SPEED, y)==null && collide(Entity.PLAYER, x+_SPEED, y)==null){
					this.x+=_SPEED;
				}
				if(this.x > GlobalData.player.x && collide(Entity.SOLID, x-_SPEED, y)==null && collide(Entity.PLAYER, x-_SPEED, y)==null){
					this.x-=_SPEED;
				}
				if(this.y < GlobalData.player.y && collide(Entity.SOLID, x, y+_SPEED)==null && collide(Entity.PLAYER, x, y+_SPEED)==null){
					this.y+=_SPEED;
				}
				if(this.y > GlobalData.player.y && collide(Entity.SOLID, x, y-_SPEED)==null && collide(Entity.PLAYER, x, y-_SPEED)==null){
					this.y-=_SPEED;
				}
			}
		
		}
	}
}
