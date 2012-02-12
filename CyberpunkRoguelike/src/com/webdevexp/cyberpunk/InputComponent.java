package com.webdevexp.cyberpunk;


import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import com.webdevexp.cyberpunk.Character.Direction;

public class InputComponent {
	
	private final float _SPEED = .1f;
	
	public InputComponent(){
		
	}

	public void update(GameContainer container, Player player){
		//check for input and collision with solids
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) {
			if(player.collide(Entity.SOLID, player.x-_SPEED, player.y)==null){
				player.x-=_SPEED;
				
			}
			player.direction = Direction.LEFT;
		}
		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) {
			if(player.collide(Entity.SOLID, player.x+_SPEED, player.y)==null){
				player.x+=_SPEED;
			}
			player.direction = Direction.RIGHT;
		}
		if (container.getInput().isKeyDown(Input.KEY_UP)) {
			if(player.collide(Entity.SOLID, player.x, player.y-_SPEED)==null){
				player.y-=_SPEED;
				
			}
			player.direction = Direction.UP;
		}
		if (container.getInput().isKeyDown(Input.KEY_DOWN)) {
			if(player.collide(Entity.SOLID, player.x, player.y+_SPEED)==null){
				player.y+=_SPEED;
				
			}
			player.direction = Direction.DOWN;
		}
		
		//check for teleporter collision
		if(player.collide("TELEPORT", player.x, player.y) != null){
			player.shouldTeleport = true;
		}
	}
}
