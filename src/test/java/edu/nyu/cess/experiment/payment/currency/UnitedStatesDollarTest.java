package edu.nyu.cess.experiment.payment.currency;

import junit.framework.TestCase;

public class UnitedStatesDollarTest extends TestCase
{
    public void testDollarToWords()
    {
        UnitedStatesDollar usd = new UnitedStatesDollar(22, 50);
        assertEquals("Twenty Two Dollars And Fifty Cents", usd.getInWords());
        usd.setAmount(0, 0);
        assertEquals("", usd.getInWords());
        usd.setAmount(0, 10);
        assertEquals("Ten Cents", usd.getInWords());
        usd.setAmount(0, 1);
        assertEquals("One Cent", usd.getInWords());
        usd.setAmount(0, 99);
        assertEquals("Ninety Nine Cents", usd.getInWords());
        usd.setAmount(100, 99);
        assertEquals("One Hundred Dollars And Ninety Nine Cents", usd.getInWords());
        usd.setAmount(901, 99);
        assertEquals("Nine Hundred One Dollars And Ninety Nine Cents", usd.getInWords());
        usd.setAmount(999, 99);
        assertEquals("Nine Hundred Ninety Nine Dollars And Ninety Nine Cents", usd.getInWords());
    }

}