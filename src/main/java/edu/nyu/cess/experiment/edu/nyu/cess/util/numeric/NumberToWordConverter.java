package edu.nyu.cess.experiment.edu.nyu.cess.util.numeric;

public class NumberToWordConverter
{
    private static final int ONES_EXPONENT = 0;
    private static final int TENS_EXPONENT = 1;
    private static final int HUNDREDTHS_EXPONENT = 2;
    private static final int THOUSANDTHS_EXPONENT = 3;

    private static final int MAX_WHOLE_EXPONENT = 3;

    private static final int BASE = 10;

    private static final int EXCEPTION_LOWER_BOUND = 11;
    private static final int EXCEPTION_UPPER_BOUND = 19;

    private static final int MAX_WHOLE_NUMBER = 999;
    private static final int MIN_WHOLE_NUMBER = 0;

    private static final String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] TEENS = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] POWER_TEN = {"", "", "Hundred", "Thousand", "Million"};

    /**
     * Returns the whole part of the number in words.
     * @param number
     * @return
     */
    public static String intToWords(int number)
    {
        if (number >= MAX_WHOLE_NUMBER || number < MIN_WHOLE_NUMBER) {
            return "";
        }

        String wholePartInWords = "";

        int tempNumber = number;
        // Work backwards from the largest supported whole number place value (MAX_WHOLE_EXPONENT)
        for (int exponent = MAX_WHOLE_EXPONENT; exponent >= 0; --exponent) {

            // Numbers 11 to 19 are exceptions to the rule (E.g. 11 is written as "Eleven" instead of "Ten One")
            if(tempNumber >= EXCEPTION_LOWER_BOUND && tempNumber <= EXCEPTION_UPPER_BOUND) {
                wholePartInWords = wholePartInWords.concat(elevenToNineteenInWords(tempNumber));
                exponent = 0;
            }
            else {
                // Calculate the power of 10 starting from 10^MAX_WHOLE_EXPONENT
                int powerOfTen = (int) Math.pow(BASE, exponent);

                int coefficient = tempNumber / powerOfTen;

                if (coefficient > 0) {
                    wholePartInWords = wholePartInWords.concat(baseTenMultipleToWords(coefficient, exponent) + " ");
                    tempNumber -= coefficient * powerOfTen;
                }
            }
        }
        return wholePartInWords.trim();
    }

    /**
     * Converts exceptional numbers between 11 and 19 to words. Note: These are the only numbers that cannot
     * be printed a digit at a time, and must be considered together.
     *
     * @param number
     * @return
     */
    private static String elevenToNineteenInWords(int number)
    {
        int onesValue = number - BASE;

        return TEENS[onesValue];
    }

    /**
     * Converts all numbers within the supported range that can be printed one base 10 position at a time
     * (i.e. [1, 10] and [20-MAX_SUPPORTED].
     * @param coefficient base 10 coefficient (c*10)
     * @param positionNumber base 10 positionNumber (c*10^p)
     * @return
     */
    private static String baseTenMultipleToWords(int coefficient, int positionNumber)
    {
        if (positionNumber == ONES_EXPONENT) {
            return ONES[coefficient];
        }
        else if(positionNumber == TENS_EXPONENT) {
            return TENS[coefficient];
        }
        else if(positionNumber == HUNDREDTHS_EXPONENT || positionNumber == THOUSANDTHS_EXPONENT) {
            return ONES[coefficient] + " " + POWER_TEN[positionNumber];
        }

        return "";
    }
}
