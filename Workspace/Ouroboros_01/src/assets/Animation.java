package assets;

public abstract class Animation {
	
	private long last = 0;
	private int interval = 5;
	
	public abstract void update();
	
	protected boolean readytoUpdate(){
		boolean temp = false;
    	if(last + interval <= System.currentTimeMillis()){
    		temp = true;
    		last = System.currentTimeMillis();
    	}
    	return temp;
	}
}
