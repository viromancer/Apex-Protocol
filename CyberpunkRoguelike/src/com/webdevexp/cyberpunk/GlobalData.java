package com.webdevexp.cyberpunk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.geom.Rectangle;

public class GlobalData {
	static Map<String,Enemy> EnemyMap;
	public static Map<String,String> MatrixMap;
	public static String currentLevelName;
	public static String matrixLevelName;
	public static Level currentLevel;
	public static Player player;
	public static float playerX;
	public static float playerY;
	public static BulletFactory bulletFactory;
	public static LightMap lightMap;
	public static ArrayList<Rectangle> objectList;
	
	public static void init(){
		EnemyMap = new HashMap<String,Enemy>();
		MatrixMap = new HashMap<String,String>();
		player = new Player(48, 48);
		MatrixMap.put("gametestmap", "buildingtestmatrix");
		currentLevelName = "large_map_test";
		matrixLevelName = MatrixMap.get(currentLevel);
		bulletFactory = new BulletFactory(-1,-1);
		// Objects that block light and make shadows
	    objectList = new ArrayList<Rectangle>();
	}
	
}
