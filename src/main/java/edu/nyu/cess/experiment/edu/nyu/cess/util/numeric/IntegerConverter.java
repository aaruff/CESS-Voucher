package edu.nyu.cess.experiment.edu.nyu.cess.util.numeric;

public class IntegerConverter
{
    /**
     * Returns the whole part of the number in words.
     * @param number
     * @return
     */
    public static String getAsWord(int number)
    {
        final int MAX_WHOLE_NUMBER = 999, MIN_WHOLE_NUMBER = 0;
        if (number >= MAX_WHOLE_NUMBER || number < MIN_WHOLE_NUMBER) {
            return "";
        }

        String wholePartInWords = "";

        int tempNumber = number;
        // Work backwards from the largest supported whole number place value (MAX_WHOLE_EXPONENT)
        final int MAX_WHOLE_EXPONENT = 3;
        for (int exponent = MAX_WHOLE_EXPONENT; exponent >= 0; --exponent) {

            if(isDependentPlaceValue(tempNumber)) {
                wholePartInWords = wholePartInWords.concat(elevenToNineteenInWords(tempNumber));
                exponent = 0;
            }
            else {
                // Calculate the power of 10 starting from 10^MAX_WHOLE_EXPONENT
                final int BASE = 10;
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
     * Returns true if the number cannot be represented in words with only one place value, and is also not divisible
     * by ten (i.e. numbers between 11 and 19).
     *
     * For example, 1 in 12 is a dependent place value, because it can't be described in words without inspecting
     * the number in the ones place, namely 2.
     * @param number
     * @return
     */
    private static boolean isDependentPlaceValue(int number)
    {
        final int EXCEPTION_LOWER_BOUND = 11;
        final int EXCEPTION_UPPER_BOUND = 19;
        if(number >= EXCEPTION_LOWER_BOUND && number <= EXCEPTION_UPPER_BOUND) {
            return true;
        }

        return false;
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
        final int BASE = 10;
        int onesValue = number - BASE;

        final String[] TEENS = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
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

        final int ONES_EXPONENT = 0;
        final String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        if (positionNumber == ONES_EXPONENT) {
            return ONES[coefficient];
        }

        final int TENS_EXPONENT = 1;
        final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if(positionNumber == TENS_EXPONENT) {
            return TENS[coefficient];
        }

        final int HUNDREDTHS_EXPONENT = 2, THOUSANDTHS_EXPONENT = 3;
        final String[] POWER_TEN = {"", "", "Hundred", "Thousand", "Million"};
        if(positionNumber == HUNDREDTHS_EXPONENT || positionNumber == THOUSANDTHS_EXPONENT) {
            return ONES[coefficient] + " " + POWER_TEN[positionNumber];
        }

        return "";
    }
}
