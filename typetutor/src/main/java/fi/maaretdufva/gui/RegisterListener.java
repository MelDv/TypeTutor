/*
 * This class will deal with new users.
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maaret
 */
public class RegisterListener implements ActionListener {

    public RegisterListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Get user info. To be implemented.

        User user = new User("Matti");
        Game game = new Game(user);
        System.out.println(user);
    }
}
