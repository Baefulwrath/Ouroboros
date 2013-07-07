package ouroboros;

import rendering.RenderingHandler;

import assets.AssetHandler;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

import static com.badlogic.gdx.Gdx.*;

public class OS implements ApplicationListener {
	public static ProgramState state = ProgramState.DEFAULT;
	public static boolean paused = false;
	public static boolean exitProgram = false;
	
	public OS(ProgramState startupState){
    	state = startupState;
    }
	
	@Override
	public void create() {
		RenderingHandler.setup();
		AssetHandler.setup();
	}

	@Override
	public void dispose() {
		RenderingHandler.dispose();
		AssetHandler.dispose();
	}

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
				break;
			case MENU:
				break;
			case EDITOR:
				break;
			case GAME:
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
