/*
 * Nicholas Guida
 * ComponentDB.java
 * Jan 27, 2017
 * 
 * This class is the "Component Database", it holds my Component array. It provides the strings to list the array, and some
 * other methods such as nextFree() and nextNotNullAfterIndex() to provide some stats on the array.
 */


public class ComponentDB {
	
	//Make the array
	public Component[] motherboard;

    public ComponentDB() {
    	motherboard = new Component[10];
    }
    
    //Find the next available null space in the motherboard and put the component in
    	//Make just the component
    public void addComponent(String compName, String compBrand, double compSpeed, int compMaxSize, char compType){
		motherboard[nextFree()] = new Component(compName, compBrand, compSpeed, compMaxSize, compType);
	}

    	//Make component and the memory with it
	public void addComponent(String compName, String compBrand, double compSpeed, int compMaxSize, char compType, String memName, String memFileType, String memData){
		motherboard[nextFree()] = new Component(compName, compBrand, compSpeed, compMaxSize, compType, memName, memFileType, memData);
	}
	
	//Create a new component at a specific index
	public void addComponent(int index, String compName, String compBrand, double compSpeed, int compMaxSize, char compType, String memName, String memFileType, String memData){
		motherboard[index] = new Component(compName, compBrand, compSpeed, compMaxSize, compType, memName, memFileType, memData);
	}
	
	//Return the next available null space in the array, if none, return -1 which will give a distinctive "out of bounds" error if there is a bug
	public int nextFree(){
	    for(int i = 0; i < motherboard.length; i++){
	    	if(motherboard[i] == null)		//Test each part of the array if it is null and return the index when it finds one
	    		return i;
	   	}
	    
	   	//all else fails
	   	return -1;
    }
    
	//Return a String of a summary of the contents of the array
    public String listAll(){
    	String str = "";
    	
    	//Return "No Components" when there are no components, rather than a blank String.
    	for(int i = 0; i < motherboard.length; i++){
    		if(motherboard[i] != null)
    			break;
    		else if(i+1 == motherboard.length)
    			return "No components";
    	}
    	
    	//Add the info of a component to the String when it finds one
    	for(int i = 0; i < motherboard.length; i++){
    		
    		//Access the component's memory if it has it
    		if(motherboard[i] != null && motherboard[i].getMemory() != null){
    			str += (i + 1) + ": " + motherboard[i].getName() + "---" + motherboard[i].getMemSize()+ "/" + motherboard[i].getMaxSize() + " bytes---Holds: " + motherboard[i].getMemName();
    			str += "\n";
    			
    		//Don't access the component's memory if it has none (prevents null pointer exceptions)
    		}else if(motherboard[i] != null && motherboard[i].getMemory() == null){
    			str += (i + 1) + ": " + motherboard[i].getName() + "---0/" + motherboard[i].getMaxSize() + " bytes---Empty";
    			str += "\n";
    		}
    	}
    	
    	return str;
    }
    
    //Kind of like the opposite of nextFree(). Finds the next full index that is after the given index number. Used for the Bubble Sort.
    public int nextNotNullAfterIndex(int index){
    	for(int i = index + 1; i < motherboard.length; i++){
    		if(motherboard[i] != null)
    			return i;
    	}
    	
    	return index;
    }
    
    //The toString(), creates a string of all the data in the all components. "No Components" is returned if there are no components.
	public String toString(){
		
		String str = "";
		
		for(int i = 0; i < motherboard.length; i++){
			if(motherboard[i] != null && motherboard[i].getMemory() != null)
				str += "\n\n-----------" + (i+1) + "------------\n" + motherboard[i].toString();
			else if(motherboard[i] != null && motherboard[i].getMemory() == null)
				str += "\n\n-----------" + (i+1) + "------------\n" + motherboard[i].toString();
		}
		
		if(str.equals(""))	//If no components were found, say so
			str = "No Components";
		
		return str;
	}
}