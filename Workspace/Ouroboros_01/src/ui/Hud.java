package ui;

import java.awt.Rectangle;

public abstract class Hud extends UIObject{

	public Hud(String title, String script, int x, int y, int w, int h) {
		super(title, script, x, y, w, h);
		setup();
	}
	
	public Hud(String title, String script, Rectangle r) {
		super(title, script, r);
		setup();
	}

}
