package edu.nyu.cess.experiment.edu.nyu.cess.util.numeric;

/**
 * The type Integer word converter.
 */
public class IntegerWordConverter
{
    private final static int BASE = 10;

    /**
     * Returns the whole part of the number in words.
     * @param number the number
     * @return as word
     */
    public static String getAsWord(int number)
    {
        final int MAX_WHOLE_NUMBER = 999, MIN_WHOLE_NUMBER = 0;
        if (number >= MAX_WHOLE_NUMBER || number < MIN_WHOLE_NUMBER) {
            return "";
        }

        String wholePartInWords = "";
        final int MAX_EXPONENT = 3;
        // Work backwards from the largest supported whole number place value (MAX_EXPONENT)
        for (int decomposedNumber = number, exponent = MAX_EXPONENT; exponent >= 0; --exponent)
        {
            if(isDependentPlaceValueNumber(decomposedNumber)) {
                wholePartInWords += getDependentPlaceValueNumberAsWord(decomposedNumber);
                exponent = 0;
            }
            else {
                int coefficient = getBaseTenCoefficient(exponent, number);
                if (coefficient > 0) {
                    wholePartInWords += getBaseTenNumberAsWord(coefficient, exponent) + " ";
                    decomposedNumber -= coefficient * getBaseTenValue(exponent);
                }
            }
        }

        return wholePartInWords.trim();
    }

    /**
     * Gets base ten coefficient.
     *
     * @param position the position
     * @param number the number
     * @return the base ten coefficient
     */
    private static int getBaseTenCoefficient(int position, int number)
    {
        int powerOfTen = (int) Math.pow(BASE, position);
        return number / powerOfTen;
    }

    /**
     * Gets base ten value.
     *
     * @param position the position
     * @return the base ten value
     */
    private static int getBaseTenValue(int position)
    {
        return (int) Math.pow(BASE, position);
    }

    /**
     * Returns true if the number cannot be represented in words with only one place value, and is also not divisible
     * by ten (i.e. numbers between 11 and 19).
     *
     * For example, 1 in 12 is a dependent place value, because it can't be described in words without inspecting
     * the number in the ones place, namely 2.
     * @param number the number
     * @return boolean boolean
     */
    private static boolean isDependentPlaceValueNumber(int number)
    {
        final int LOWER_DEPENDENT_BOUND = 11, UPPER_DEPENDENT_BOUND = 19;
        return (number >= LOWER_DEPENDENT_BOUND && number <= UPPER_DEPENDENT_BOUND) ? true : false;
    }

    /**
     * Converts dependent place value numbers to words.
     *
     * Dependent place value numbers are numbers that cannot be represented in words with only one place value,
     * and is also not divisible by ten (i.e. The numbers [11, 19] inclusive).
     *
     * @param number the number
     * @return string string
     */
    private static String getDependentPlaceValueNumberAsWord(int number)
    {
        int onesValue = number - BASE;

        final String[] TEENS = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        return TEENS[onesValue];
    }

    /**
     * Converts all numbers within the supported range that can be printed one base 10 position at a time
     * (i.e. [1, 10] and [20-MAX_SUPPORTED].
     * @param coefficient base 10 coefficient (c*10)
     * @param positionNumber base 10 positionNumber (c*10^p)
     * @return string string
     */
    private static String getBaseTenNumberAsWord(int coefficient, int positionNumber)
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
