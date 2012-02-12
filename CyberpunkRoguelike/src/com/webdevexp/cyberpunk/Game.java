package com.webdevexp.cyberpunk;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame{
	
	public Game(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		container.setTargetFrameRate(60);
		addState(new InGameState(1,container));
	}
	
	

}
