package ouroboros;

public enum NodeType {
	DEFAULT, ASSETHANDLER, INPUTHANDLER, RENERINGHANDLER, SCRIPTHANDLER, UIHANDLER;

    @Override
    public String toString() {
        return super.toString();
    }
    
    public static NodeType parseState(String type){
    	NodeType temp = DEFAULT;
    	for(int i = 0; i < values().length; i++){
    		if(type.equals(values()[i].toString())){
    			temp = values()[i];
    		}
    	}
    	return temp;
    }
}