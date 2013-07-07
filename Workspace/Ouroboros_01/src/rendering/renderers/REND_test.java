package rendering.renderers;

import rendering.Renderer;
import rendering.RenderingHandler;

public class REND_test extends Renderer{

	public REND_test(){
		ID = "test";
	}

	@Override
	public void loadSpecificResources() {
	}

	@Override
	public void mobileRender() {
	}

	@Override
	public void staticRender() {
		drawImage(RenderingHandler.testImg, RenderingHandler.getScreenX(), RenderingHandler.getScreenY(), RenderingHandler.w, RenderingHandler.h);
	}
	
}
