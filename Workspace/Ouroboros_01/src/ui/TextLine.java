package ui;

import input.Pointer;

import java.awt.Rectangle;

import scripting.ScriptHandler;

import assets.ButtonStyle;

import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class TextLine {
	public String TEXT = "";
	public LabelStyle STYLE;
	public Rectangle BOX = new Rectangle();
	public int TITLEX = 16;
	public boolean RENDERBACKGROUND = false;
	public Sprite BACKGROUND;

	public TextLine(String text, Rectangle locdim, LabelStyle style) {
		TEXT = text;
		BOX = locdim;
		STYLE = style;
	}

	public boolean intersects(Rectangle r) {
		if(BOX.intersects(r)){
			return true;
		}else{
			return false;
		}
	}
	
	public int getTextY(){
		int temp = (int) ((BOX.height / 2) + (STYLE.font.getCapHeight() / 2));
		return temp;
	}

}
