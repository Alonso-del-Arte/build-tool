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

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the GibberishWriter class.
 * @author Alonso del Arte
 */
public class GibberishWriterTest {
    
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
    
}