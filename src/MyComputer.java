/*
 * Nicholas Guida
 * MyComputer.java
 * Jan 27, 2017
 *
 * My "main" or "DatabaseTester" class. Rather than having all the methods in here, it simply creates a new Menu object (the object that holds
 * all my menus) and loops it as long as the user doesn't choose to exit the program. When they do, it prints out "Bye!"
 * 
 */
 
public class MyComputer {
    
    
    public static void main(String[] args) {
    	
    	//Make the Menu object. Only here to neaten up the code on the main class.
    	Menu mu = new Menu();
    	
    	//Keep going back to the main menu (restart the program) as long as the user doesn't choose to exit within mu.MainMenu()
    	do{
    		mu.mainMenu();
    	}while(!mu.getExit());
    	
    	//Once the user exits, say "Bye!"
    	System.out.println("\n------------------\nBye!\n------------------");
    }
}
