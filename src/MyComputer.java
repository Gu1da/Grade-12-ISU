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
    ComponentDB cDB = new ComponentDB();
    
    public static void main(String[] args) {
    	
    	Menu mu = new Menu();
    	mu.mainMenu();
    	
    }
}
