package com.webdevexp.cyberpunk;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.marteEngine.World;

public class MissionSelectState extends World{
	Image backgroundMap;
	Image missionButton;
	Image[] missionButtons;
	
	public MissionSelectState(int id, GameContainer container) {
		super(id, container);
		// TODO Auto-generated constructor stub
		
		missionButtons = new Image[5];
		try {
			backgroundMap = new Image("data/overworld.png");
			missionButton =  new Image("data/map_icons.png");
			for (int i = 0; i<2; i++){
				missionButtons[i] = missionButton.getSubImage(0, 0, 32, 32).getScaledCopy(.5f);
			}
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		backgroundMap.draw(0,0);
		
		//draw the mission buttons at their locations
		missionButtons[0].draw(40,40); //Player's base
		
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
		throws SlickException {
			super.update(container, game, delta);
			if (container.getInput().isKeyDown(Input.KEY_ESCAPE))
				game.enterState(1);
			
			if(container.getInput().isMousePressed(0))
			{
				int mouseX=container.getInput().getAbsoluteMouseX();
				int mouseY=container.getInput().getAbsoluteMouseY();
				if(checkMouseCollide(mouseX,mouseY) == 0){
					GlobalData.currentLevelName = "buildingtestmap";
					game.enterState(1);
				}
				
			}
	}
	
	/*
	 * only  checking one button for now... should update this later for using many button checks
	 */
	public int checkMouseCollide(int x, int y){
		System.out.println(x+", "+y);
		if(40<=x && x<=72){
			if(40<=y && y<=72){
				return 0;
			}
		}
		return -1;
	}
	

}
