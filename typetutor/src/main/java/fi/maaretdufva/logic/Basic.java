/*
 * Lähtötaso
 */
package fi.maaretdufva.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Maaret
 */
public class Basic implements Levels {

    private int level;

    // TÄMÄ ON KESKENERÄINEN LUOKKA! TARKISTA KAIKKI METODIT!
    public Basic(int level) {
        this.level = level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void start() {
        if (level < 1) {
            randomChar("jf");
        }
        if (level < 2) {
            randomChar("kd");
        }
        if (level < 3) {
            randomChar("jfkd");
        }
        if (level < 4) {
            randomChar("ls");
        }
        if (level < 5) {
            randomChar("jfkdls");
        }
        if (level < 6) {
            randomChar("öa");
        }
        if (level < 7) {
            randomChar("lsöa");
        }
        if (level < 8) {
            randomChar("jfkdlsöa");
        }
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
