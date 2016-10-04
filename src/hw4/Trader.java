package hw4;


/*
 * This class save all information of all goods
 * Zheng Wen
 * 4/27/2015
 */

/*
 * I use this class to manage the trader's data
 */

public class Trader {
	
	private String tradername ;
	protected Double money;
	

	private Goods goods;
	
	public Trader (String tradername,Double money, Goods goods){
		this.tradername = tradername;
		this.goods = goods;
		this.money = money;
		
	}
	
	public String getTradername() {
		return tradername;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Goods getgoods() {
		return goods;
	}
	
	public Double getMoney() {
		return money;
	}
	
	
}
