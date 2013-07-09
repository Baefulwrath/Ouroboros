package ui;

import java.awt.Rectangle;

public abstract class UIObject {
	public Rectangle BOX = new Rectangle();
	public float OPACITY = 1.0f;
	public boolean RENDERTITLE = false;
	public String TITLE = "UNTITLED";
	public String SCRIPT = "";
	public int TITLEX = 0;
	public int TITLEY = 0;
	
	
	public UIObject(String title, String script, int x, int y, int w, int h){
		TITLE = title;
		SCRIPT = script;
		BOX = new Rectangle(x, y, w, h);
		setup();
	}
	
	public UIObject(String title, String script, Rectangle r){
		TITLE = title;
		SCRIPT = script;
		BOX = r;
		setup();
	}
	
	public void update(){
		clear();
		content();
	}

	protected abstract void content();

	private void clear() {
	}

	protected abstract void setup();
}
