package edu.nyu.cess.PaymentPrinter;

public interface Currency {
	public String getInWords();
	public Double getNumericalValue();
	public String getInCurrency();
	public String toString();
}
