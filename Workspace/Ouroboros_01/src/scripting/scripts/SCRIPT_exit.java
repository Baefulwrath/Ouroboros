package scripting.scripts;

import master.Master;
import scripting.Script;

public class SCRIPT_exit extends Script{

	@Override
	public void activate(String line) {
		Master.exitProgram = true;
	}

}
