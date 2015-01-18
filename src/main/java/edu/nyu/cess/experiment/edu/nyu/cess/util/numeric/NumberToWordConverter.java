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

    private static final int MAX_FRACTION_PLACE_VALUE = 100;

    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] powerTenInWords = {"", "", "Hundred", "Thousand", "Million"};

    /**
     * Returns the fractional part of the number in words.
     *
     * @param number
     * @return
     */
    public static String fractionalPortionInWords(double number)
    {
        double fractionalNumber = number - Math.floor(number);
        return wholePortionInWords(Math.floor(fractionalNumber*MAX_FRACTION_PLACE_VALUE));
    }

    /**
     * Returns the whole part of the number in words.
     * @param number
     * @return
     */
    public static String wholePortionInWords(double number)
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

    /**
     * Converts a base ten number (c*10^e) to words using the base 10 coefficient and exponent value.
     * @param coefficient base 10 coefficient (c*10)
     * @param exponent base 10 exponent (c*10^e)
     * @return
     */
    public static String baseTenMultipleToWords(int coefficient, int exponent)
    {
        if (exponent == ONES_EXPONENT) {
            return ones[coefficient];
        }
        else if(exponent == TENS_EXPONENT) {
            return tens[coefficient];
        }
        else if(exponent == HUNDREDTHS_EXPONENT || exponent == THOUSANDTHS_EXPONENT) {
            return ones[coefficient] + " " + powerTenInWords[exponent];
        }

        return "";
    }
}
