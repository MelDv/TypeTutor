/*
 * The main class for the program.
 * @author md
 */
package fi.maaretdufva.logiikka;

import fi.maaretdufva.users.User;

public class Game {

    //TÄMÄ ON KESKENERÄINEN LUOKKA.
    private OnBoarding aloita;
    private String opitutKirjaimet;
    private String opittavatKirjaimet;
    private User user;

    public Game(User user) {
        this.user = user; //tämä luokka palauttaa käyttäjän kehityksen.
        this.aloita = new OnBoarding();
    }

    public Game() {
    }

    public void start() {
        int level = user.getLevel();
        if (user == null || level < 1) {
            aloita.start();
        }
        if (level < 6) {
            Basic basic = new Basic(user.getLevel());
            basic.start();
        } else if (level < 16) {
            Intermediate interm = new Intermediate(user.getLevel());
            interm.start();
        } else {
            Advanced anvanc = new Advanced(user.getLevel());
            anvanc.start();
        }
    }
}
