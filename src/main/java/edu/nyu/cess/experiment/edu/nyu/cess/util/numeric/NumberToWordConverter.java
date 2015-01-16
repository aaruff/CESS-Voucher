package edu.nyu.cess.experiment.edu.nyu.cess.util.numeric;

public class NumberToWordConverter
{
    private static final int ONES_EXPONENT = 0;
    private static final int TENS_EXPONENT = 1;
    private static final int HUNDREDTHS_EXPONENT = 2;
    private static final int THOUSANDTHS_EXPONENT = 3;

    private static final int MAX_WHOLE_EXPONENT = 3;

    private static final int BASE = 10;


    private static final double MAX_WHOLE_NUMBER = 10000.0;
    private static final double MIN_WHOLE_NUMBER = 0.0;

    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] baseTen = {"", "", "Hundred", "Thousand", "Million"};

    public static String wholePortionToWords(double number)
    {
        if (number >= MAX_WHOLE_NUMBER || number <= MIN_WHOLE_NUMBER) {
            return "";
        }

        String wholePartInWords = new String();
        double tempNumber = number;
        for (int exponent = MAX_WHOLE_EXPONENT; exponent >= 0; --exponent) {
            double powerOfTen = Math.pow(BASE, (exponent));
            int coefficient = new Double(Math.floor(tempNumber / powerOfTen)).intValue();
            if (coefficient > 0) {
                wholePartInWords = wholePartInWords.concat(" " + baseTenMultipleToWords(coefficient, exponent));
            }
            tempNumber -= coefficient*powerOfTen;
        }

        return wholePartInWords.trim();
    }

    public static String baseTenMultipleToWords(int coefficient, int exponent)
    {
        if (exponent == ONES_EXPONENT) {
            return ones[coefficient];
        }
        else if(exponent == TENS_EXPONENT) {
            return tens[coefficient];
        }
        else if(exponent == HUNDREDTHS_EXPONENT || exponent == THOUSANDTHS_EXPONENT) {
            return ones[coefficient] + " " + baseTen[exponent];
        }

        return "";
    }
}
