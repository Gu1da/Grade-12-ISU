/**
 * @(#)MyComputer.java
 *
 * MyComputer application
 *
 * @author 
 * @version 1.00 2017/1/18
 */
import java.util.Scanner;
 
public class MyComputer {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	ComponentDB cDB = new ComponentDB();
    	System.out.println("Take the L");
    	Menu mu = new Menu();
    	
    	int choice;
  		mu.clearScreen();
  		
  		//output menu
  		System.out.println("=========================================");
  		System.out.println("              ~Main Menu~                ");
  		System.out.println("-----------------------------------------");
  		System.out.println("1: Create component  4: Manage components");
  		System.out.println("2: Create memory     5: Manage memory    ");
  		System.out.println("3: View memory       6: Exit             ");
  		System.out.println("=========================================");
  		
  		//get choice
  		choice = mu.getChoice(1);
  			
  		//move on
		if(choice == 1){
    		mu.clearScreen();
    	
	    	System.out.println("=========================================");
	    	System.out.println("         ~Create a component~");
	    	System.out.println("-----------------------------------------");
	    	System.out.println("1: Create just component");
	    	System.out.println("2: Create component and create memory with it");
	    	System.out.println("=========================================");
	    	
	    	//get choice and check
	  		choice = mu.getChoice(1);
	  		
	  		//move on	
	  		if(choice == 1){
	  			String compName;
				String compBrand;
				double compSpeed;			//In Mhz or Ghz, depending on the memory type
				int compMaxSize; 				
				char compType;				//Hdd, Cpu, Gpu, Ram, Ssd
		    	
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
		    	
		    	
		    	
				cDB.addComponent(compName, compBrand, compSpeed, compMaxSize, compType);
	  		}
		}		
    }
}

