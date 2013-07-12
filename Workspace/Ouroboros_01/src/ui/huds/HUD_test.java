package ui.huds;

import assets.AssetHandler;
import ui.Hud;

public class HUD_test extends Hud{

	public HUD_test() {
		super("Test Hud", "print_testHudScript", 0, 0, 100, 50, new String[]{"test"});
	}

	@Override
	protected void content() {
	}

	@Override
	protected void setup() {
		addNinePatch(AssetHandler.basicHud, BOX.x, BOX.y, BOX.width, BOX.height);
		addButton("test button", "print_yeah!", 0, 0, 100, 40, AssetHandler.basicButtonStyle);
	}

}
