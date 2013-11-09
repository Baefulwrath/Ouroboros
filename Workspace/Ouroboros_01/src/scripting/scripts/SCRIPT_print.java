package scripting.scripts;

import scripting.Script;

public class SCRIPT_print extends Script{

	@Override
	public void activate(String line) {
		System.out.println(line);
	}

}
