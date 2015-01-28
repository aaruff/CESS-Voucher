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
        //TODO: Test cent values > 99 (i.e., out of range)
    }

}