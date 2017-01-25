/**
 * @(#)Component.java
 *
 *
 * @author 
 * @version 1.00 2017/1/18
 */


public class Component {

	private String name;
	private String brand;
	private double speed;			//In Mhz or Ghz, depending on the memory type
	private int maxSize; 				
	private char type;				//Hdd, Cpu, Gpu, Ram, Ssd
	private MemoryBlock memory;
	
    public Component() {
		name = "";
		brand = "";
		speed = 0;
		maxSize = 0;
		type = ' ';
		memory = null;
    }
    
    //For when the user just wants to make a new component but not assign it memory yet.
    public Component(String nm, String manufacturer, int clock, char componentType) {
		name = "";
		brand = "";
		speed = 0;
		maxSize = 0;
		type = ' ';
		memory = null;
    }
    
    //For when the user just wants to make a new component and assign a memory block to it
    public Component(String nm, String manufacturer, int clock, char componentType, MemoryBlock block) {
		name = "";
		brand = "";
		speed = 0;
		maxSize = 0;
		type = ' ';
		memory = block;
    }
    
    //For when the user just wants to make a new component and create/assign memory to it
    public Component(String nm, String manufacturer, int clock, char componentType, String memName, String memType, int memSize, String memData) {
		name = "";
		brand = "";
		speed = 0;
		maxSize = 0;
		type = ' ';
		memory = new MemoryBlock(memName, memType, memSize, memData);
    }
}