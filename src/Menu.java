/*
 * Nicholas Guida
 * Jan 23
 *
 */
 
 
import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	boolean exit = false;
	ComponentDB cDB = new ComponentDB();
	
	public void mainMenu(){
		int choice;
		this.clearScreen();
		//============================================================================================================	   _
		//=----------------------------------------------------------------------------------------------------------=	  //
		//=|								Output menu																|=	 //
		//=|	Needs: toString() one, delete component, delete memory, Edit component, Edit memory1				|=	/-------------------------|
		//=|	Ask if array needs to be private, and if components in array/their aggregates need to be edited.	|=	\-------------------------|
		//=----------------------------------------------------------------------------------------------------------=	 \\
		//============================================================================================================	  \\
		System.out.println("================================================");//										   -								
		System.out.println("              ~Main Menu~                		");
		System.out.println("------------------------------------------------");
		System.out.println("1: Create component  							");
		System.out.println("2: Create memory and assign it to a component	");
		System.out.println("3: toString() all								");
		System.out.println("4: List all										");
		System.out.println("5: List one										");
		System.out.println("6: Exit											");
		System.out.println("================================================");
		
		//get choice
		choice = getChoice(6);
			
		//move on
		if(choice == 1)
			createComponentMenu();
		else if(choice == 2)
			createMemory();
		else if(choice == 3){
			System.out.println(cDB.toString());
			System.out.print("Press enter to continue");
			input.nextLine();
		}else if(choice == 4){
			System.out.println(cDB.listAll() + "\nPress enter to continue");
			input.nextLine();
		}else if(choice == 5){
			int i;
			
			System.out.print("Which index? (Starting from 1)\n");
			i = getChoice(cDB.motherboard.length)- 1;
			
			if(cDB.motherboard[i] != null && cDB.motherboard[i].getMemory() != null)
    			System.out.println((i + 1) + ": " + cDB.motherboard[i].getName() + "---" + cDB.motherboard[i].getMemSize()+ " bytes---Holds: " + cDB.motherboard[i].getMemName());
    		else if(cDB.motherboard[i] != null && cDB.motherboard[i].getMemory() == null)
    			System.out.println((i + 1) + ": " + cDB.motherboard[i].getName() + "---0/" + cDB.motherboard[i].getMaxSize() + " bytes---Empty");
    		else
    			System.out.println("Empty");
			
			System.out.print("Press enter to continue");
			input.nextLine();
		}else if(choice == 6)
			exit = true;
	}

	public void createComponentMenu(){
		int choice;
		clearScreen();
		
		System.out.println("=========================================");
		System.out.println("         ~Create a component~");
		System.out.println("-----------------------------------------");
		System.out.println("1: Create just component");
		System.out.println("2: Create component and create memory with it");
		System.out.println("=========================================");
		
		//get choice and check
		choice = getChoice(3);
		
		//move on	
		if(choice == 1)
			createComponent();
		if(choice == 2)
			createComponentAndMem();
		if(choice == 3){}
	}

	public void createComponent(){
		String compName;
		String compBrand;
		double compSpeed;			//In Mhz or Ghz, depending on the memory type
		int compMaxSize; 				
		char compType;				//Hdd, Cpu, Gpu, Ram, Ssd
		
		System.out.print("Name: ");
		compName = input.nextLine();
		
		System.out.print("Brand: ");
		compBrand = input.nextLine();
		
		System.out.print("Max memory size (int): ");
		compMaxSize = input.nextInt();
		
		System.out.print("Type of component (char): ");
		compType = input.next(".").charAt(0);
		
		System.out.print("Clock Speed (double, 0 or less to cancel): ");
		compSpeed = input.nextDouble();
		
		if(compSpeed > 0)
			cDB.addComponent(compName, compBrand, compSpeed, compMaxSize, compType);
	}

	public void createComponentAndMem(){
		String compName;
		String compBrand;
		double compSpeed;			//In Mhz or Ghz, depending on the memory type
		int compMaxSize; 				
		char compType;				//Hdd, Cpu, Gpu, Ram, Ssd
		String memName;
		String memFileType;
		String memData;
		
		System.out.print("Name: ");
		compName = input.nextLine();
		
		System.out.print("Brand: ");
		compBrand = input.nextLine();
		
		System.out.print("Max memory size (int): ");
		compMaxSize = input.nextInt();
		
		System.out.print("Type of component (char): ");
		compType = input.next(".").charAt(0);
		
		System.out.print("Clock Speed (double, 0 or less to cancel): ");
		compSpeed = input.nextDouble();
		input.nextLine();
		
		if (compSpeed > 0) {
			System.out.print("Memory name (String): ");
			memName = input.nextLine();
			System.out.print("File Type (String): ");
			memFileType = input.nextLine();
			//Check if data being entered into the component is small enough
			do {
				System.out.println("Enter data that is <= " + compMaxSize + " bytes, or \"cancel\" to cancel: ");

				if (memFileType.equalsIgnoreCase("Image"))
					memData = getImage();
				else
					memData = input.nextLine();

				if (memData.length() <= compMaxSize)
					cDB.addComponent(compName, compBrand, compSpeed, compMaxSize, compType, memName, memFileType,
							memData);
				//else
				//System.out.println("Enter data that is less than " + compMaxSize + " bytes: ");
			} while (memData.length() > compMaxSize && !memData.equalsIgnoreCase("cancel"));
		}
	}

	public void createMemory(){
		
		String memName;
		String memFileType;
		String memData;
		MemoryBlock memTemp;
		
		int componentNum = -1;
		
		if (cDB.listAll()!="") {
			System.out.println(cDB.listAll() + "\n-----------------------------\n" + "Which component will this memory be stored in?");
			//componentNum = getChoice(cDB.getLength());
			componentNum = getChoice(cDB.motherboard.length);
			System.out.print("Memory name (String): ");
			memName = input.nextLine();
			System.out.print("File Type (String): ");
			memFileType = input.nextLine();
			
			
			do{
				System.out.println("Enter data that is <=" + cDB.motherboard[componentNum-1].getMaxSize() + " bytes, or \"cancel\" to cancel: ");
				
				if (memFileType.equalsIgnoreCase("Image"))
					memData = getImage();
				else
					memData = input.nextLine();
				
				if(memData.length() <= cDB.motherboard[componentNum - 1].getMaxSize()){
					memTemp = new MemoryBlock(memName, memFileType, memData);
					cDB.motherboard[componentNum - 1].setMemory(memTemp);
				}
				//else
					//System.out.println("Enter data that is less than " + compMaxSize + " bytes: ");
			}while (memData.length() > cDB.motherboard[componentNum - 1].getMaxSize() && !memData.equalsIgnoreCase("cancel"));
			
			
	//		if (memFileType.equalsIgnoreCase("Image"))
	//			memData = getImage();
	//		else {
	//			System.out.print("Enter the data you wish to store: ");
	//			memData = input.nextLine();
	//		}
			
			
			//cDB.setMemory(memTemp, componentNum-1);
		}else{
			System.out.println("Add a component first. Press enter to continue.");
			input.nextLine();
		}	
	}

	public int getChoice(int max){
    	int choice;
    	
    	do{
	  		System.out.print("Enter digit of selection: ");
	  		choice = input.nextInt();
	  		
	  		if(!(choice >= 1 && choice <= max))
	  			System.out.println("Please enter a valid entry");
  		}while(!(choice >= 1 && choice <= max));
  		
    	input.nextLine();
  		return choice;
    }
	
  	public String getImage(){
		String str = "", user = "";
		
		for(int i = 1; !user.equalsIgnoreCase("stop"); i++){
			str += "\n" + user;
			System.out.print("Line " + i + ": ");
			user = input.nextLine();
		}
		
		return str;
    }
    
    public boolean getExit(){
    	return exit;
    }
    
    public void setExit(boolean leave){
		exit = leave;
	}

	public String listAll(){
    	String str = cDB.listAll();
    	return str;
    }

	public void clearScreen(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
