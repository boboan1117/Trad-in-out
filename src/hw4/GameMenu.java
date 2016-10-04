package hw4;


import java.util.ArrayList;
import java.util.Scanner;
/*
 * this is the list of the menu
 * zheng wen
 * 4/27/2015
 */

/*
 * I use this class to  implement menu function.
 */
public class GameMenu {
	private ArrayList <String> menus = new ArrayList<>(); 

	public int getChoice(Scanner stdin){
		System.out.println("Please enter one of the follwing choices : ");
		for(String option: menus){ 
		    System.out.println(option);
		}
		while(!stdin.hasNextInt())
			stdin.nextLine();
		    return Integer.valueOf(stdin.nextLine());
	}
	
	public void add(String option){
		menus.add(option);
	}
}
