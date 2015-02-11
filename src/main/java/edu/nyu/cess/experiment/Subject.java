package edu.nyu.cess.experiment;

import edu.nyu.cess.experiment.payment.Payoff;

public class Subject {
	
	private String name;
	private Payoff payoff;
	
	public Subject(String name, String payoff){
		this.name = name;
		this.payoff = new Payoff(payoff);
	}
	
	public String getPayoffInCurrency(){
		return this.payoff.getUsd();
	}
	
	public String getPayoffInWords(){
		return this.payoff.getPayoffInWords();
	}
	
	public String getName(){
		return this.name;
	}
	
}
