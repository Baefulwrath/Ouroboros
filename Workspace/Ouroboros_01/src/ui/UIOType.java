package ui;


public enum UIOType {
	DEFAULT, MENU, HUD;
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    public static UIOType parseState(String state){
    	UIOType temp = DEFAULT;
    	for(int i = 0; i < values().length; i++){
    		if(state.equals(values()[i].toString())){
    			temp = values()[i];
    		}
    	}
    	return temp;
    }
}
