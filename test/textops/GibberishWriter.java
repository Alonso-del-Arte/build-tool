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
    
    private static final String UPPERCASE_LETTERS 
            = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    private static final String LOWERCASE_LETTERS 
            = UPPERCASE_LETTERS.toLowerCase();
    
    private static final String DIGITS = "0123456789";
    
    private static final String ALPHANUMERICS = UPPERCASE_LETTERS + DIGITS
            + LOWERCASE_LETTERS + DIGITS;
    
    private static final int ALPHANUMERICS_LENGTH = ALPHANUMERICS.length();
    
    private static final Random RANDOM = new Random();
    
    // TODO: Write tests for this
    static String randomAlphanumeric(int length) {
        char[] characters = new char[length];
        for (int i = 0; i < length; i++) {
            characters[i] = ALPHANUMERICS
                    .charAt(RANDOM.nextInt(ALPHANUMERICS_LENGTH));
        }
        return new String(characters);
    }
    
    // TODO: Write tests for this
    static String randomFilename(String avoidExt) {
        return "SORRY, NOT IMPLEMENTED YET." + avoidExt;
    }
    
}
