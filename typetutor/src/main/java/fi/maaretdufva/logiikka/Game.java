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
        this.opittavatKirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
        this.user = user;
        this.opitutKirjaimet = user.getOpitutKirjaimet();
        this.aloita = new OnBoarding();
        opeteltavatKirjaimet(opitutKirjaimet);
        start();
    }

    public Game() {
    }

    public void start() {
        int level = user.getLevel();
        if (user == null || level < 1) {
            aloita.start();
        }
        if (level < 5) {
            Basic basic = new Basic(this.opittavatKirjaimet);
            basic.start();
        }
        if (level < 10) {
            Intermediate interm = new Intermediate(this.opittavatKirjaimet);
            interm.start();
        }
        if (level < 15) {
            Advanced anvanc = new Advanced(this.opittavatKirjaimet);
            anvanc.start();
        }
    }

    public String opeteltavatKirjaimet(String opitutKirjaimet) {
        for (int i = 0; i < this.opitutKirjaimet.length; i++) {
            if (this.opittavatKirjaimet.contains(opitutKirjaimet.charAt(i))) {
                this.opittavatKirjaimet.replace(i, "");
            }
        }
        return this.opittavatKirjaimet;
    }
}
