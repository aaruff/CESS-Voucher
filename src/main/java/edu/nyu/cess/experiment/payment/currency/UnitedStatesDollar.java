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
	 * @param dollars the dollars
	 * @param cents the cents
     */
	public UnitedStatesDollar(Integer dollars, Integer cents)
	{
		this.dollars = dollars;
		this.cents = cents;
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
	 * Translates cents values from 0 to 99 to words
	 *
	 * @return the string
     */
	private String centsToWords(){
        if (isNotBetween(cents, 0, 99)) {
            return "";
        }

		String centsInWords = IntegerWordConverter.getAsWord(cents);
		if (centsInWords.equals("")) {
			return "";
		}

		String centSuffix = (cents == 1) ? "Cent" : "Cents";

		return centsInWords + " " + centSuffix;
	}

    private static boolean isNotBetween(int num, int lowerBound, int upperBound)
    {
        return num < lowerBound || num > upperBound;
    }

	/**
	 * Get in words.
	 *
	 * @return the string
     */
	public String getInWords(){
		String dollarsInWords = dollarToWords();
		String centsInWords = centsToWords();

		String connectivePhrase = (dollarsInWords.equals("")) ? "" : " And ";

		return dollarsInWords + connectivePhrase + centsInWords;
		
	}

	/**
	 * Get value with currency symbol.
	 *
	 * @return the string
     */
	public String getValueWithCurrencySymbol(){
		return "$ " + dollars + "." + cents;
	}

	/**
	 * Sets amount.
	 *
	 * @param dollars the dollars
	 * @param cents the cents
     */
	public void setAmount(Integer dollars, Integer cents)
	{
		this.dollars = dollars;
		this.cents = cents;
	}
}
