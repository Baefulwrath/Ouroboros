package ui;

import input.Pointer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import ouroboros.NodeType;
import ouroboros.ProgramNode;

import ui.menus.*;


public class UIHandler extends ProgramNode{
	
	public static HashMap<String, Menu> menus = new HashMap<String, Menu>();
	public static ArrayList<Message> messages = new ArrayList<Message>();
	public static String currentMenu = "";
	
	public static void setup(){
		menus.put("main", new MENU_main());
		currentMenu = "main";
	}

	public static boolean intersects(Rectangle r) {
		boolean temp = false;
		if(getMenu().intersects(r)){
			temp = true;
		}
		return temp;
	}

	public static void dispose() {
		menus.clear();
	}

	public static Menu getMenu() {
		return menus.get(currentMenu);
	}
	
	public static void update(Pointer p){
		if(readyToUpdate(25, NodeType.UIHANDLER)){
			getMenu().update(p);
			updateMessages();
		}
	}

	public static void touchDown() {
		getMenu().touchDown();
	}
	
	public static void touchUp() {
		getMenu().touchUp();
	}
	
	public static void print(String s){
		System.out.println(s);
		messages.add(new Message(s, 4000));
	}
	
	public static void print(String s, int time){
		System.out.println(s);
		messages.add(new Message(s, time));
	}

	public static void updateMessages(){
    	for(int i = 0; i < messages.size(); i++){
    		Message m = messages.get(i);
    		if(m.creationTime + m.LIFETIME <= System.currentTimeMillis()){
    			//System.out.println("--<" + m.TEXT + ">--");
    			messages.remove(i);
    			updateMessages();
    			break;
    		}
    	}
	}
	
}
