package ui;

import java.awt.Rectangle;
import java.util.ArrayList;

import rendering.RenderingHandler;

public abstract class Menu extends UIObject{
	
	public ArrayList<Button> buttons = new ArrayList<Button>();

	public Menu(String title, String script) {
		super(title, script, (int) RenderingHandler.getScreenX() + 100, (int) -RenderingHandler.getScreenY() - 200, 0, 0);
	}
	
	public void addButton(String text, String script, int x, int y, int w, int h, ButtonStyle bs){
		buttons.add(new Button(text, script, new Rectangle(x + BOX.x, y + BOX.y, w, h), bs));
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

}
