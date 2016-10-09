package fi.maaretdufva.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class creates random strings for practicing.
 * <p>
 * The users level will determine which letters she is going to practice. Those
 * letters are then used to create random strings for practicing. When the user
 * knows enough letters, the class will find proper words from a file or
 * database and string them together for the user.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class Letters {

    private String letters;
    private Map<Integer, String> repetition;

    /**
     * Constructor.
     */
    public Letters() {
        this.letters = "";
        this.repetition = new HashMap<>();
    }

    /**
     * This class will set the permitted repetition frequence for a certain
     * word.
     */
    public void setRepetition() {
    }

    /**
     * Thiss class will return the real repetition value as an integer, for a
     * word given as parameter.
     *
     * @param sana to be sought for from the repetition map.
     * @return repetition value from the map.
     */
    public int getRepetition(String sana) {
        return 0;
    }

    //Caps missing for now.
    /**
     * Determines the characters which the user should learn next based on the
     * level given as parameter. Calls methods randomWords and randomString.
     *
     * @param level Game class provides level information
     * @return the characters as a String that can be used in the next String to
     * be typed;
     */
    public String determineString(int level) {
        if (level < 0) {
            level = 0;
        }
        if (level > 17) {
            level = 17;
        }
        if (level == 0) {
            return this.letters = randomString("jf", 3);
        }
        if (level == 1) {
            return this.letters = randomString("kd", 3);
        }
        if (level == 2) {
            return this.letters = randomString("jfkd", 4);
        }
        if (level == 3) {
            return this.letters = randomString("ls", 3);
        }
        if (level == 4) {
            return this.letters = randomString("jfkdls", 4);
        }
        if (level == 5) {
            return this.letters = randomString("öa", 3);
        }
        if (level == 6) {
            return this.letters = randomString("lsöajf", 0);
        }
        if (level == 7) {
            return this.letters = randomString("jfkdlsöa", 0);
        }
        if (level == 8) {
            return this.letters = randomString("ru", 3);
        }
        if (level == 9) {
            return this.letters = randomString("jfkdlsöaru", 0);
        }
        if (level == 10) {
            return this.letters = randomString("mv", 3);
        }
        if (level == 11) {
            return this.letters = randomString("urmv", 5);
        }
        if (level == 12) {
            //return this.letters = randomWords("jfkdlsöarumv");
            return this.letters = randomString("jfkdlsöarumv", 6);
        }
        if (level == 13) {
            return this.letters = randomString("iec,!", 5);
        }
        if (level == 14) {
            return this.letters = randomString("owx.?", 5);
        }
        if (level == 15) {
            //return this.letters = randomWords("jfkdlsöarumviecxow,.");
            return this.letters = randomString("jfkdlsöarumviecxow,.", 0);
        }
        if (level == 16) {
            return this.letters = randomString("pqz-", 4);
        }
        if (level == 17) {
            //return this.letters = randomWords("jfkdlsöarumviecxow,.pqz-");
            return this.letters = randomString("jfkdlsöarumviecxow,.pqz-", 0);
        }
        return this.letters;
    }

    /**
     * Finds words from a list or database. The words can only contain letters
     * given in a parameter String.
     *
     * @param letters Given by determineString method.
     * @return a String of 10 words.
     */
    public String randomWords(String letters) {
        String typeThis = "";
        Random r = new Random();
        //words with certain letters from a file or list.

        return typeThis;

    }

    /**
     * Creates a random Sring using characters given as a String parameter. Each
     * random word has the number of characters given as an integer parameter.
     *
     * @param charactersToLearn A String of characters creating a return String.
     * @param numberOfLetters The number of letters each random character
     * sequence should contain.
     * @return a String of ten random character sequences.
     */
    public String randomString(String charactersToLearn, int numberOfLetters) {
        int numberOfWords = 10;
        Random r = new Random();
        int wordLength = 0;
        String typeThis = "";

        if (numberOfLetters == 0) {
            wordLength = r.nextInt(3) + 6;
        } else {
            wordLength = numberOfLetters;
        }

        for (int i = 0; i < numberOfWords; i++) {
            for (int j = 0; j < wordLength; j++) {
                char letter = (charactersToLearn.charAt(r.nextInt(charactersToLearn.length())));
                typeThis = typeThis + letter;
            }
            if (i < (numberOfWords - 1)) {
                typeThis = typeThis + " ";
            }
        }
        return typeThis;
    }
}
