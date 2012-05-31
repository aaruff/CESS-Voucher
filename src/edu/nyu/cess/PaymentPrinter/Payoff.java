package edu.nyu.cess.PaymentPrinter;

public class Payoff {
	private Currency amount;
	
	public Payoff(Double dollarAmount){
		this.amount = new Dollar(dollarAmount);
	}
	
	public Payoff(String dollarAmmount){
		this.amount = new Dollar(Double.valueOf(dollarAmmount));
	}
	
	public void setDollarAmount(Double dollarAmount){
		this.amount = new Dollar(dollarAmount);
	}
	
	public void setDollarAmount(String dollarAmount){
		this.amount = new Dollar(Double.valueOf(dollarAmount));
	}
	
	public Double getAmount(){
		return this.amount.getNumericalValue();
	}
	
	public String getInCurrecy(){
		return this.amount.getInCurrency();
	}
	
	public String getAmountInWords(){
		return this.amount.getInWords();
	}
}
