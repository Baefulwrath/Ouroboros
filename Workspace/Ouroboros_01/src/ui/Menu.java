package ui;

import input.Pointer;

import java.awt.Rectangle;
import java.util.ArrayList;

import assets.ButtonStyle;

import rendering.RenderingHandler;

public abstract class Menu extends UIObject{
	
	public ArrayList<Button> buttons = new ArrayList<Button>();

	public Menu(String title, String script) {
		super(title, script, (int) RenderingHandler.getScreenX() + 200, (int) -RenderingHandler.getScreenY() - 200, 100, 100);
		RENDERTITLE = true;
		setup();
	}
	
	public void addButton(String text, String script, int x, int y, int w, int h, ButtonStyle bs){
		buttons.add(new Button(text, script, new Rectangle(x + BOX.x, y + BOX.y, w, h), bs));
	}
	
	public void addButton(String text, String script, int index, int w, int h, ButtonStyle bs){
		addButton(text, script, 20, -(index * (h + 10)) - 100, w, h, bs);
	}
	
	public void addButton(String text, String script, int w, int h, ButtonStyle bs){
		addButton(text, script, buttons.size(), w, h, bs);
	}
	
	public boolean intersects(Rectangle r){
		boolean temp = false;
		if(BOX.intersects(r)){
			temp = true;
		}else{
			for(int i = 0; i < buttons.size(); i++){
				if(buttons.get(i).intersects(r)){
					temp = true;
					break;
				}
			}
		}
		return temp;
	}
	
	@Override
	public void typeUpdate(Pointer p){
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).update(p);
		}
	}

	public void touchDown() {
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).ready();
		}
	}

	public void touchUp() {
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).setActive();
		}
	}

}
