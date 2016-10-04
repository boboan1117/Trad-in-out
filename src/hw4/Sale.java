package hw4;

/*
 * This class save all information of all goods
 * Zheng Wen
 * 4/27/2015
 */
/*
 * I use this class to  implement Sale function. 
 * I write some detail comments to explain my code in the back of some important code. 
 */

import java.text.DecimalFormat;
import java.util.Random;

public class Sale {


		public boolean sell (Player player,String sellname, int sellamount){
			
			Random rand = new Random();
			Double sellmoney = rand.nextDouble()*50;
			sellmoney = (Double)((Math.random()*6+3));//generating random offer price
			 DecimalFormat df = new DecimalFormat("######0.00");  // just keep two decimal places
				sellmoney = Double.valueOf(df.format(sellmoney));
				
				
				for (Goods temp : player.goodsList){// using "for" to scan all player's information  
					if (temp.getGoodsName().equals("Rice")){// finding all information of the ArrayList of "Rice"
						
						if ((sellamount > temp.getGoodsAmount()) || (player.getMoney() < 0)) { //  if user input the quantity of the "Rice" is more than inventory 
																								// OR random offer price is lower than 0, system will print out one statements 
							System.out.println("Sold out  OR  You do not have enough money. " );
							return false;
						}
						else {// if user input the quantity of the goods is less than inventory, system will updating player's data
						player.setMoney(player.getMoney() + (sellmoney)*sellamount);
			    		temp.setGoodsAmount(temp.getGoodsAmount()-sellamount);
						}
					}
				}
				System.out.println("The trader pay $" + sellmoney + " as unit price");
				return true;
		}
}
