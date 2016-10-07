/*
 * This class creates random strings for practicing
 */
package fi.maaretdufva.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author md
 */
public class Letters {

    private String letters;
    private Map<Integer, String> repetition;

    public Letters() {
        this.letters = "";
        this.repetition = new HashMap<>();
    }

    public void setRepetition() {
    }

    public int getRepetition(String sana) {
        return 0;
    }

    public String determineString(int level) {
        if (level < 1) {
            return this.letters = randomString("jf", 3);
        }
        if (level < 2) {
            return this.letters = randomString("kd", 3);
        }
        if (level < 3) {
            return this.letters = randomString("jfkd", 4);
        }
        if (level < 4) {
            return this.letters = randomString("ls", 3);
        }
        if (level < 5) {
            return this.letters = randomString("jfkdls", 4);
        }
        if (level < 6) {
            return this.letters = randomString("öa", 3);
        }
        if (level < 7) {
            return this.letters = randomString("lsöajf", 0);
        }
        if (level < 8) {
            return this.letters = randomString("jfkdlsöa", 0);
        }
        if (level < 9) {
            return this.letters = randomString("ru", 3);
        }
        if (level < 10) {
            return this.letters = randomString("jfkdlsöaru", 0);
        }
        if (level < 11) {
            return this.letters = randomString("mv", 3);
        }
        if (level < 12) {
            return this.letters = randomString("urmv", 5);
        }
        if (level < 13) {
            return this.letters = randomWords("jfkdlsöarumv");
        }
        if (level < 14) {
            return this.letters = randomString("iec,", 5);
        }
        if (level < 15) {
            return this.letters = randomString("owx.", 5);
        }
        if (level < 16) {
            return this.letters = randomWords("jfkdlsöarumviecxow,.");
        }
        if (level < 17) {
            return this.letters = randomString("pqz-", 4);
        }
        if (level < 18) {
            return this.letters = randomWords("jfkdlsöarumviecxow,.pqz-");
        }

        return this.letters;
    }

    public String randomWords(String letters) {
        String typeThis = "";
        Random r = new Random();
        //words with certain letters from a file or list

        return typeThis;

    }

    public String randomString(String charactersToLearn, int numberOfLetters) {

        Random r = new Random();
        int wordLength = 0;
        String typeThis = "";

        if (numberOfLetters == 0) {
            wordLength = r.nextInt(3) + 6;
        } else {
            wordLength = numberOfLetters;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < wordLength; j++) {
                char letter = (charactersToLearn.charAt(r.nextInt(charactersToLearn.length())));
                typeThis = typeThis + letter;
            }
            if (i < 9) {
                typeThis = typeThis + " ";
            }
        }
        return typeThis;
    }
}
