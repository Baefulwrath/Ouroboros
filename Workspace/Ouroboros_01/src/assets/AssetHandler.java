package assets;

import static com.badlogic.gdx.Gdx.*;

import java.util.HashMap;

import master.ProgramNode;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class AssetHandler extends ProgramNode{
    
    private static HashMap<String, BitmapFont> fonts = new HashMap<String, BitmapFont>();
    
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
    		loadFonts();
    		
    		loadLabelStyles();

            basicButton_u = parsePatch(files.internal("data/images/ninepatches/basicButton_u_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicButton_u.png")));
            basicButton_h = parsePatch(files.internal("data/images/ninepatches/basicButton_h_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicButton_h.png")));
            basicButton_d = parsePatch(files.internal("data/images/ninepatches/basicButton_d_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicButton_d.png")));
            
            basicHud = parsePatch(files.internal("data/images/ninepatches/basicHud_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/basicHud.png")));
            brushImg = parsePatch(files.internal("data/images/ninepatches/brushImg_p.txt").readString(), new Texture(files.internal("data/images/ninepatches/brushImg.png")));
            
            basicButtonStyle = new ButtonStyle(basicButton_u, basicButton_h, basicButton_d, basicLabelStyle);

            System.out.println("Fonts: " + fonts.toString());
    	}catch(Exception ex){
    		ex.printStackTrace(System.out);
    	}
    }
    
    public static void loadFonts() throws Exception{
        fonts.put("com64", new BitmapFont(files.internal("data/fonts/com64.fnt"), files.internal("data/fonts/com64.png"), false, false));
        fonts.put("com32", new BitmapFont(files.internal("data/fonts/com32.fnt"), files.internal("data/fonts/com32.png"), false, false));
        fonts.put("com16", new BitmapFont(files.internal("data/fonts/com16.fnt"), files.internal("data/fonts/com16.png"), false, false));
        fonts.put("com10", new BitmapFont(files.internal("data/fonts/com10.fnt"), files.internal("data/fonts/com10.png"), false, false));
        fonts.put("com32_BI", new BitmapFont(files.internal("data/fonts/com32_BI.fnt"), files.internal("data/fonts/com32_BI.png"), false, false));
        fonts.put("com16_BI", new BitmapFont(files.internal("data/fonts/com16_BI.fnt"), files.internal("data/fonts/com16_BI.png"), false, false));
        fonts.put("com10_BI", new BitmapFont(files.internal("data/fonts/com10_BI.fnt"), files.internal("data/fonts/com10_BI.png"), false, false));

        fonts.put("helv10", new BitmapFont(files.internal("data/fonts/helv10.fnt"), files.internal("data/fonts/helv10.png"), false, false));
        fonts.put("helv16", new BitmapFont(files.internal("data/fonts/helv16.fnt"), files.internal("data/fonts/helv16.png"), false, false));
        fonts.put("helv32", new BitmapFont(files.internal("data/fonts/helv32.fnt"), files.internal("data/fonts/helv32.png"), false, false));
        fonts.put("helv64", new BitmapFont(files.internal("data/fonts/helv64.fnt"), files.internal("data/fonts/helv64.png"), false, false));
        fonts.put("helv10_BI", new BitmapFont(files.internal("data/fonts/helv10_BI.fnt"), files.internal("data/fonts/helv10_BI.png"), false, false));
        fonts.put("helv16_BI", new BitmapFont(files.internal("data/fonts/helv16_BI.fnt"), files.internal("data/fonts/helv16_BI.png"), false, false));
        fonts.put("helv32_BI", new BitmapFont(files.internal("data/fonts/helv32_BI.fnt"), files.internal("data/fonts/helv32_BI.png"), false, false));
        fonts.put("helv64_BI", new BitmapFont(files.internal("data/fonts/helv64_BI.fnt"), files.internal("data/fonts/helv64_BI.png"), false, false));
        
        fonts.put("title32", new BitmapFont(files.internal("data/fonts/title32.fnt"), files.internal("data/fonts/title32.png"), false, false));
        fonts.put("title64", new BitmapFont(files.internal("data/fonts/title64.fnt"), files.internal("data/fonts/title64.png"), false, false));

        fonts.put("soli16", new BitmapFont(files.internal("data/fonts/soli16.fnt"), files.internal("data/fonts/soli16.png"), false, false));
        fonts.put("soli32", new BitmapFont(files.internal("data/fonts/soli32.fnt"), files.internal("data/fonts/soli32.png"), false, false));
        fonts.put("soli64", new BitmapFont(files.internal("data/fonts/soli64.fnt"), files.internal("data/fonts/soli64.png"), false, false));

        fonts.put("ref16", new BitmapFont(files.internal("data/fonts/ref16.fnt"), files.internal("data/fonts/ref16.png"), false, false));
        fonts.put("ref32", new BitmapFont(files.internal("data/fonts/ref32.fnt"), files.internal("data/fonts/ref32.png"), false, false));
        fonts.put("ref64", new BitmapFont(files.internal("data/fonts/ref64.fnt"), files.internal("data/fonts/ref64.png"), false, false));
    }
    
    public static void loadLabelStyles() throws Exception{
        messageLabelStyle = new LabelStyle(fonts.get("helv16"), Color.CYAN);
        logoLabelStyle = new LabelStyle(fonts.get("helv64"), Color.WHITE);
        debugLabelStyle = new LabelStyle(fonts.get("helv16"), Color.RED);
        titleLabelStyle = new LabelStyle(fonts.get("helv32_BI"), Color.WHITE);
        basicLabelStyle = new LabelStyle(fonts.get("helv16"), Color.WHITE);
        warningLabelStyle = new LabelStyle(fonts.get("helv16"), Color.RED);
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
		fonts.clear();
	}
}
