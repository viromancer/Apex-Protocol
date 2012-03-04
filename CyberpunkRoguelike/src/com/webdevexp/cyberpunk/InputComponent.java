package com.webdevexp.cyberpunk;


import it.marteEngine.World;
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import com.webdevexp.cyberpunk.Character.Direction;

public class InputComponent {
	
	private final float _SPEED = .1f;
	
	public InputComponent(){
		
	}

	public void update(GameContainer container, Player player){
		//check for input and collision with solids
		if (container.getInput().isKeyPressed(Input.KEY_LEFT) || container.getInput().isKeyDown(Input.KEY_A)) {
			if(player.collide(Entity.SOLID, player.x-_SPEED, player.y)==null && player.collide("ENEMY", player.x-_SPEED, player.y)==null){
				player.x-=_SPEED;
				
			}
			player.direction = Direction.LEFT;
		}
		if (container.getInput().isKeyDown(Input.KEY_RIGHT) || container.getInput().isKeyDown(Input.KEY_D)) {
			if(player.collide(Entity.SOLID, player.x+_SPEED, player.y)==null && player.collide("ENEMY", player.x+_SPEED, player.y)==null){
				player.x+=_SPEED;
			}
			player.direction = Direction.RIGHT;
		}
		if (container.getInput().isKeyDown(Input.KEY_UP) || container.getInput().isKeyDown(Input.KEY_W)) {
			if(player.collide(Entity.SOLID, player.x, player.y-_SPEED)==null && player.collide("ENEMY", player.x, player.y-_SPEED)==null){
				player.y-=_SPEED;
				
			}
			player.direction = Direction.UP;
		}
		if (container.getInput().isKeyDown(Input.KEY_DOWN) || container.getInput().isKeyDown(Input.KEY_S)) {
			if(player.collide(Entity.SOLID, player.x, player.y+_SPEED)==null && player.collide("ENEMY", player.x, player.y+_SPEED)==null){
				player.y+=_SPEED;
			}
			player.direction = Direction.DOWN;
		}
		
		if(container.getInput().isKeyPressed(Input.KEY_T)){
			player.matrixTeleport = true;
		}
		
		if(container.getInput().isMousePressed(0)){
			GlobalData.bulletFactory.createBullet(player.x+8, player.y+8,(float) ((Math.atan2((container.getInput().getAbsoluteMouseY()/3+InGameState.gameCamera.cameraY)-(player.y+8), (container.getInput().getAbsoluteMouseX()/3+InGameState.gameCamera.cameraX)-(player.x+8)))));
		}
			
		
		//check for teleporter collision
		if(player.collide("TELEPORT", player.x, player.y) != null){
			player.shouldTeleport = true;
		}

	}
}
