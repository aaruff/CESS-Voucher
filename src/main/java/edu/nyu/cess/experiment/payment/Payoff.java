package edu.nyu.cess.experiment.payment;

import edu.nyu.cess.experiment.payment.currency.Currency;
import edu.nyu.cess.experiment.payment.currency.Dollar;

public class Payoff {
	private Currency amount;
	
	public Payoff(String dollarAmount){
		this.amount = new Dollar(Double.valueOf(dollarAmount));
	}
	
	public Double getAmount(){
		return this.amount.getValue();
	}
	
	public String getInDollars(){
		return this.amount.getValueWithCurrencySymbol();
	}
	
	public String getDollarsInWords(){
		return this.amount.getInWords();
	}
}
