/*
 * Tämä luokka luo satunnaiset kirjainyhdistelmät kirjainten harjoitteluun.
 */
package fi.maaretdufva.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author md
 */
public class Letters extends Text {

    private String letters;
    private Map<Integer, String> repetition;

    public Letters() {
        this.letters = "";
        this.repetition = new HashMap<>(); 
    }

    @Override
    public void setRepetition() {
    }

    @Override
    public int getRepetition() {
        return 0;
    }

    public String determineLetter(int level) {
        if (level < 1) {
            this.letters = randomChar("jf");
        }
        if (level < 2) {
            this.letters = randomChar("kd");
        }
        if (level < 3) {
            this.letters = randomChar("jfkd");
        }
        if (level < 4) {
            this.letters = randomChar("ls");
        }
        if (level < 5) {
            this.letters = randomChar("jfkdls");
        }
        if (level < 6) {
            this.letters = randomChar("öa");
        }
        if (level < 7) {
            this.letters = randomChar("lsöa");
        }
        if (level < 8) {
            this.letters = randomChar("jfkdlsöa");
        }
        return this.letters;
    }

    public String randomChar(String charactersToLearn) {
        String typeThis = "";
        Random r = new Random();
        int wordLength = r.nextInt(8);

        for (int i = 0; i < wordLength; i++) {
            char letter = (charactersToLearn.charAt(r.nextInt(charactersToLearn.length())));
            typeThis = typeThis + letter;
        }
        typeThis = typeThis + " ";

        return typeThis;
    }
}
