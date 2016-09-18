/*
 * The main class for the program.
 */
package fi.maaretdufva.logiikka;

import fi.maaretdufva.users.User;

/**
 *
 * @author md
 */
public class Game {

    private OnBoarding aloita;
    private String opitutKirjaimet;
    private String opittavatKirjaimet;
    private User user;

    public Game(User user) {
        this.user = user;
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
            Basic basic = new Basic();
            basic.start();
        } else if (level < 16) {
            Intermediate interm = new Intermediate();
            interm.start();
        } else {
            Advanced anvanc = new Advanced();
            anvanc.start();
        }
    }
}
