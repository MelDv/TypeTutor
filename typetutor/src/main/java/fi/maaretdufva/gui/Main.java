/*
 *  This is the main class of TypeTutor
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maaret Dufva
 */
public class Main {

    public static void main(String[] args) {
        
        Gui gui = new Gui();
        SwingUtilities.invokeLater(gui);
//        Account tili = new Account();       
//        User user = new User("");
//
//        System.out.println("Tervetuloa kirjoittamaan! ");
//        user = tili.aloita();
//        Game game = new Game(user);
//        game.start();
    }
}
