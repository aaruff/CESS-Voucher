package edu.nyu.cess.experiment.payment;

import edu.nyu.cess.experiment.payment.currency.UnitedStatesDollar;

public class Payoff {
	private UnitedStatesDollar usd;

	public Payoff(String dollarAmount)
	{
		String[] splitAmount = dollarAmount.toString().split("\\.");
		final int DOLLAR = 0, CENTS = 1, BASE = 10;
		usd = new UnitedStatesDollar(Integer.parseInt(splitAmount[DOLLAR], BASE), Integer.parseInt(splitAmount[CENTS], BASE));
	}
	
	public String getUsd(){
		return this.usd.getValueWithCurrencySymbol();
	}
	
	public String getPayoffInWords(){
		return this.usd.getInWords();
	}
}
