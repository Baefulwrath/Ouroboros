package ui;

import input.Pointer;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import assets.ButtonStyle;

import rendering.RenderingHandler;

public abstract class Menu extends UIObject{
	
	public ArrayList<Button> buttons = new ArrayList<Button>();
	public ArrayList<TextLine> textLines = new ArrayList<TextLine>();
	public static int itemInterval = 10;

	public Menu(String title, String script) {
		super(title, script, (int) RenderingHandler.getScreenX() + 200, (int) -RenderingHandler.getScreenY() - 200, 100, 100);
		RENDERTITLE = true;
		setup();
	}
	
	public Menu(Menu m) {
		super(m.TITLE, m.SCRIPT, (int) RenderingHandler.getScreenX() + 200, (int) -RenderingHandler.getScreenY() - 200, 100, 100);
		mirror(m);
	}
	
	public void mirror(Menu m) {
		for(int i = 0; i < m.buttons.size(); i++){
			addButton(m.buttons.get(i));
		}
		BOX = m.BOX;
		OPACITY = m.OPACITY;
		RENDERTITLE = m.RENDERTITLE;
		SCRIPT = m.SCRIPT;
		TITLE = m.TITLE;
	}

	public void addButton(String text, String script, int x, int y, int w, int h, ButtonStyle bs){
		addButton(new Button(text, script, new Rectangle(x + BOX.x, y + BOX.y, w, h), bs));
	}
	
	public void addButton(String text, String script, int index, int w, int h, ButtonStyle bs){
		addButton(text, script, 20, getCurrentY() - 100, w, h, bs);
	}
	
	public void addButton(String text, String script, int w, int h, ButtonStyle bs){
		addButton(text, script, getIndex(), w, h, bs);
	}

	public void addButton(Button b){
		buttons.add(b);
	}
	
	public void addTextLine(String text, int x, int y, int w, int h, LabelStyle ls){
		addTextLine(new TextLine(text, new Rectangle(x, y, w, h), ls));
	}
	
	public void addTextLine(String text, int index, int w, int h, LabelStyle ls){
		addTextLine(text, 20, getCurrentY() - 100, w, h, ls);
	}
	
	public void addTextLine(String text, int w, int h, LabelStyle ls){
		addTextLine(text, getIndex(), w, h, ls);
	}
	
	public void addTextLine(TextLine t){
		textLines.add(t);
	}
	
	private int getIndex(){
		return buttons.size() + textLines.size();
	}
	
	private int getCurrentY(){
		int y = 0;
		for(int i = 0; i < buttons.size(); i++){
			y -= buttons.get(i).BOX.height + itemInterval;
		}
		return y;
	}
	
	@Override
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

	@Override
	public void touchDown() {
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).ready();
		}
	}

	@Override
	public void touchUp() {
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).setActive();
		}
	}

}
