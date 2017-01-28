/*
 * Nicholas Guida
 * MemoryBlock.java
 * Jan 27, 2017
 * 
 * The aggregate class. Has a few variables for its name and what it holds. Also has a variable to hold the data that is to be
 * held by the component, along with the size of that memory to compare it with the max size the component can hold.
 * 
 */


public class MemoryBlock {
	
	private String name;
	private String fileType;
	private int size;
	private String data;

	//Create memory via user input
    public MemoryBlock(String nm, String fileClass, String info) {
    	name = nm;
    	fileType = fileClass;	
    	data = info;
    	size = data.length();
    }
    
    //Set Methods
    public void setName(String nm){
    	name = nm;
    }
    
    public void setFileType(String whatFile){
    	fileType = whatFile;
    }
    
    public void setSize(int dataSize){
    	size = dataSize;
    }
    
    public void setData(String info){
    	data = info;
    }
    
    //Get Methods
    public String getName(){
    	return name;
    }
    
    public String getFileType(){
    	return fileType;
    }
    
    public int getSize(){
    	return size;
    }
    
    public String getData(){
    	return data;
    }

    //toString, return a String of all the variables in this MemoryBlock
	public String toString(){
		String str;
		
		str = "\n- - - - - - - - - - - - - - - - - - - -"
			+ "\nMemory Name: " + name
			+ "\nMemory Filetype: " + fileType
			+ "\nMemory Size: " + size
			+ "\nMemory Held"
			+ "\n-----------\n" 
			+ data
			+ "\n- - - - - - - - - - - - - - - - - - - -";
			
			return str;
	}
    
}