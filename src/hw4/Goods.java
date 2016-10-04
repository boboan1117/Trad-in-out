package hw4;


/*
 * This class save all information of all goods
 * Zheng Wen
 * 4/27/2015
 */

/*
 * I use this class to manage the data of goods
*/

public class Goods {
	
	
	private String GoodsName;
	public String getGoodsName () {
		return GoodsName;
	}
	public String setGoodsName() {
		return GoodsName;
	}
	
	
	private int GoodsAmount;
	public int getGoodsAmount () {
		return GoodsAmount;	
	}
	public void setGoodsAmount (int amount) {
		this.GoodsAmount = amount;
	}
	
	
	private Double GoodsPrice ;
	public Double getGoodsPrice (){
		return GoodsPrice;
	}
	public Double setGoodsPrice (){
		return GoodsPrice;
	}
	
	
	private  Double Money;
	public Double getMoney () {
		return Money;
	}
	public Double setMoney () {
		return Money;
	}
	
	
	public Goods (String GoodsName, Double GoodsPrice, int GoodsAmount) {
		this.GoodsName = GoodsName;
		this.GoodsPrice = GoodsPrice;
		this.GoodsAmount = GoodsAmount;
	}



}
