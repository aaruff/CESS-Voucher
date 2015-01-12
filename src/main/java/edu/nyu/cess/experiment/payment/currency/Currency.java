package edu.nyu.cess.experiment.payment.currency;

/**
 * The Currency Interface.
 */
public interface Currency
{
	/**
	 * Gets the currency amount in words.
	 *
	 * @return the currency in words
     */
	public String getInWords();

	/**
	 * Gets currency value.
	 *
	 * @return the numerical value
     */
	public Double getValue();

	/**
	 * Gets the formatted currency value
	 *
	 * @return the in currency
     */
	public String getValueWithCurrencySymbol();
}
