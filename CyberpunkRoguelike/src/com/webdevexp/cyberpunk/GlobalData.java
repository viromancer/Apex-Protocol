package com.webdevexp.cyberpunk;

import java.util.HashMap;
import java.util.Map;

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
	
	public static void init(){
		EnemyMap = new HashMap<String,Enemy>();
		MatrixMap = new HashMap<String,String>();
		player = new Player(0, 0);
		MatrixMap.put("gametestmap", "buildingtestmatrix");
		currentLevelName = "large_map_test";
		matrixLevelName = MatrixMap.get(currentLevel);
		bulletFactory = new BulletFactory(-1,-1);
	}
	
}
