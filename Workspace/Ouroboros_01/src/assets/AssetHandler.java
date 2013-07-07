package assets;

import static com.badlogic.gdx.Gdx.*;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class AssetHandler {
	
    private static BitmapFont com64;
    private static BitmapFont com32;
    private static BitmapFont com16;
    private static BitmapFont com10;
    private static BitmapFont com32_BI;
    private static BitmapFont com16_BI;
    private static BitmapFont com10_BI;
    
    public static LabelStyle messageLabelStyle;
    public static LabelStyle logoLabelStyle;
    public static LabelStyle debugLabelStyle;
    public static LabelStyle basicLabelStyle;
    public static LabelStyle titleLabelStyle;
    public static LabelStyle warningLabelStyle;

	public static NinePatch basicButton_u;
	public static NinePatch basicButton_h;
	public static NinePatch basicButton_d;
	
	public static NinePatch basicHud;
	public static NinePatch brushImg;
	
	public static ButtonStyle basicButtonStyle;
	
	public static void setup(){
		load();
	}

    public static void load(){
    	try{
            com64 = new BitmapFont(files.internal("data/fonts/com64.fnt"), files.internal("data/fonts/com64.png"), false, false);
            com32 = new BitmapFont(files.internal("data/fonts/com32.fnt"), files.internal("data/fonts/com32.png"), false, false);
            com16 = new BitmapFont(files.internal("data/fonts/com16.fnt"), files.internal("data/fonts/com16.png"), false, false);
            com10 = new BitmapFont(files.internal("data/fonts/com10.fnt"), files.internal("data/fonts/com10.png"), false, false);
            com32_BI = new BitmapFont(files.internal("data/fonts/com32_BI.fnt"), files.internal("data/fonts/com32_BI.png"), false, false);
            com16_BI = new BitmapFont(files.internal("data/fonts/com16_BI.fnt"), files.internal("data/fonts/com16_BI.png"), false, false);
            com10_BI = new BitmapFont(files.internal("data/fonts/com10_BI.fnt"), files.internal("data/fonts/com10_BI.png"), false, false);
        	
            messageLabelStyle = new LabelStyle(com10, Color.CYAN);
            logoLabelStyle = new LabelStyle(com64, Color.WHITE);
            debugLabelStyle = new LabelStyle(com10, Color.RED);
            titleLabelStyle = new LabelStyle(com32_BI, Color.WHITE);
            basicLabelStyle = new LabelStyle(com10, Color.WHITE);
            warningLabelStyle = new LabelStyle(com16, Color.RED);

            basicButton_u = parsePatch(files.internal("data/images/ninepatches/basicButton_u_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicButton_u.png")));
            basicButton_h = parsePatch(files.internal("data/images/ninepatches/basicButton_h_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicButton_h.png")));
            basicButton_d = parsePatch(files.internal("data/images/ninepatches/basicButton_d_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicButton_d.png")));
            
            basicHud = parsePatch(files.internal("data/images/ninepatches/basicHud_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicHud.png")));
            brushImg = parsePatch(files.internal("data/images/ninepatches/brushImg_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/brushImg.png")));
            
            basicButtonStyle = new ButtonStyle(basicButton_u, basicButton_h, basicButton_d, basicLabelStyle);

    	}catch(Exception ex){
    		ex.printStackTrace(System.out);
    	}
    }
    
    public static NinePatch parsePatch(String info, Texture tex){
    	NinePatch NP;
    	int left = Integer.parseInt(info.substring(0, info.indexOf(",")));
    	info = info.substring(info.indexOf(",") + 1);
    	int right = Integer.parseInt(info.substring(0, info.indexOf(",")));
    	info = info.substring(info.indexOf(",") + 1);
    	int top = Integer.parseInt(info.substring(0, info.indexOf(",")));
    	int bottom = Integer.parseInt(info.substring(info.indexOf(",") + 1));
    	NP = new NinePatch(tex, left, right, top, bottom);
    	return NP;
    }

	public static void dispose() {
	}
}
