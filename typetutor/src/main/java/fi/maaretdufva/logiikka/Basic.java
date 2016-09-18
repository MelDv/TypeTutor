/*
 * Lähtötaso
 */
package fi.maaretdufva.logiikka;

/**
 *
 * @author Maaret
 */
public class Basic implements Tasot {

    private Game game;

    // TÄMÄ ON KESKENERÄINEN LUOKKA! TARKISTA KAIKKI METODIT!
    public Basic() {
     }

    @Override
    public void setLevel(int level) {
    }

    @Override
    public void start() {
        jf();
    }

    public void jf() {
        System.out.println("Aloitetaan helpoimmasta. Aseta etusormesi näppäimille J ja F."
                + "Katso mallia kuvasta. Näkyviin tulee tekstiä, kirjoita se.");
    }
}
