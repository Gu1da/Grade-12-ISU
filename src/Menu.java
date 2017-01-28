/*
 * Nicholas Guida
 * Jan 27, 2017
 * Menu.java
 *
 * Menu System for the program. Contains the methods to output the different menus.
 * Holds object cDB which is the component database class, this class contains the actual array
 *
 */
 
 import java.util.Scanner;
 
//The main menu to the program
public class Menu {
	Scanner input = new Scanner(System.in);
	boolean exit = false;
	ComponentDB cDB = new ComponentDB();
	
	public Menu(){
		
	}
	
	public void mainMenu(){
		int choice;
		this.clearScreen();

		System.out.println("================================================");									   	 	   								
		System.out.println("              ~Main Menu~                		");
		System.out.println("------------------------------------------------");
		System.out.println("1: Create component  							");
		System.out.println("2: Create memory and assign it to a component	");
		System.out.println("3: toString() all								");
		System.out.println("4: toString() specific component				");
		System.out.println("5: List all										");
		System.out.println("6: List one										");
		System.out.println("7: Edit component								");
		System.out.println("8: Remove component								");
		System.out.println("9: Remove memory								");
		System.out.println("10: Sort components by max size					");
		System.out.println("11: Exit										");
		System.out.println("================================================");
		
		//get choice
		choice = getChoice(11);
			
		//move on
		if(choice == 1)
			createComponentMenu();
			
		else if(choice == 2)
			createMemory();
			
		else if(choice == 3){
			
			System.out.println(cDB.toString());
			
			System.out.print("Press enter to continue");	//Allow the user to see the output
			input.nextLine();								//
			
		}else if(choice == 4){
			
			int componentNum;
						
			if (cDB.listAll()!="No components") {
				System.out.println(cDB.listAll() + "\n-----------------------------\n" + "Which component will be toString()'ed?\n");
				
				//Get the choice of the user, and if it's good activate toString() for that component
				do{
					componentNum = getChoice(cDB.motherboard.length);
					if(cDB.motherboard[componentNum-1] == null){
						System.out.print("Please choose a number from the above list\n");
					}else{
						System.out.println(cDB.motherboard[componentNum-1].toString());
						System.out.print("\nPress enter to continue");
						input.nextLine();
					}
				
				}while(cDB.motherboard[componentNum-1] == null);	//Keep trying until the user enters an index containing a component
				
			}else{
				//Tell the user they can't toString() anything when there is nothing to toString()
				System.out.print("No components -- Make one first");
				System.out.print("\nPress enter to continue");
				input.nextLine();
			}
			
		}else if(choice == 5){
			//List all components/their info and allow the user to see it
			System.out.println(cDB.listAll() + "\nPress enter to continue");
			input.nextLine();
			
		//List the info to a specific index
		}else if(choice == 6){
			int i;
			
			System.out.print("Which index? (Starting from 1)\n");
			i = getChoice(cDB.motherboard.length)- 1;
			
			//Prevent null pointers if the component being listed has no memory
			if(cDB.motherboard[i] != null && cDB.motherboard[i].getMemory() != null)
    			System.out.println((i + 1) + ": " + cDB.motherboard[i].getName() + "---" + cDB.motherboard[i].getMemSize()+ " bytes---Holds: " + cDB.motherboard[i].getMemName());
    		else if(cDB.motherboard[i] != null && cDB.motherboard[i].getMemory() == null)
    			System.out.println((i + 1) + ": " + cDB.motherboard[i].getName() + "---0/" + cDB.motherboard[i].getMaxSize() + " bytes---Empty");
    		else
    			System.out.println("Empty");
			
			System.out.print("Press enter to continue");
			input.nextLine();
			
		}else if(choice == 7){
			editComponentMenu();
		
		}else if(choice == 8){
			removeComponent();
		
		}else if(choice == 9){
			removeMemory();
		
		}else if(choice == 10){
			//Sort and let the user know
			
			bubbleSort(cDB.motherboard);
			System.out.println("Done! Press enter to continue");
			input.nextLine();
		
		}else if(choice == 11)
			//Quit the program
			
			exit = true;
	}

