/**
 * @(#)MemoryBlock.java
 *
 *
 * @author 
 * @version 1.00 2017/1/18
 */


public class MemoryBlock {
	
	private String name;
	private String fileType;
	private int size;
	private String data;

    public MemoryBlock(String nm, String fileClass, String info) {
    	name = nm;
    	fileType = fileClass;	
    	data = info;
    	size = data.length();
    }
    
    //set
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
    
    //get
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