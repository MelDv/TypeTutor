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
    private String[] words;

    /**
     * Constructor.
     */
    public Letters() {
        this.letters = "";
        this.repetition = new HashMap<>();
        this.words = new String[24];
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
        if (level > words.length) {
            level = words.length;
        }

        letter(level);

        if (level < 4) {
            randomString();
        } else if (level < 9) {
            randomStringWithCapitals();
        } else if (level < 16) {
            randomStringWithEndPunctuation();
        } else {
            randomStringWithPunctuation();
        }

        this.letters = "";
        for (int i = 0; i < words.length; i++) {
            this.letters += words[i];
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
     * @return a String table of ten random character sequences.
     */
    private String[] randomString() {
        Random r = new Random();
        int wordLength = 0;

        for (int i = 0; i < words.length; i++) {
            String typeThis = "";
            if (this.letters.length() < 5) {
                wordLength = 3;
            } else {
                wordLength = r.nextInt(3) + 6;
            }
            for (int j = 0; j < wordLength; j++) {
                char letter = (this.letters.charAt(r.nextInt(this.letters.length())));
                typeThis = typeThis + letter;
            }
            if (i > 0) {
                words[i] = " " + typeThis;
            } else {
                words[i] = typeThis;
            }
        }
        return words;
    }

    private String[] randomStringWithCapitals() {
        randomString();

        for (int i = 0; i < words.length; i++) {
            if (i % 3 == 0) {
                String temp = words[i];
                temp = temp.trim();
                temp = " " + temp.substring(0, 1).toUpperCase() + temp.substring(1);
                words[i] = temp;
            }
        }
        return words;
    }

    private String[] randomStringWithEndPunctuation() {
        Random r = new Random();
        String[] punctuation = {".", "!", "?"};

        randomString();
        randomStringWithCapitals();

        for (int i = 0; i < words.length; i++) {
            if (i != 0 && i % 2 == 0) {
                String temp = words[i];
                temp = temp + punctuation[r.nextInt(punctuation.length)];
                words[i] = temp;
            }
        }
        return words;
    }

    private String[] randomStringWithPunctuation() {
        Random r = new Random();
        String[] punctuation = {",", ":", ";", " –"};

        randomString();
        randomStringWithCapitals();
        randomStringWithEndPunctuation();

        for (int i = 0; i < words.length; i++) {
            if (i != 0 && i % 4 == 0) {
                String temp = words[i];
                temp = temp + punctuation[r.nextInt(punctuation.length)];
                words[i] = temp;
            }
        }
        return words;
    }

    private String letter(int level) {
        String[] letterSequences = {"jf", "kd", "jfkd", "ls", "jfkdls",
            "lsöaä", "hg", ",-.!?", "hgjfkdls",
            "hgjfkdlsöaä", "ru", "ie", "urie", "yt",
            "tyruei", "jfkdlsöatyruei", "ow", "pqå", "owpqå",
            "jfkdlsöatyrueiopwqå", "mv", "cxz", "nb", "mvcxznb",
            "qwertyuiopåäölkjhgfdsazxcvbnm"};

        this.letters = letterSequences[level];
        return this.letters;
    }
//öaä
}
