package edu.nyu.cess.experiment.payment.currency;

public interface Currency {
	public String getInWords();
	public Double getNumericalValue();
	public String getInCurrency();
	public String toString();
}
