package scripting.scripts;

import master.Master;
import scripting.Script;

public class SCRIPT_setState extends Script{

	@Override
	public void activate(String line) {
		Master.changeState(line);
	}

}
