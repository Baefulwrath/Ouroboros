package ui.menus;

import assets.AssetHandler;
import ui.Menu;

public class MENU_main extends Menu{

	public MENU_main() {
		super("Main Menu", "");
	}

	@Override
	protected void content() {
	}

	@Override
	protected void setup() {
		addButton("test test", "print_test", 100, 30, AssetHandler.basicButtonStyle);
		addButton("test test", "print_test", 100, 30, AssetHandler.basicButtonStyle);
		addTextArea("test label jskjdljdslfjsaskjdalsjdlawkjdawkmddmaksdmwkasjdw", 100, 30, AssetHandler.basicLabelStyle);
		addButton("About", "setMenu_about", 100, 30, AssetHandler.basicButtonStyle);
	}
	
}
