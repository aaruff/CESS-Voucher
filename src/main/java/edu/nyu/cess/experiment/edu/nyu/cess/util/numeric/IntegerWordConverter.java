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
            final String NO_TRANSLATION = "";
            return NO_TRANSLATION;
        }

        String translation = "";
        final int MAX_POSITION = 3, MIN_POSITION = 1;
        for (int tempNumber = number, position = MAX_POSITION; position >= MIN_POSITION; --position)
        {
            if(isNumberTwoDigitCompoundWord(position, tempNumber)) {
                translation += getDependentPlaceValueAsWord(tempNumber);
                break;
            }

            if (getPositionValue(position, tempNumber) > 0) {
                translation += getBaseTenNumberAsWord(position, tempNumber) + " ";
                tempNumber -= getBaseTenValue(position, tempNumber);
            }
        }

        return translation.trim();
    }

    private static int getBaseTenValue(int position, int number)
    {
        return getPositionValue(position, number) * getBaseValue(position);
    }

    /**
     * Gets base ten coefficient.
     *
     * @param position the position
     * @param number the number
     * @return the base ten coefficient
     */
    private static int getPositionValue(int position, int number)
    {
        int powerOfTen = getBaseValue(position);

        if (powerOfTen > number) {
            final int INDIVISIBLE_RESULT = 0;
            return INDIVISIBLE_RESULT;
        }

        return number / powerOfTen;
    }

    private static int getBaseValue(int position)
    {
        final int EXPONENT_OFFSET = 1;
        int exponent = position - EXPONENT_OFFSET;

        int powerOfTenValue = 1;
        for (int i = 1; i <= exponent; ++i) {
            powerOfTenValue *= BASE;
        }

        return powerOfTenValue;
    }

    /**
     * Returns true if the number is a two digit compound word, otherwise false.
     *
     * Two digit compound words cannot be translated to words unless two position values are known, namely
     * positions 2 and 1. All two digit compound words are between 11 and 19.
     *
     * @param position the position to inspect
     * @param number the number
     * @return boolean boolean
     */
    private static boolean isNumberTwoDigitCompoundWord(int position, int number)
    {
        final int HUNDREDTHS_PLACE = 2;
        if (position != HUNDREDTHS_PLACE) {
            return false;
        }

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
    private static String getDependentPlaceValueAsWord(int number)
    {
        int onesValue = number - BASE;

        final String[] TEENS = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        return TEENS[onesValue];
    }

    private static String getOnesPlaceValueAsWord()

    private static String getBaseTenNumberAsWord(int position, int number)
    {
        final String NO_TRANSLATION = "";

        int coefficient = getPositionValue(position, number);

        final String[] ONES = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        final int ONES_EXPONENT = 1;
        if (position == ONES_EXPONENT) {
            return (coefficient == 0) ? NO_TRANSLATION : ONES[coefficient];
        }

        final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        final int TENS_EXPONENT = 2;
        if(position == TENS_EXPONENT) {
            return TENS[coefficient];
        }

        final String[] POWER_TEN = {"", "", "Hundred", "Thousand", "Million"};
        final int HUNDREDTHS_EXPONENT = 3;
        if(position == HUNDREDTHS_EXPONENT) {
            return ONES[coefficient] + " " + POWER_TEN[position];
        }

        return "";
    }
}
