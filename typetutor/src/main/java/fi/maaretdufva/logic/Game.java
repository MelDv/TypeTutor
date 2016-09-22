/*
 * The main class for the program.
 * @author md
 */
package fi.maaretdufva.logic;

import fi.maaretdufva.users.User;

public class Game {

    //TÄMÄ ON KESKENERÄINEN LUOKKA.
    private OnBoarding aloita;
    private String opitutKirjaimet;
    private String opittavatKirjaimet;
    private User kayttaja;

    public Game(User user) {
        this.kayttaja = user; //tämä luokka palauttaa käyttäjän kehityksen.
        this.aloita = new OnBoarding();
    }

    public Game() {
    }

    public void start() {
        int level = kayttaja.getLevel();
        if (kayttaja == null || level < 1) {
            aloita.start();
        }
        if (level < 6) {
            Basic basic = new Basic(kayttaja.getLevel());
            basic.start();
        } else if (level < 16) {
            Intermediate interm = new Intermediate(kayttaja.getLevel());
            interm.start();
        } else {
            Advanced anvanc = new Advanced(kayttaja.getLevel());
            anvanc.start();
        }
    }
}
