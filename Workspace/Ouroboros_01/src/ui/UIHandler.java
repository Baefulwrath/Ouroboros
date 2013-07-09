package ui;

import java.awt.Rectangle;
import java.util.HashMap;

import ui.menus.*;


public class UIHandler {
	
	public static HashMap<String, Menu> menus = new HashMap<String, Menu>();
	public static String currentMenu = "";
	
	public static void setup(){
		menus.put("main", new MENU_main());
		currentMenu = "main";
	}

	public static boolean intersects(Rectangle r) {
		boolean temp = false;
		if(menus.get(currentMenu).intersects(r)){
			temp = true;
		}
		return temp;
	}

	public static void dispose() {
		menus.clear();
	}
	
}
