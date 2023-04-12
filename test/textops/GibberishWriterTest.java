/*
 * Copyright (C) 2023 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package textops;

import java.util.Random;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the GibberishWriter class.
 * @author Alonso del Arte
 */
public class GibberishWriterTest {
    
    private static final Random RANDOM = new Random(System.nanoTime());
    
    private static final String UPPERCASE_LETTERS 
            = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    private static final String LOWERCASE_LETTERS 
            = UPPERCASE_LETTERS.toLowerCase();
    
    private static final String DIGITS = "0123456789";
    
    private static void evaluateCharCounts(String s) {
        int uppercaseLetterCount = 0;
        int lowercaseLetterCount = 0;
        int digitCount = 0;
        int otherTypeCount = 0;
        char[] characters = s.toCharArray();
        for (char ch : characters) {
            boolean isUppercaseLetter = UPPERCASE_LETTERS.indexOf(ch) > -1;
            boolean isLowercaseLetter = LOWERCASE_LETTERS.indexOf(ch) > -1;
            boolean isDigit = DIGITS.indexOf(ch) > -1;
            boolean isNoneOfTheAbove = !isUppercaseLetter && !isLowercaseLetter 
                    && !isDigit;
            if (isUppercaseLetter) uppercaseLetterCount++;
            if (isLowercaseLetter) lowercaseLetterCount++;
            if (isDigit) digitCount++;
            if (isNoneOfTheAbove) otherTypeCount++;
        }
        String msg = "Returned String \"" + s 
                + "\" should have letters, at least one digit, no other kind";
        assert uppercaseLetterCount > 0 : msg;
        assert lowercaseLetterCount > 0 : msg;
        assert uppercaseLetterCount > 0 : msg;
        assert digitCount > 0 : msg;
        assertEquals(otherTypeCount, 0, msg);
    }
    
    @Test(expectedExceptions = NegativeArraySizeException.class)
    public void testRandomAlphanumericRejectsNegativeLength() {
        int badLength = RANDOM.nextInt() | Integer.MIN_VALUE;
        System.out.println(GibberishWriter.randomAlphanumeric(badLength));
        System.out.println("Trying to call randomAlphanumeric() with length " 
                + badLength + " should have caused NegativeArraySizeException");
    }
    
    @Test
    public void testRandomAlphanumeric() {
        System.out.println("randomAlphanumeric");
        int minLength = 8;
        int maxLength = 20;
        for (int expected = minLength; expected <= maxLength; expected++) {
            String s = GibberishWriter.randomAlphanumeric(expected);
            int actual = s.length();
            String msg = "Returned String \"" + s + "\" expected to have " 
                    + expected + " characters";
            assertEquals(actual, expected, msg);
            evaluateCharCounts(s);
        }
    }
    
    @Test
    public void testRandomFilename() {
        System.out.println("randomFilename");
        int extLength = 3 + (RANDOM.nextInt(81) % 3);
        String avoidExt = GibberishWriter.randomAlphanumeric(extLength);
        String filename = GibberishWriter.randomFilename(avoidExt);
        int lastPeriodIndex = filename.lastIndexOf('.');
        assert lastPeriodIndex > -1 && lastPeriodIndex < filename.length() - 1 
                : "Filename should include period and an extension";
        String msg = "Filename " + filename + " requested not to end with ." 
                + avoidExt + " extension should not end with that extension";
        assert !filename.endsWith(avoidExt) : msg;
        String basename = filename.substring(0, lastPeriodIndex);
        evaluateCharCounts(basename);
    }
    
}
