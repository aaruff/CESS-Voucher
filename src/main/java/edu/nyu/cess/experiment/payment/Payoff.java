package edu.nyu.cess.experiment.payment;

import edu.nyu.cess.experiment.payment.currency.UnitedStatesDollar;

public class Payoff {
	private UnitedStatesDollar payoff;

	public Payoff(String dollarAmount){
		this.payoff = new UnitedStatesDollar(Double.valueOf(dollarAmount));
	}
	
	public String getPayoff(){
		return this.payoff.getValueWithCurrencySymbol();
	}
	
	public String getPayoffInWords(){
		return this.payoff.getInWords();
	}
}
