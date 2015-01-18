package edu.nyu.cess.experiment.edu.nyu.cess.util.numeric;

import junit.framework.TestCase;

public class NumberToWordConverterTest extends TestCase
{
    public void testFractionalNumberToWords()
    {
        assertEquals("Ninety Nine", NumberToWordConverter.fractionalPortionInWords(100000.99));
        assertEquals("Ninety Nine", NumberToWordConverter.fractionalPortionInWords(0.99));
    }
    public void testWholeNumberToWords()
    {
        assertEquals("", NumberToWordConverter.wholePortionInWords(100000.99));
        assertEquals("", NumberToWordConverter.wholePortionInWords(0.99));

        assertEquals("Nine Hundred", NumberToWordConverter.wholePortionInWords(900.99));
        assertEquals("Eight Hundred", NumberToWordConverter.wholePortionInWords(800.99));
        assertEquals("Seven Hundred", NumberToWordConverter.wholePortionInWords(700.99));
        assertEquals("Six Hundred", NumberToWordConverter.wholePortionInWords(600.99));
        assertEquals("Five Hundred", NumberToWordConverter.wholePortionInWords(500.99));
        assertEquals("Four Hundred", NumberToWordConverter.wholePortionInWords(400.99));
        assertEquals("Three Hundred", NumberToWordConverter.wholePortionInWords(300.99));
        assertEquals("Two Hundred", NumberToWordConverter.wholePortionInWords(200.99));
        assertEquals("One Hundred", NumberToWordConverter.wholePortionInWords(100.99));
        assertEquals("Nine Hundred", NumberToWordConverter.wholePortionInWords(900.99));

        assertEquals("Nine Hundred Ninety", NumberToWordConverter.wholePortionInWords(990.99));
    }

    public void testBaseTenPositionToWords()
    {
        assertEquals("", NumberToWordConverter.baseTenMultipleToWords(9, -1));
        assertEquals("", NumberToWordConverter.baseTenMultipleToWords(9, 100000));

        assertEquals("One", NumberToWordConverter.baseTenMultipleToWords(1, 0));
        assertEquals("Two", NumberToWordConverter.baseTenMultipleToWords(2, 0));
        assertEquals("Three", NumberToWordConverter.baseTenMultipleToWords(3, 0));
        assertEquals("Four", NumberToWordConverter.baseTenMultipleToWords(4, 0));
        assertEquals("Five", NumberToWordConverter.baseTenMultipleToWords(5, 0));
        assertEquals("Six", NumberToWordConverter.baseTenMultipleToWords(6, 0));
        assertEquals("Seven", NumberToWordConverter.baseTenMultipleToWords(7, 0));
        assertEquals("Eight", NumberToWordConverter.baseTenMultipleToWords(8, 0));
        assertEquals("Nine", NumberToWordConverter.baseTenMultipleToWords(9, 0));

        assertEquals("Ten", NumberToWordConverter.baseTenMultipleToWords(1, 1));
        assertEquals("Twenty", NumberToWordConverter.baseTenMultipleToWords(2, 1));
        assertEquals("Thirty", NumberToWordConverter.baseTenMultipleToWords(3, 1));
        assertEquals("Forty", NumberToWordConverter.baseTenMultipleToWords(4, 1));
        assertEquals("Fifty", NumberToWordConverter.baseTenMultipleToWords(5, 1));
        assertEquals("Sixty", NumberToWordConverter.baseTenMultipleToWords(6, 1));
        assertEquals("Seventy", NumberToWordConverter.baseTenMultipleToWords(7, 1));
        assertEquals("Eighty", NumberToWordConverter.baseTenMultipleToWords(8, 1));
        assertEquals("Ninety", NumberToWordConverter.baseTenMultipleToWords(9, 1));

        assertEquals("One Hundred", NumberToWordConverter.baseTenMultipleToWords(1, 2));
        assertEquals("Two Hundred", NumberToWordConverter.baseTenMultipleToWords(2, 2));
        assertEquals("Three Hundred", NumberToWordConverter.baseTenMultipleToWords(3, 2));
        assertEquals("Four Hundred", NumberToWordConverter.baseTenMultipleToWords(4, 2));
        assertEquals("Five Hundred", NumberToWordConverter.baseTenMultipleToWords(5, 2));
        assertEquals("Six Hundred", NumberToWordConverter.baseTenMultipleToWords(6, 2));
        assertEquals("Seven Hundred", NumberToWordConverter.baseTenMultipleToWords(7, 2));
        assertEquals("Eight Hundred", NumberToWordConverter.baseTenMultipleToWords(8, 2));
        assertEquals("Nine Hundred", NumberToWordConverter.baseTenMultipleToWords(9, 2));

        assertEquals("One Thousand", NumberToWordConverter.baseTenMultipleToWords(1, 3));
        assertEquals("Two Thousand", NumberToWordConverter.baseTenMultipleToWords(2, 3));
        assertEquals("Three Thousand", NumberToWordConverter.baseTenMultipleToWords(3, 3));
        assertEquals("Four Thousand", NumberToWordConverter.baseTenMultipleToWords(4, 3));
        assertEquals("Five Thousand", NumberToWordConverter.baseTenMultipleToWords(5, 3));
        assertEquals("Six Thousand", NumberToWordConverter.baseTenMultipleToWords(6, 3));
        assertEquals("Seven Thousand", NumberToWordConverter.baseTenMultipleToWords(7, 3));
        assertEquals("Eight Thousand", NumberToWordConverter.baseTenMultipleToWords(8, 3));
        assertEquals("Nine Thousand", NumberToWordConverter.baseTenMultipleToWords(9, 3));
    }

}
