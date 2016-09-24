/*
 * Lähtötaso
 */
package fi.maaretdufva.logic;

/**
 *
 * @author Maaret
 */
public class Level {

    private int level;

    public Level() {
        this.level = 0;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int determineLevel(int points) {
        if (points < 0) {
            setLevel(0);
        } else {
            setLevel(points / 200);
        }
        return level;
    }
}
