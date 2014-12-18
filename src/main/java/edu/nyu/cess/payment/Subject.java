package edu.nyu.cess.payment;

public class Subject {
	
	private String name;
	private Payoff payoff;
	
	public Subject(String name, String payoff){
		this.name = name;
		this.payoff = new Payoff(payoff);
	}
	
	public Subject(String name, Payoff payoff){
		this.name = name;
		this.payoff = payoff;
	}
	
	public Double getPayoffAmount(){
		return this.payoff.getAmount();
	}
	
	public String getPayoffInCurrency(){
		return this.payoff.getInCurrecy();
	}
	
	public String getPayoffInWords(){
		return this.payoff.getAmountInWords();
	}
	
	public String getName(){
		return this.name;
	}
	
}
