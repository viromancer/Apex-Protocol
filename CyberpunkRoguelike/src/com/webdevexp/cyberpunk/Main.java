package com.webdevexp.cyberpunk;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] argv) throws SlickException {
		AppGameContainer container = 
			new AppGameContainer(new Game("Cyberpunk Roguelike"), 640, 480, false);
		container.start();
	}

}
