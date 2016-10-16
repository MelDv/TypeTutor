package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.AllUsers;
import fi.maaretdufva.users.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class will deal with new users.
 * <p>
 * If a user presses the Register-button, this class will deal with getting user
 * information, creating a new user and adding the user to the list of users.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class RegisterListener implements ActionListener {
    private AllUsers all;
    private User user;

    /**
     * Constructor.
     */
    public RegisterListener() {
        this.all = new AllUsers();
        this.user = new User("temp");        
    }   
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Get user info. To be implemented.

        User user = new User("Matti");
        System.out.println(user);
    }
}
