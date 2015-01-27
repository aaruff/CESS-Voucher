package edu.nyu.cess.experiment.payment.currency;

import junit.framework.TestCase;

public class UnitedStatesDollarTest extends TestCase
{
    public void testDollarToWords()
    {
        UnitedStatesDollar usd = new UnitedStatesDollar(22, 50);
        assertEquals("Twenty Two Dollars And Fifty Cents", usd.getInWords());
    }

}