	//Output menu for the user to choose how to create the component, and move on appropriately
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
		choice = getChoice(2);
		
		//move on	
		if(choice == 1)
			createComponent();
		if(choice == 2)
			createComponentAndMem();
	}
	
	//Create just the component as long as there is room
	public void createComponent(){
		if (cDB.nextFree() != -1) {	//check if there is a free slot
			String compName;
			String compBrand;
			double compSpeed;
			int compMaxSize;
			char compType;
			
			System.out.print("Name: ");
			compName = input.nextLine();
			System.out.print("Brand: ");
			compBrand = input.nextLine();
			
			//Ask user for the size of memory the component can hold, and ensure it is greater than 0
			do{
				System.out.print(
						"Max memory size (int > 0)\nNote... newline characters (image filetype) take up bytes: ");
				compMaxSize = input.nextInt();
			}while (!(compMaxSize > 0));
			
			System.out.print("Type of component (char): ");
			compType = input.next(".").charAt(0);
			
			System.out.print("Clock Speed (double, 0 or less to cancel): ");
			compSpeed = input.nextDouble();
			
			if (compSpeed > 0)
				cDB.addComponent(compName, compBrand, compSpeed, compMaxSize, compType);
			
		}else {
			System.out.println("Out of room, remove components! Press enter to continue...");
			input.nextLine();
		}
	}

	//Get the new component's info from the user along with the memory's info
	public void createComponentAndMem(){
		if (cDB.nextFree() != -1) {
			String compName;
			String compBrand;
			double compSpeed;
			int compMaxSize;
			char compType;
			String memName;
			String memFileType;
			String memData;
			
			System.out.print("Name: ");
			compName = input.nextLine();
			
			System.out.print("Brand: ");
			compBrand = input.nextLine();
			
			do{
				System.out.print(
						"Max memory size (int > 0)\nNote... newline characters (image filetype) take up bytes: ");
				compMaxSize = input.nextInt();
			}while (!(compMaxSize > 0));
			
			System.out.print("Type of component (char): ");
			compType = input.next(".").charAt(0);
			
			System.out.print("Clock Speed (double, 0 or less to cancel): ");
			compSpeed = input.nextDouble();
			
			input.nextLine();
			if (compSpeed > 0){
				System.out.print("Memory name (String): ");
				memName = input.nextLine();
				System.out.print("File Type (String): ");
				memFileType = input.nextLine();
				
				//Check if data being entered into the component is small enough
				do{
					System.out.println("Enter data that is <= " + compMaxSize + " bytes, or \"cancel\" to cancel: ");

					if (memFileType.equalsIgnoreCase("Image"))
						memData = getImage();
					else
						memData = input.nextLine();

					if (memData.length() <= compMaxSize)
						cDB.addComponent(compName, compBrand, compSpeed, compMaxSize, compType, memName, memFileType,
								memData);
					
				}while(memData.length() > compMaxSize && !memData.equalsIgnoreCase("cancel"));
			} 
		}else{
			System.out.println("Out of room, remove components! Press enter to continue...");
			input.nextLine();
		}
	}

	//Make just a memory block but it must be assigned to a component
	public void createMemory(){
		
		String memName;
		String memFileType;
		String memData;
		MemoryBlock memTemp;
		
		int componentNum = -1;
		
		if (cDB.listAll()!="No components") {
			System.out.println(cDB.listAll() + "\n-----------------------------\n" + "Which component will this memory be stored in?");
			
			do{
				componentNum = getChoice(cDB.motherboard.length);
				if(cDB.motherboard[componentNum-1] == null){
					System.out.print("Please choose a number from the above list: ");
				}else{
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
				}
				
			}while(cDB.motherboard[componentNum-1] == null);

		}else{
			System.out.println("Add a component first. Press enter to continue.");
			input.nextLine();
		}	
	}

	//Output the menu for when the user wants to edit a component and perform the operations
	public void editComponentMenu(){

		int componentNum;
					
		if (cDB.listAll()!="No components") {
			System.out.println(cDB.listAll() + "\n-----------------------------\n" + "Which component will be edited?\n");

			do{
				componentNum = getChoice(cDB.motherboard.length);
				if(cDB.motherboard[componentNum-1] == null){
					System.out.print("Please choose a number from the above list\n");
				}else{
					System.out.println(cDB.motherboard[componentNum-1].toString());
					
					//Show options to edit memory only if the component has it
					if (cDB.motherboard[componentNum-1].getMemory() != null) {
						editComponent(componentNum);
					}else if(cDB.motherboard[componentNum-1].getMemory() == null)
						editComponentNoMem(componentNum);
				}
			}while(cDB.motherboard[componentNum-1] == null);
			
		}else {
			System.out.print("No components -- Make one first");
			System.out.print("\nPress enter to continue");
			input.nextLine();
		}
	}
	
	//Get the part of the component or its memory that the user wishes to edit, and change it
	public void editComponent(int index){
		int choice;
		System.out.println("Edit what value?		");
		System.out.println("1: Component Name		");
		System.out.println("2: Component Brand		");
		System.out.println("3: Component Speed		");
		System.out.println("4: Component Max Size	");
		System.out.println("5: Component Type		");
		System.out.println("6: Memory Name			");
		System.out.println("7: Memory File Type		");
		System.out.println("8: Memory Data			");
		
		choice = getChoice(8);
		
		if(choice == 1){
			System.out.print("New name: ");
			String nm = input.nextLine();
			cDB.motherboard[index-1].setName(nm);
		
		}else if(choice == 2){
			System.out.print("New brand: ");
			String manufacturer = input.nextLine();
			cDB.motherboard[index-1].setBrand(manufacturer);
		
		}else if(choice == 3){
			System.out.print("New speed: ");
			int spd = input.nextInt();
			cDB.motherboard[index-1].setSpeed(spd);
		
		}else if(choice == 4){
			
			int maxSize;
			do{
				System.out.println("New size (cannot be <" + cDB.motherboard[index-1].getMemSize() + " bytes, or change memory first. Negative to cancel:");
				maxSize = input.nextInt();
				
				if(maxSize < 0)
					break;
				else if(!(maxSize < cDB.motherboard[index - 1].getMemSize()))
					cDB.motherboard[index - 1].setMaxSize(maxSize);
			}while (maxSize < cDB.motherboard[index-1].getMemSize());
			
		}else if(choice == 5){
			System.out.print("New type: ");
			char whatComponent = input.next(".").charAt(0);
			cDB.motherboard[index-1].setType(whatComponent);
		
		}else if(choice == 6){
			System.out.print("New memory name: ");
			String nm = input.nextLine();
			cDB.motherboard[index-1].setMemName(nm);
		
		}else if(choice == 7){
			System.out.print("New memory file type: ");
			String whatMemory = input.nextLine();
			cDB.motherboard[index-1].setMemFileType(whatMemory);
		
		}else if(choice == 8){
			String memFileType;
			String memData;
			System.out.print("File Type (String): ");
			memFileType = input.nextLine();
			
			//Check if data being entered into the component is small enough to fit
			do {
				System.out.println("Enter data that is <= " + cDB.motherboard[index-1].getMaxSize() + " bytes, or \"cancel\" to cancel: ");

				if (memFileType.equalsIgnoreCase("Image"))
					memData = getImage();
				else
					memData = input.nextLine();

				if (memData.length() <= cDB.motherboard[index-1].getMaxSize() && !(memData.equalsIgnoreCase("cancel")))
					cDB.addComponent(index-1, cDB.motherboard[index-1].getName(), cDB.motherboard[index-1].getBrand(), cDB.motherboard[index-1].getSpeed(), cDB.motherboard[index-1].getMaxSize(), cDB.motherboard[index-1].getType(),
							cDB.motherboard[index-1].getMemName(), memFileType, memData);
			}while(memData.length() > cDB.motherboard[index-1].getMaxSize() && !memData.equalsIgnoreCase("cancel"));
		}
	}
	
	//Same as above method, but excludes the options to edit the memory since it has none
	public void editComponentNoMem(int index){
		int choice;
		System.out.println("Edit what value?		");
		System.out.println("1: Component Name		");
		System.out.println("2: Component Brand		");
		System.out.println("3: Component Speed		");
		System.out.println("4: Component Max Size	");
		System.out.println("5: Component Type		");
		
		choice = getChoice(5);
		
		//Change the appropriate variable in the component
		if(choice == 1){
			System.out.print("New name: ");
			String nm = input.nextLine();
			
			cDB.motherboard[index-1].setName(nm);
		}else if(choice == 2){
			System.out.print("New brand: ");
			String manufacturer = input.nextLine();
			
			cDB.motherboard[index-1].setBrand(manufacturer);
		}else if(choice == 3){
			System.out.print("New speed: ");
			int spd = input.nextInt();
			
			cDB.motherboard[index-1].setSpeed(spd);
		}else if(choice == 4){
			
			//Only change the size to something bigger than the memory within it
			int maxSize;
			do{
				System.out.println("New size (cannot be <" + cDB.motherboard[index-1].getMemSize() + " bytes, or change memory first. Negative to cancel:");
				maxSize = input.nextInt();
				
				if(maxSize < 0)
					break;
				else if(!(maxSize < cDB.motherboard[index - 1].getMemSize()))
					cDB.motherboard[index - 1].setMaxSize(maxSize);
			}while (maxSize < cDB.motherboard[index-1].getMemSize());
			
		}else if(choice == 5){
			System.out.print("New type: ");
			char whatComponent = input.next(".").charAt(0);
			cDB.motherboard[index-1].setType(whatComponent);
		}
	}
	
	//Ask the user what component to remove and removes it
	public void removeComponent(){
		int choice;
		
		System.out.println(cDB.listAll());
		
		do {
			System.out.println("Which component to remove?");
			choice = getChoice(cDB.motherboard.length);
			
			if(cDB.motherboard[choice-1] == null)
				System.out.println("Select a number shown above");	
			
		}while (cDB.motherboard[choice-1] == null);
		
		cDB.motherboard[choice-1] = null;
	}
	
	//ASk the user what component to remove the memory from and removes it
	public void removeMemory(){
		int choice;
		
		System.out.println(cDB.listAll());
		
		do {
			System.out.println("Which component to remove memory from?");
			choice = getChoice(cDB.motherboard.length);
			
			if(cDB.motherboard[choice-1] == null)
				System.out.println("Select a number shown above");	
			
		}while (cDB.motherboard[choice-1] == null);
		
		cDB.motherboard[choice-1].setMemory(null);
	}
	
	//Sorts the array by the component's max memory size using the Bubble Sort algorithm
	public void bubbleSort(Component[] components){
		int k = 0;
		boolean exchangeMade = true;
		while ((k < components.length - 1) && exchangeMade){
			exchangeMade = false;
			k++;
			for (int j = 0; j < components.length - k; j++){
				if(components[j] != null){
					if (components[j].getMaxSize() > components[cDB.nextNotNullAfterIndex(j)].getMaxSize()){
						swap(components, j, j + 1);
						exchangeMade = true;
					}
				}
			}	
		}
	}
	
	//Swap 2 indexes within a given array
	public void swap(Component[] components, int x, int y){
		Component temp = components[x];
		components[x] = components[y];
		components[y] = temp;
	}
	
	//Get the user's menu choice but also check if it is valid. Max represents the highest number in the menu
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
	
	//Starts a proccess so the user can enter in a multi-line String to store in memory
  	public String getImage(){
		String str = "", user = "";
		
		for(int i = 1; !user.equalsIgnoreCase("stop"); i++){
			str += "\n" + user;
			System.out.print("Line " + i + ": ");
			user = input.nextLine();
			if(user.equalsIgnoreCase("cancel")){
				str = "cancel";
				break;
			}
		}
		if(user.equalsIgnoreCase("cancel"))
			return str;
		else
			return str.substring(2);
    }
    
  	//Get Methods
    public boolean getExit(){
    	return exit;
    }
    
    //Set Methods
    public void setExit(boolean leave){
		exit = leave;
	}

    //List all the info of the array's components using cDB
	public String listAll(){
    	String str = cDB.listAll();
    	return str;
    }

	//Pushes the output above the screen
	public void clearScreen(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}