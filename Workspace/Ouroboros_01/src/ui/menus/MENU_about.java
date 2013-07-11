package ui.menus;

import assets.AssetHandler;
import ui.Menu;

public class MENU_about extends Menu{

	public MENU_about() {
		super("About", "");
	}

	@Override
	protected void content() {
	}

	@Override
	protected void setup() {
		addButton("We need to make a way to view text in menus...", "print_Do eeeet!", 100, 30, AssetHandler.basicButtonStyle);
		addButton("Back", "setMenu_main", 100, 30, AssetHandler.basicButtonStyle);
	}
	
}
