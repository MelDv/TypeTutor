package fi.maaretdufva.gui;

import javax.swing.SwingUtilities;

/**
 * This is the main class for TypeTutor.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class Main {

    /**
     * Starts the program.
     * @param args Automatic.
     */
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
