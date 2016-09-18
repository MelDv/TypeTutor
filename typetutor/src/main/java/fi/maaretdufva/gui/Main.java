/*
 *  This is the main class of TypeTutor
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logiikka.Game;
import fi.maaretdufva.users.User;

/**
 *
 * @author Maaret Dufva
 */
public class Main {

    public static void main(String[] args) {
        Tili tili = new Tili();       
        User user = new User("");

        System.out.println("Tervetuloa kirjoittamaan! ");
        user = tili.aloita();
        Game game = new Game(user);
        game.start();
    }
}
