package com.webdevexp.cyberpunk;

import it.marteEngine.World;
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class Level extends Entity{
	
	public Level(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public TiledMap map;
	
	
	
	public void load(String mapToLoad, World world) throws SlickException{
		Image tileImage;
		int tileId;
		String tileType;
		
		map = new TiledMap("data/"+mapToLoad+".tmx");
		if(!GlobalData.player.inMatrix)
			GlobalData.currentLevelName = mapToLoad;
		GlobalData.matrixLevelName = GlobalData.MatrixMap.get(mapToLoad);
		
		for(int i=0; i<map.getLayerCount();i++){
			
			for (int y=0; y< map.getHeight(); y++){
				for(int x=0; x<map.getWidth(); x++){
					tileImage = map.getTileImage(x, y, i);
					tileId = map.getTileId(x, y, i);
					tileType = map.getTileProperty(tileId, "type", "floor");
					if (tileImage != null){
						if(tileType.equals("wall"))
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
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g){
		map.render((int)x, (int)y);
	}

}
