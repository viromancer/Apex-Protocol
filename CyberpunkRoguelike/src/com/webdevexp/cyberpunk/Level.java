package com.webdevexp.cyberpunk;

import it.marteEngine.World;
import it.marteEngine.entity.Entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;


public class Level extends Entity{
	public int mapWidth, mapHeight;
	public Level(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public TiledMap map;
	
	
	
	public void load(String mapToLoad, World world) throws SlickException{
		Image tileImage;
		int tileId;
		String tileType;
		String lightIntensity;
		
		map = new TiledMap("data/"+mapToLoad+".tmx");
		if(!GlobalData.player.inMatrix)
			GlobalData.currentLevelName = mapToLoad;
		GlobalData.matrixLevelName = GlobalData.MatrixMap.get(mapToLoad);
		
		mapHeight = map.getHeight();
		mapWidth = map.getWidth();
		
		LightMap lightMap = new LightMap(0, 0,16);
		GlobalData.lightMap = lightMap;
		world.add(GlobalData.lightMap);
		lightMap.addLight(new Light(GlobalData.player,150,Color.white));
		
		for(int i=0; i<map.getLayerCount();i++){
			
			for (int y=0; y< map.getHeight(); y++){
				for(int x=0; x<map.getWidth(); x++){
					tileImage = map.getTileImage(x, y, i);
					tileId = map.getTileId(x, y, i);
					tileType = map.getTileProperty(tileId, "type", "floor");
					lightIntensity = map.getTileProperty(tileId, "intensity", "0");
					if (tileImage != null){
						if(tileType.equals("wall")){
							world.add(new Tile(tileImage,x*16,y*16,tileType));
							GlobalData.objectList.add(new Rectangle(x*16, y*16, 16, 16));
						}
						else if(tileType.equals("light")){
							GlobalData.lightMap.addLight(new Light(x*16,y*16,Integer.parseInt(lightIntensity),Color.white));
						}
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
	
	private void CreateEntities(){
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g){
		map.render((int)x, (int)y);
	}

}
