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

    public MemoryBlock(String nm, String fileClass, int bytes, String info) {
    	name = nm;
    	fileType = fileClass;
    	size = bytes;	
    	data = info;
    }
    
    
}