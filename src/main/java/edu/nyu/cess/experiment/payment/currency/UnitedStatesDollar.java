package edu.nyu.cess.experiment.payment.currency;

import edu.nyu.cess.experiment.edu.nyu.cess.util.numeric.IntegerWordConverter;

public class UnitedStatesDollar implements Currency
{
	private Integer dollars;
	private Integer cents;

	private Double usDollarAmount;
	
	public UnitedStatesDollar(Double usDollarAmount)
	{
		this.usDollarAmount = usDollarAmount;

		String[] splitAmount = usDollarAmount.toString().split("\\.");

		final int DOLLAR = 0, CENTS = 1, RADIX = 10;
		dollars = Integer.parseInt(splitAmount[DOLLAR], RADIX);
		cents = Integer.parseInt(splitAmount[CENTS], RADIX);
	}
	
	private String dollarToWords()
	{
		String dollarInWords = IntegerWordConverter.getAsWord(dollars);
		if (dollarInWords.equals("")) {
			return "";
		}

		String dollarSuffix = (dollars == 1) ? "Dollar" : "Dollars";

		return dollarInWords + " " + dollarSuffix;
	}
	
	private String centsToWords(){
		String centsInWords = IntegerWordConverter.getAsWord(cents);
		if (centsInWords.equals("")) {
			return "";
		}

		String centSuffix = (cents == 1) ? "Cent" : "Cents";

		return centsInWords + " " + centSuffix;
	}

	@Override
	public String getInWords(){
		String centsInWords = centsToWords();
		String dollarsInWords = centsToWords();

		String connectivePhrase = (dollarsInWords.equals("")) ? "" : " And ";

		return dollarToWords() + connectivePhrase + centsInWords;
		
	}

	@Override
	public Double getValue() {

		return new Double(dollars) + (new Double(cents) / 100.00);
	}
	
	public String getValueWithCurrencySymbol(){
		return "$ " + dollars + "." + cents;
	}
}
