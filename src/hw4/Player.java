package hw4;

/*
 * This class save all information of all goods
 * Zheng Wen
 * 4/27/2015
 */


/*
 * I use this class to manage and print player's data 
*/


import java.util.ArrayList;

public class Player extends Trader{
	
	ArrayList <Goods>goodsList =  new ArrayList <Goods>();
	
	public ArrayList<Goods> getGoodsList() {
		return goodsList;
	}

	public Player(String tradername, Double money, Goods goods) {
		super(tradername, money, goods);
		goodsList.add(goods);
		
		this.money = money;
	}
	
	public void addGoods(Goods goods){
		goodsList.add(goods);
	}
	
	public void playerinfor (){
		
		for (Goods temp : goodsList ){
			
			System.out.println("This is your goods list : " + temp.getGoodsName() + " the goods amount is : " + temp.getGoodsAmount());
			
		}
		
		System.out.println("This is your money : $" + getMoney());
	}
}
