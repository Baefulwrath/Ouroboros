package ui;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class TextArea {
	public Rectangle BOX = new Rectangle();
	public int rowLength = 20;
	public Label[] TEXT = new Label[0];
	
	public TextArea(String t, int x, int y, int w, int h, LabelStyle ls){
		TEXT = getArea(t, x, y, h, ls);
		BOX = new Rectangle(x, y, w, h);
	}
	
	public TextArea(Label[] t, Rectangle r){
		TEXT = t;
		BOX = r;
	}
	
	private Label[] getArea(String t, int x, int y, int h, LabelStyle ls){
		ArrayList<Label> l = new ArrayList<Label>();
		int i = 0;
		while(t.length() > rowLength){
			Label lab = new Label(t.substring(0, rowLength), ls);
			lab.setPosition(x, getLabelY(i, h));
			l.add(lab);
			t = t.substring(rowLength);
			i++;
		}
		Label lab = new Label(t, ls);
		lab.setPosition(x, getLabelY(i, h));
		l.add(lab);
		Label[] lar = new Label[l.size()];
		for(int i2 = 0; i2 < l.size(); i2++){
			lar[i2] = l.get(i2);
		}
		return lar;
	}
	
	private int getLabelY(int i, int h){
		return -(i * (h + 10));
	}

	public int getHeight() {
		return BOX.height;
	}
	
}
