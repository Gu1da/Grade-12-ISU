
/**
 * @(#)ComponentDB.jav a
 *
 *
 * @author 
 * @version 1.00 2017/1/19
 */


public class ComponentDB {

	private Component[] motherboard;	//Later add user input spots

    public ComponentDB() {
    	motherboard = new Component[10];
    }
    
    public int nextFree(){
	    for(int i = 0; i < motherboard.length; i++){
	    	if(motherboard[i] == null)
	    		return i;
	    	if(i == motherboard.length)
	    		return -1;
	   	}
	   	
	   	//all else fails
	   	return -2;
    }
    
    public void addComponent(String compName, String compBrand, double compSpeed, int compMaxSize, char compType){
    	motherboard[nextFree()] = new Component(compName, compBrand, compSpeed, compMaxSize, compType);
    }
    
}