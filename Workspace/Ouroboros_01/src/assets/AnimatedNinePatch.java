package assets;

import com.badlogic.gdx.graphics.g2d.NinePatch;

public class AnimatedNinePatch extends Animation{
	public boolean animated = false;
	private NinePatch[] imgs = new NinePatch[0];
	public int X = 0;
	public int Y = 0;
	public int W = 0;
	public int H = 0;

	public AnimatedNinePatch(NinePatch n, int x, int y, int w, int h) {
		imgs = new NinePatch[1];
		imgs[0] = n;
		X = x;
		Y = y;
		W = w;
		H = h;
		animated = false;
	}
	
	public AnimatedNinePatch(NinePatchImage n) {
		imgs = new NinePatch[1];
		imgs[0] = n.N;
		X = n.X;
		Y = n.Y;
		W = n.W;
		H = n.H;
		animated = false;
	}
	
	public AnimatedNinePatch(NinePatch[] n, int x, int y, int w, int h) {
		imgs = n;
		X = x;
		Y = y;
		W = w;
		H = h;
		animated = true;
	}
	
	public AnimatedNinePatch(NinePatchImage[] n, int x, int y, int w, int h) {
		imgs = new NinePatch[n.length];
		for(int i = 0; i < n.length; i++){
			imgs[i] = n[i].N;
		}
		X = n[0].X;
		Y = n[0].Y;
		W = n[0].W;
		H = n[0].H;
		animated = true;
	}
	
	public NinePatchImage getImage(){
		
	}
}
