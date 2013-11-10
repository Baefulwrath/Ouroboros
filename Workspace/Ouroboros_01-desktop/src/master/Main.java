package master;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;

import master.Master;
import master.ProgramState;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		loadStartupSettings(cfg);
		
		if(cfg.fullscreen && getSystemRes){
			Toolkit toolkit =  Toolkit.getDefaultToolkit();
			Dimension dim = toolkit.getScreenSize();
			cfg.width = dim.width;
			cfg.height = dim.height;
		}
		
		new LwjglApplication(new Master(startupState, defaultMenu), cfg);
	}
	
	public static boolean getSystemRes = false;
	public static String defaultMenu = "main";
	public static ProgramState startupState = ProgramState.DEFAULT;
	
	public static void loadStartupSettings(LwjglApplicationConfiguration cfg){
		try{
			
			Properties prop = new Properties();
			prop.load(new FileInputStream("config.properties"));
			cfg.title = prop.getProperty("title", "Ouroboros Engine - Config Missing");
			cfg.useGL20 = Boolean.parseBoolean(prop.getProperty("useGL20", "true"));
			cfg.width = Integer.parseInt(prop.getProperty("screenWidth", "640"));
			cfg.height = Integer.parseInt(prop.getProperty("screenHeight", "480"));
			cfg.resizable = Boolean.parseBoolean(prop.getProperty("resizable", "false"));
			cfg.fullscreen = Boolean.parseBoolean(prop.getProperty("fullscreen", "false"));
			getSystemRes = Boolean.parseBoolean(prop.getProperty("getSystemRes", "false"));
			startupState = ProgramState.parseState(prop.getProperty("startupState", "DEFAULT"));
			defaultMenu = prop.getProperty("defaultMenu", "main");
			
		}catch(Exception ex){
			ex.printStackTrace(System.out);
			JOptionPane.showMessageDialog(null, "There seems to be some kind of disturbence at startup,\nMy guess is this has to do with the STARTUPSETTINGS.txt -file.\nFix that shit.", "ERROR", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
}
