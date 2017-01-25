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
    public Component(String nm, String manufacturer, double clock, int storage, char componentType) {
		name = nm;
		brand = manufacturer;
		speed = clock;
		maxSize = storage;
		type = componentType;
		memory = null;
    }
    
    //For when the user just wants to make a new component and assign a memory block to it
    public Component(String nm, String manufacturer, double clock, int storage, char componentType, MemoryBlock block) {
		name = nm;
		brand = manufacturer;
		speed = clock;
		maxSize = storage;
		type = componentType;
		memory = block;
    }
    
    //For when the user just wants to make a new component and create/assign memory with it
    public Component(String nm, String manufacturer, double clock, int storage, char componentType, String memName, String memType, int memSize, String memData) {
		name = nm;
		brand = manufacturer;
		speed = clock;
		maxSize = storage;
		type = componentType;
		memory = new MemoryBlock(memName, memType, memSize, memData);
    }
}