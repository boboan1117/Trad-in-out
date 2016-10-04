package hw4;

/*
 * This class save all information of all goods
 * Zheng Wen
 * 4/27/2015
 */

/*
 * I use this class to  implement Purchase function. 
 * I write some detail comments to explain my code in the back of some important code. 
 */

import java.util.ArrayList;



public class Purchase {
	
		public boolean buy(Player player, ArrayList<Trader> traderlist, String buyname, int buyamount, Double buymoney ){
		
			boolean exist =false;
			int offerprice =(int)Math.random()*50+51; //generating one random range of offer price
			
			for (Trader temp: traderlist ){ // using "for" to scan all traders' information  
				
				if ( temp.getgoods().getGoodsName().equalsIgnoreCase(buyname)){ // if user's input equals one goods do next jobs
					
					if( (buyamount > temp.getgoods(). getGoodsAmount()) || (buymoney < offerprice) )// if user input the quantity of the goods is more than inventory 
																									// OR user input price is lower than offer price,system will print out one statements 
					{
						System.out.println("Sold out OR your price is too low ");
						return false;
						
					}
					
					else{// if user input the quantity of the goods is less than inventory, system will updating trader's information
					   
						temp.setMoney(temp.getMoney()+buymoney*buyamount);
						temp.getgoods().setGoodsAmount(temp.getgoods(). getGoodsAmount()-buyamount);
						
						System.out.println("The trader " + temp.getTradername() + " buy your goods");
						
					    for ( Goods temp1 : player.goodsList){ //using "for" to scan all player's data
					    	if (temp1.getGoodsName().equalsIgnoreCase(buyname)){ // if user buy the goods is exist in player's goods list, system will updating player's data
					    		player.setMoney(player.getMoney() - buymoney*buyamount);
					    		temp1.setGoodsAmount(temp1.getGoodsAmount()+buyamount);
					    		exist = true;
					    	}
						
					 	}
					    if (!exist){// if user buy the goods is not exist in player's goods list, system will add the goods information in goods list and updating player's data
					    	player.addGoods(new Goods(buyname,null, buyamount));//add new goods
					    	player.setMoney(player.getMoney() - buymoney*buyamount);
					    }
					    
					}
				}
			}
			
			return true;
			
		}
}
