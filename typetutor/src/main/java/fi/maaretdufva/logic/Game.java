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
        this.kayttaja = user; //palauttaa käyttäjän kehityksen.
        this.aloita = new OnBoarding();
    }

    public Game() {
    }

    public void start() {
        int level = kayttaja.getLevel();
        if (kayttaja == null || level < 1) {
            aloita.start();
        }
    }

    public char sendToListener() {
        char typeThis = 'f';

        return typeThis;
    }

    public void newCharacter(boolean piste) {
        if (piste) {
            
        }
    }

}
