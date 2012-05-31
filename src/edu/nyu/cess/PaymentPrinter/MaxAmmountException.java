package edu.nyu.cess.PaymentPrinter;

public class MaxAmmountException extends Exception {

	private static final long serialVersionUID = 4674738827431506494L;
	
	public MaxAmmountException(){}
	
	public MaxAmmountException(String message){
		super(message);
	}

}
