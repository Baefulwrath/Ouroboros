package ui;

import java.awt.Rectangle;

import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Button {
	public boolean HOVER = false;
	public boolean ACTIVE = false;
	public String TITLE = "";
	public String SCRIPT = "";
	public ButtonStyle STYLE;
	public Rectangle BOX = new Rectangle();
	public int TITLEX = 16;

	public Button(String text, String buttonScript, Rectangle locdim, ButtonStyle style) {
		TITLE = text;
		SCRIPT = buttonScript;
		BOX = locdim;
		STYLE = style;
	}
	
	public void update(){
	}
	
	public boolean intersects(Rectangle r) {
		if(BOX.intersects(r)){
			return true;
		}else{
			return false;
		}
	}

	public LabelStyle getLabelStyle(){
		return STYLE.LABELSTYLE;
	}
	
	public NinePatch getTex(){
		if(ACTIVE && HOVER){
			return STYLE.DOWN;
		}else if(HOVER){
			return STYLE.HOVER;
		}else{
			return STYLE.UP;
		}
	}
	
	public int getTextY(){
		int temp = (int) ((BOX.height / 2) + (STYLE.LABELSTYLE.font.getCapHeight() / 2));
		return temp;
	}

}
