package edu.nyu.cess.experiment.edu.nyu.cess.util.numeric;

import junit.framework.TestCase;

public class NumberToWordConverterTest extends TestCase
{
    public void testWholeNumberToWords()
    {
        assertTrue(NumberToWordConverter.wholePortionToWords(100000.99).equals(""));
        assertTrue(NumberToWordConverter.wholePortionToWords(0.99).equals(""));

        assertTrue(NumberToWordConverter.wholePortionToWords(900.99).equals("Nine Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(800.99).equals("Eight Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(700.99).equals("Seven Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(600.99).equals("Six Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(500.99).equals("Five Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(400.99).equals("Four Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(300.99).equals("Three Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(200.99).equals("Two Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(100.99).equals("One Hundred"));
        assertTrue(NumberToWordConverter.wholePortionToWords(900.99).equals("Nine Hundred"));

        assertTrue(NumberToWordConverter.wholePortionToWords(990.99).equals("Nine Hundred Ninety"));
    }

    public void testBaseTenPositionToWords()
    {
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(9, -1).equals(""));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(9, 100000).equals(""));

        assertTrue(NumberToWordConverter.baseTenMultipleToWords(1, 0).equals("One"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(2, 0).equals("Two"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(3, 0).equals("Three"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(4, 0).equals("Four"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(5, 0).equals("Five"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(6, 0).equals("Six"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(7, 0).equals("Seven"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(8, 0).equals("Eight"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(9, 0).equals("Nine"));

        assertTrue(NumberToWordConverter.baseTenMultipleToWords(1, 1).equals("Ten"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(2, 1).equals("Twenty"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(3, 1).equals("Thirty"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(4, 1).equals("Forty"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(5, 1).equals("Fifty"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(6, 1).equals("Sixty"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(7, 1).equals("Seventy"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(8, 1).equals("Eighty"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(9, 1).equals("Ninety"));

        assertTrue(NumberToWordConverter.baseTenMultipleToWords(1, 2).equals("One Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(2, 2).equals("Two Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(3, 2).equals("Three Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(4, 2).equals("Four Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(5, 2).equals("Five Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(6, 2).equals("Six Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(7, 2).equals("Seven Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(8, 2).equals("Eight Hundred"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(9, 2).equals("Nine Hundred"));

        assertTrue(NumberToWordConverter.baseTenMultipleToWords(1, 3).equals("One Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(2, 3).equals("Two Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(3, 3).equals("Three Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(4, 3).equals("Four Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(5, 3).equals("Five Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(6, 3).equals("Six Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(7, 3).equals("Seven Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(8, 3).equals("Eight Thousand"));
        assertTrue(NumberToWordConverter.baseTenMultipleToWords(9, 3).equals("Nine Thousand"));
    }

}
