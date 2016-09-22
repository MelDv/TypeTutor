/*
 * Lähtötaso
 */
package fi.maaretdufva.logic;

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
            jf();
        }
    }

    public void jf() {
        System.out.println("Aloitetaan helpoimmasta. Aseta etusormesi näppäimille J ja F."
                + "Katso mallia kuvasta. Näkyviin tulee tekstiä, kirjoita se.");
    }
}
