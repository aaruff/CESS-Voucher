package edu.nyu.cess.payment;

public interface Currency {
	public String getInWords();
	public Double getNumericalValue();
	public String getInCurrency();
	public String toString();
}
