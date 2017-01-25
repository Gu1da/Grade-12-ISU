/*
 * Nicholas Guida
 * Jan 23
 *
 **/
 
 
import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	
    public void clearScreen(){
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
}