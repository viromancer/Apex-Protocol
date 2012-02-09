package com.webdevexp.cyberpunk;

import java.util.HashMap;
import java.util.Map;

public class GlobalData {
	static Map<String,Enemy> EnemyMap;
	public static String currentLevel;
	public static float playerX;
	public static float playerY;
	
	public GlobalData(){
		EnemyMap = new HashMap<String,Enemy>();
	}
}
