package ouroboros;

import java.util.HashMap;

import ouroboros.modes.*;

import rendering.RenderingHandler;

import assets.AssetHandler;

import com.badlogic.gdx.ApplicationListener;

import static ouroboros.ProgramState.*;

public class OS implements ApplicationListener {
	public static ProgramState state = DEFAULT;
	public static HashMap<ProgramState, ProgramMode> modes = new HashMap<ProgramState, ProgramMode>();
	public static boolean paused = false;
	public static boolean exitProgram = false;
	
	public OS(ProgramState startupState){
    	state = startupState;
    }
	
	@Override
	public void create() {
		RenderingHandler.setup();
		AssetHandler.setup();
		setupModes();
	}
	
	public void setupModes(){
		modes.put(DEFAULT, new MODE_DEFAULT(DEFAULT));
		modes.put(MENU, new MODE_MENU(MENU));
		modes.put(GAME, new MODE_GAME(GAME));
		modes.put(EDITOR, new MODE_EDITOR(EDITOR));
	}

	@Override
	public void dispose() {
		RenderingHandler.dispose();
		AssetHandler.dispose();
	}

//A better name for this method would be "update" but you can blame LibGdx for this one.
	@Override
	public void render(){
		if(exitProgram){
			exit();
		}else{
			try{
				Thread.sleep(1);
				updateSpecific();
				updateGeneral();
			}catch(Exception ex){
				ex.printStackTrace(System.out);
			}
		}
	}
	
	public void updateSpecific(){
		switch(state){
			case DEFAULT:
				modes.get(DEFAULT).update();
				break;
			case MENU:
				modes.get(MENU).update();
				break;
			case EDITOR:
				modes.get(EDITOR).update();
				break;
			case GAME:
				modes.get(GAME).update();
				break;
		}
	}
	
	public void updateGeneral(){
		RenderingHandler.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	public static void changeState(ProgramState s){
		state = s;
	}
	
	public static void changeState(String s){
		state = ProgramState.parseState(s);
	}
	
	public void exit(){
		dispose();
		System.exit(0);
	}
}
