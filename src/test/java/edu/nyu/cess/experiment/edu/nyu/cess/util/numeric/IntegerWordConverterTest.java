package edu.nyu.cess.experiment.edu.nyu.cess.util.numeric;

import junit.framework.TestCase;

public class IntegerWordConverterTest extends TestCase
{
    private static final String[] ONES = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] ELEVEN_NINETEEN = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String HUNDRED = "Hundred";


    public void testIntToWords()
    {
        for (int i = 1; i <= 999; ++i) {
            if (i < 10) {
               assertEquals(ONES[(i-1)], IntegerWordConverter.getAsWord(i));
            }
            else if (i % 10 == 0 && i < 100) {
                int num = i / 10;
                assertEquals(TENS[num - 1], IntegerWordConverter.getAsWord(i));
            }
            else if (i < 20) {
                int num = i % 10;
                assertEquals(ELEVEN_NINETEEN[num - 1], IntegerWordConverter.getAsWord(i));
            }
            else if (i < 99) {
                String expected = "";

                int tens = i/10;
                if (tens > 0) {
                    expected += TENS[tens - 1];
                }

                int ones = i - (tens * 10);
                if (ones > 0) {
                    expected += ((tens > 0) ? " " : "") + ONES[ones - 1];
                }

                assertEquals(expected, IntegerWordConverter.getAsWord(i));
            }
            else if (i < 999) {
                String expected = "";
                int hundreds = i / 100;
                if (hundreds > 0) {
                    expected += ONES[hundreds - 1] + " " + HUNDRED;
                }

                int remainder = i-hundreds*100;
                if (remainder > 10 && remainder < 20) {
                    int ones = remainder - 10;
                    expected += ((hundreds > 0) ? " " : "") + ELEVEN_NINETEEN[ones-1];
                }
                else {
                    int tens = remainder / 10;
                    if (tens > 0) {
                        expected += ((hundreds > 0) ? " " : "") + TENS[tens-1];
                    }

                    int ones = remainder - (tens * 10);
                    if (ones > 0) {
                        expected += ((tens > 0 || hundreds > 0) ? " " : "") + ONES[ones-1];
                    }
                }

                assertEquals(expected, IntegerWordConverter.getAsWord(i));
            }
        }
    }
}
