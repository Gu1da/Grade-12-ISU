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
    Scanner input = new Scanner(System.in);
    
    
    public static void main(String[] args) {
    	
    	Menu mu = new Menu();
    	
    	do
    		mu.mainMenu();
    	while(!mu.getExit());
    }
}
