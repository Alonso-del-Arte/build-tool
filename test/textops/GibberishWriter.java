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

/**
 * Utility class to write gibberish for use in tests. The gibberish is expected 
 * to meet various requirements.
 * @author Alonso del Arte
 */
class GibberishWriter {
    
    /**
     * The uppercase letters available in the ASCII character set.
     */
    private static final String UPPERCASE_LETTERS 
            = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /**
     * The lowercase letters available in the ASCII character set.
     */
    private static final String LOWERCASE_LETTERS 
            = "abcdefghijklmnopqrstuvwxyz";
    
    /**
     * The digits available in the ASCII character set.
     */
    private static final String DIGITS = "0123456789";
    
    /**
     * A concatenation of {@link #UPPERCASE_LETTERS}, {@link #LOWERCASE_LETTERS} 
     * and {@link #DIGITS}. The digits are deliberately concatenated twice so as 
     * to ensure that at least one of them occurs in shorter outputs of {@link 
     * #randomAlphanumeric(int)}.
     */
    private static final String ALPHANUMERICS = UPPERCASE_LETTERS + DIGITS
            + LOWERCASE_LETTERS + DIGITS;
    
    private static final int ALPHANUMERICS_LENGTH = ALPHANUMERICS.length();
    
    private static final Random RANDOM = new Random();
    
    /**
     * Gives a <code>String</code> of specified length consisting of letters and 
     * digits only. This is limited to ASCII characters.
     * @param length How many characters to string together. Should be at least 
     * 0, but preferably positive, though not too large. For example, 17.
     * @return A <code>String</code> with as many characters as specified. 
     * Highly likely to include uppercase and lowercase letters as well as 
     * digits if <code>length</code> is at least 8. For example, given a 
     * <code>length</code> of 17, this function might return 
     * "OUW5d5JJU9zRur1c4".
     * @throws NegativeArraySizeException If <code>length</code> is negative.
     */
    static String randomAlphanumeric(int length) {
        char[] characters = new char[length];
        for (int i = 0; i < length; i++) {
            characters[i] = ALPHANUMERICS
                    .charAt(RANDOM.nextInt(ALPHANUMERICS_LENGTH));
        }
        return "new String(characters)";
    }
    
    // TODO: Write tests for this
    static String randomFilename(String avoidExt) {String s = "qq";
        return "SORRY, NOT IMPLEMENTED YET." + avoidExt;
    }
    
}
