/*
 * Nicholas Guida
 * Jan 23
 *
 */
 
 
import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	
	 public void clearScreen(){
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    //May not need
    public boolean checkValid(int num, int low, int high){
    	if(num >= low && num <= high)
    		return true;
    	else
    		return false;
    }
    
    public int getChoice(int max){
    	int choice;
    	
    	do{
	  		System.out.print("Enter digit of selection: ");
	  		choice = input.nextInt();
	  		
	  		if(!(choice >= 1 && choice <= max))
	  			System.out.println("Please enter a valid entry");
  		}while(!(choice >= 1 && choice <= max));
  		
  		return choice;
    }
	
  	public void mainMenu(){
  		int choice;
  		this.clearScreen();
  		
  		//output menu
  		System.out.println("=========================================");
  		System.out.println("              ~Main Menu~                ");
  		System.out.println("-----------------------------------------");
  		System.out.println("1: Create component  4: Manage components");
  		System.out.println("2: Create memory     5: Manage memory    ");
  		System.out.println("3: View memory       6: Exit             ");
  		System.out.println("=========================================");
  		
  		//get choice
  		choice = getChoice(6);
  		
  		//move on	
  	//	if(choice == 1)
  	//		createComponent();
  	//	if(choice == 2)
  			
  	//	if(choice == 3)
  			
  	//	if(choice == 4)
  			
  	//	if(choice == 5)
  			
  	//	if(choice == 6)
  				
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
  		choice = getChoice(2);
  		
  		//move on	
  	//	if(choice == 1)
  			
  	//	if(choice == 2)
  			
  			
    }
    
    /*
    public void createComponentAssignMem(){
    	String compName;
		String compBrand;
		double compSpeed;			//In Mhz or Ghz, depending on the memory type
		int compMaxSize; 				
		char compType;				//Hdd, Cpu, Gpu, Ram, Ssd
		MemoryBlock compMemory;
    	
    	System.out.print("Name: ");
    	compName = input.nextLine();
    	
    	System.out.print("Brand: ");
    	compBrand = input.nextLine();
    	
    	System.out.print("Max memory size: ");
    	compMaxSize = input.nextInt();
    	
    	System.out.print("Type of component");
    	compType = input.next(".").charAt(0);
    	
    	System.out.print("Clock Speed: ");
    	compSpeed = input.nextDouble();
    	
    	ComponentDB.motherboard[ComponentDB.nextFree()] = ComponentDB.motherboard[0];
    	
    }
    */
    
    public void createComponent(){
    	
    	
    }
	////////////////////////////////////////////////////////////////////////////////////
	/*
    public Menu() {
    	
    }
    
    public void clearScreen(){
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    public boolean checkValid(int num, int low, int high){
    	if(num >= low && num <= high)
    		return true;
    	else
    		return false;
    }
	
  	public void mainMenu(){
  		int selection;
  		this.clearScreen();
  		
  		//output menu
  		System.out.println("=========================================");
  		System.out.println("              ~Main Menu~                ");
  		System.out.println("-----------------------------------------");
  		System.out.println("1: Create component  4: Manage components");
  		System.out.println("2: Create memory     5: Manage memory    ");
  		System.out.println("3: View memory       6: Exit             ");
  		System.out.println("=========================================");
  		
  		//get selection and check
  		do{
	  		System.out.print("Enter digit of selection: ");
	  		selection = input.nextInt();
	  		
	  		if(!checkValid(selection, 1, 6))
	  			System.out.println("Please enter a valid entry");
  		}while(!checkValid(selection, 1, 6));
  		
  		//move on	
  	//	if(selection == 1)
  	//		createComponent();
  	//	if(selection == 2)
  			
  	//	if(selection == 3)
  			
  	//	if(selection == 4)
  			
  	//	if(selection == 5)
  			
  	//	if(selection == 6)
  				
  	}
    
    public void createComponentMenu(){
    	int selection;
    	clearScreen();
    	
    	System.out.println("=========================================");
    	System.out.println("         ~Create a component~");
    	System.out.println("-----------------------------------------");
    	System.out.println("1: Create just component");
    	System.out.println("2: Create component and tranfser memory to it");
    	System.out.println("3: Create component and create memory with it");
    	System.out.println("=========================================");
    	
    	//get selection and check
  		do{
	  		System.out.print("Enter digit of selection: ");
	  		selection = input.nextInt();
	  		
	  		if(!checkValid(selection, 1, 3))
	  			System.out.println("Please enter a valid entry");
  		}while(!checkValid(selection, 1, 3));
  		
  		//move on	
  	//	if(selection == 1)
  			
  	//	if(selection == 2)
  			
  	//	if(selection == 3)
  			
    }
    
    public void createComponentAssignMem(){
    	String compName;
		String compBrand;
		double compSpeed;			//In Mhz or Ghz, depending on the memory type
		int compMaxSize; 				
		char compType;				//Hdd, Cpu, Gpu, Ram, Ssd
		MemoryBlock compMemory;
    	
    	System.out.print("Name: ");
    	compName = input.nextLine();
    	
    	System.out.print("Brand: ");
    	compBrand = input.nextLine();
    	
    	System.out.print("Max memory size: ");
    	compMaxSize = input.nextInt();
    	
    	System.out.print("Type of component");
    	compType = input.next(".").charAt(0);
    	
    	System.out.print("Clock Speed: ");
    	compSpeed = input.nextDouble();
    	
    	ComponentDB.motherboard[ComponentDB.nextFree()] = ComponentDB.motherboard[0];
    	
    }
    */
}
