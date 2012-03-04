package com.webdevexp.cyberpunk;

import java.net.URL;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import TWLSlick.TWLStateBasedGame;

public class Game extends TWLStateBasedGame{
	
	public Game(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		container.setTargetFrameRate(60);
		GlobalData.init();
		//addState(new MissionSelectState(0,container));
		addState(new InGameState(1,container));
	}

	@Override
	protected URL getThemeURL() {
		// TODO Auto-generated method stub
		URL url = Game.class.getResource("/ui/CyberpunkTheme.xml");
		return url;
	}
	
	

}
