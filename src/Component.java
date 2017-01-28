/*
 * Nicholas Guida
 * Jan 27th, 2017
 * Component.java
 * 
 * The actual object the array is made of. Each component has its own info
 * along with a pointer for a MemoryBlock (aggregate class).
 * It can toString() itself along with the memory, and get/set itself and the memory.
 * 
 */


public class Component {

	private String name;
	private String brand;
	private double speed;			//i.e. The Ghz of a CPU, RPM of a HDD, Mhz of RAM, etc.
	private int maxSize; 				
	private char type;				//i.e. H would represent HDD, C can represent CPU, etc,
	private MemoryBlock memory;
	
	//Default constructor
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
    
    //For when the user just wants to make a new component and create/assign memory with it
    public Component(String nm, String manufacturer, double clock, int storage, char componentType, String memName, String memType, String memData) {
		name = nm;
		brand = manufacturer;
		speed = clock;
		maxSize = storage;
		type = componentType;
		memory = new MemoryBlock(memName, memType, memData);
    }

	//Set methods
	public void setName(String nm){
		name = nm;
	}
	
	public void setBrand(String manufacturer){
		brand = manufacturer;
	}
	
	public void setSpeed(double clock){
		speed = clock;
	}
	
	public void setMaxSize(int maxData){
		maxSize = maxData;
	}
	
	public void setType(char part){
		type = part;
	}
	
	public void setMemory(MemoryBlock mem){
		memory = mem;
	}
	
	//Get methods
	public String getName(){
		return name;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public int getMaxSize(){
		return maxSize;
	}
	
	public char getType(){
		return type;
	}
	
	public MemoryBlock getMemory(){
		return memory;
	}
	
	//================FOR MEMORY=================
	//Set Methods
	public void setMemName(String memName){
    	memory.setName(memName);
    }
    
    public void setMemFileType(String memFileType){
    	memory.setFileType(memFileType);
    }
    
    public void setMemSize(int memSize){
    	memory.setSize(memSize);
    }
    
    public void setMemData(String memData){
    	memory.setData(memData);
    }
	
	//Get Methods
	public String getMemName(){
    	return memory.getName();
    }
    
    public String getMemFileType(){
    	return memory.getFileType();
    }
    
    public int getMemSize(){
    	return memory.getSize();
    }
    
    public String getMemData(){
    	return memory.getData();
    }

 
	public String toString(){
		String str;
		
		str = "\n************************************"
			+ "\nComponent Name: " + name
			+ "\nCompnent Brand: " + brand
			+ "\nComponent Speed: " + speed
			+ "\nComponent Max Size: " + maxSize
			+ "\nComponent Type: " + type;
			
			if(memory != null)
				str += "\n" + memory.toString();
			else
				str += "\nNo Memory\n";
			
			str += "\n************************************";
			
			return str;
	}
	
}