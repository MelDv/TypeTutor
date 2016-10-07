/*
 *  This is the main class of TypeTutor
 */
package fi.maaretdufva.gui;

import javax.swing.SwingUtilities;

/**
 *
 * @author Maaret Dufva
 */
public class Main {

    public static void main(String[] args) {

        Gui gui = new Gui();
        SwingUtilities.invokeLater(gui);
//        User user = new User("");
//
//        System.out.println("Tervetuloa kirjoittamaan! ");
//        Game game = new Game(user);
//        game.start();
    }
}
