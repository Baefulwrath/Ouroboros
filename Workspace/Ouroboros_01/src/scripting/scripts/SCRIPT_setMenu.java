package scripting.scripts;

import scripting.Script;
import scripting.ScriptHandler;

public class SCRIPT_setMenu extends Script{

	@Override
	public void activate(String line) {
		ScriptHandler.addLine("print_UNAVAILABLE");
	}

}
