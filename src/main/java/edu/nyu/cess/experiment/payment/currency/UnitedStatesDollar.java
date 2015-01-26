package edu.nyu.cess.experiment.payment.currency;

import edu.nyu.cess.experiment.edu.nyu.cess.util.numeric.IntegerWordConverter;

/**
 * The type United states dollar.
 */
public class UnitedStatesDollar
{
	private Integer dollars;
	private Integer cents;

	/**
	 * Instantiates a new United states dollar.
	 *
	 * @param usDollarAmount the us dollar amount
     */
	public UnitedStatesDollar(Double usDollarAmount)
	{
		String[] splitAmount = usDollarAmount.toString().split("\\.");

		final int DOLLAR = 0, CENTS = 1, RADIX = 10;
		dollars = Integer.parseInt(splitAmount[DOLLAR], RADIX);
		cents = Integer.parseInt(splitAmount[CENTS], RADIX);
	}

	/**
	 * Dollar to words.
	 *
	 * @return the string
     */
	private String dollarToWords()
	{
		String dollarInWords = IntegerWordConverter.getAsWord(dollars);
		if (dollarInWords.equals("")) {
			return "";
		}

		String dollarSuffix = (dollars == 1) ? "Dollar" : "Dollars";

		return dollarInWords + " " + dollarSuffix;
	}

	/**
	 * Cents to words.
	 *
	 * @return the string
     */
	private String centsToWords(){
		String centsInWords = IntegerWordConverter.getAsWord(cents);
		if (centsInWords.equals("")) {
			return "";
		}

		String centSuffix = (cents == 1) ? "Cent" : "Cents";

		return centsInWords + " " + centSuffix;
	}

	/**
	 * Get in words.
	 *
	 * @return the string
     */
	public String getInWords(){
		String centsInWords = centsToWords();
		String dollarsInWords = centsToWords();

		String connectivePhrase = (dollarsInWords.equals("")) ? "" : " And ";

		return dollarToWords() + connectivePhrase + centsInWords;
		
	}

	/**
	 * Get value with currency symbol.
	 *
	 * @return the string
     */
	public String getValueWithCurrencySymbol(){
		return "$ " + dollars + "." + cents;
	}
}
