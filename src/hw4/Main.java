package hw4;


import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/* 
 * This main class
 * Zheng Wen 
 * 4/27/2015
 */

/*
 * In this class, user can choose "Buy", "Sale", and "Displayer information". Then my system will call other class to get user's demand.
 * I write some detail comments to explain my code in the back of some important code. 
 */

public class Main {

	final static int Purchase = 1;
	final static int Sale = 2;
	final static int DisplayInfor = 3;
	final static int Quit = 0;  
	final static int INVALID =-1;
	static ArrayList traderlist = new ArrayList <>();
	
	public static void main (String [] args)  {
		
		int choice = INVALID;
		GameMenu menu = initializeMenu();
		Player player = new Player("",1000.00, new Goods("Rice",5.00,500));
		String [] buyer = { "Soplie" , "Neema" , "Donald" , "Anthony " , "Guillermo"};
		intro(); 
		Purchase purchase = new Purchase();
		Sale sale = new Sale();
		Traderinitialize();
		
		
		do{
			//I use "do... while" loop to show the menu
		System.out.println("Please enter your choice: ");
		choice = menu.getChoice(new Scanner (System.in)); 
		
		switch (choice){ 
		
		case Quit:
			player.playerinfor();                         // call "playerinfor" to print out the player's information.
			System.out.println("Game Over");
			
			break;
		case Purchase: // Use Scanner to get user's choice from keyboard
			System.out.println("Please enter the name of the goods that you want to buy");
			String buyname= new Scanner(System.in).next();
			System.out.println("How many goods you want to buy ? ");
			int buyamount = new Scanner(System.in).nextInt();
			System.out.println ("How much you want to pay as the unit price ?");
			Double buydoall = new Scanner(System.in).nextDouble();
			if (purchase.buy (player,traderlist,buyname,buyamount,buydoall)){ 
				System.out.println("This goods already add to your list");
				if (player.getMoney() < 0){                         // when user's money at least 0, the game will exit and print out the player's information
					choice = 0;
					System.out.println("You do not have money ! Game Over !");
					player.playerinfor();
				}
			}
			break;

		case Sale:// Use Scanner to get user's choice from keyboard
			System.out.println("Rice is only one goods that you can sell");
			String sellname= "Rich";
			System.out.println("How many goods you want to sell ? ");
			int sellamount = new Scanner(System.in).nextInt();
			//using "sell" method to updating  player's information 
			if(sale.sell(player, "Rice",sellamount)){
				Random rad = new Random();
				int index = rad.nextInt(buyer.length);                                 // using Random to generate random buyer 
				System.out.println("The trader " + buyer[index] + " buy your goods"); // Print out the random buyer and offer price.
																					//	In Sale class, I also use Random to generate random offer price. 
			}
				
            break;
		case DisplayInfor:
			player.playerinfor();                    // call "playerinfor" to list everything that user has.  
            break;
        default:
        	throw new UnsupportedOperationException();
		}
	}
	while(Quit != choice);
	 
		
}
	private static GameMenu initializeMenu() {
	    GameMenu  menu = new GameMenu();
	    menu.add("0. Quit");
	    menu.add("1. Buy some goods");
	    menu.add("2. Sell some goods");
	    menu.add("3. Display Trader's information");
	    return menu;
	}
	private static void Traderinitialize(){             // initialize the data of the traders.
		
		traderlist.add (new Trader("Soplie",1000.00,new Goods ("Shoes",68.00,100)));
		traderlist.add(new Trader ("Neem",20000.00,new Goods ("Gold",100.00,50)));
		traderlist.add(new Trader("Donald",30000.00,new Goods ("Wool",88.00,200)));
		traderlist.add(new Trader("Anthony",40000.00,new Goods("Beef",50.00,300)));
		traderlist.add(new Trader("Guillermo",50000.00,new Goods("Oil",80.00,400)));
		traderlist.add(new Trader("Noriko",10000.00,new Goods ("Rice",70.00,500)));
		
		
	}
	private static void intro() {
		                                       // use this function to show the introduction and list what user can purchase
		System.out.println(" Play this game to experience the challenges and excitement of international trade \n" +
				"You are a trader. In your company, the main goods are rich.\n"+ 
				" If you want to get other goods, you could buy from other traders: \n"+ "\n"+
				"* Soplie sells shoes \n" + "* Neema sells gold \n" + "* Donald sells wool \n" + "* Anthony sells beef \n" + "* Guillermo sells oil \n" );
	}

	
}
