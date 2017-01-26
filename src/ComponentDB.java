
/**
 * @(#)ComponentDB.jav a
 *
 *
 * @author 
 * @version 1.00 2017/1/19
 */


public class ComponentDB {

	public Component[] motherboard;	//Later add user input spots

    public ComponentDB() {
    	motherboard = new Component[10];
    }
    
    public void addComponent(String compName, String compBrand, double compSpeed, int compMaxSize, char compType){
		motherboard[nextFree()] = new Component(compName, compBrand, compSpeed, compMaxSize, compType);
	}

	public void addComponent(String compName, String compBrand, double compSpeed, int compMaxSize, char compType, String memName, String memFileType, String memData){
		motherboard[nextFree()] = new Component(compName, compBrand, compSpeed, compMaxSize, compType, memName, memFileType, memData);
	}

	/*
	public void setMemory(MemoryBlock mem, int index){
		motherboard[index].setMemory(mem);
	}
	*/
	
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
    
    public String listAll(){
    	String str = "";
    	
    	if(motherboard.length == 0)
    		return "No Components";
    	
    	for(int i = 0; i < motherboard.length; i++){
    		if(motherboard[i] != null && motherboard[i].getMemory() != null)
    			str += (i + 1) + ": " + motherboard[i].getName() + "	" + motherboard[i].getMemSize()+ " bytes";
    		else if(motherboard[i] != null && motherboard[i].getMemory() == null)
    			str += (i + 1) + ": " + motherboard[i].getName() + "	0/" + motherboard[i].getMaxSize() + " bytes";
    	}
    	
    	return str;
    }
    
    public String list(int i){
    	return motherboard[i].toString();
	}
    
    /*
    public int getLength(){
    	return motherboard.length;
    }
	*/
    
	public String toString(){
		
		String str = "";
		
		for(int i = 0; i < motherboard.length; i++){
			if(motherboard[i] != null && motherboard[i].getMemory() != null)
				str += "-----------" + (i+1) + "------------\n" + motherboard[i].toString();
			else if(motherboard[i] != null && motherboard[i].getMemory() == null)
				str += "-----------" + (i+1) + "------------\n" + motherboard[i].toString();
		}
		
		return str;
	}
}