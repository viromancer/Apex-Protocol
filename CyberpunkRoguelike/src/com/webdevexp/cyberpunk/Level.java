package com.webdevexp.cyberpunk;

import it.marteEngine.World;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class Level {
	
	public Level(){}
	
	
	public static Level load(String mapToLoad, World world) throws SlickException{
		Image tileImage;
		int tileId;
		String tileType;
		Level loadedLevel;
		TiledMap map;
		
		
		loadedLevel = new Level();
		map = new TiledMap("data/"+mapToLoad+".tmx");
		
		for(int i=0; i<map.getLayerCount();i++){
			
			for (int y=0; y< map.getHeight(); y++){
				for(int x=0; x<map.getWidth(); x++){
					tileImage = map.getTileImage(x, y, i);
					tileId = map.getTileId(x, y, i);
					tileType = map.getTileProperty(tileId, "type", "floor");
					if (tileImage != null){
							world.add(new Tile(tileImage,x*16,y*16,tileType));
					}
				}
			}
			
		}
		
		for(int r=0; r<map.getObjectGroupCount(); r++){
			for(int t=0; t<map.getObjectCount(r); t++){
				world.add(new Teleporter(map.getObjectX(r, t), 
										map.getObjectY(r, t), 
										map.getObjectWidth(r, t),
										map.getObjectHeight(r, t), 
										Integer.parseInt(map.getObjectProperty(r, t, "exit_x", "0")),
										Integer.parseInt(map.getObjectProperty(r,t,"exit_y","0")), 
										map.getObjectProperty(r, t, "exit_map", "default")));
			}
		}
		
		return loadedLevel;
	}

}
