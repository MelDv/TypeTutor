package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.AllUsers;
import fi.maaretdufva.users.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class will deal with new and existing users.
 * <p>
 * If a user presses the Register-button, this class deals with getting user
 * information, creating a new user and adding the user to the list of users. If
 * a user wants to login, it finds their details and gives them to game class.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class RegisterListener extends JPanel implements ActionListener {

    private User user;
    private JButton register;
    private JButton login;
    private Game game;
    private JFrame frame;
    private JTextField giveUsername;
    private JPasswordField givePassword;
    private AllUsers all;

    /**
     * Constructor.
     *
     * @param user from Gui
     * @param game from Gui
     * @param frame from Gui
     * @param register from Gui
     * @param giveUsername from Gui
     * @param givePassword from Gui
     * @param login from Gui
     */
    public RegisterListener(User user, Game game, JFrame frame, JButton register, JTextField giveUsername, JPasswordField givePassword, JButton login) {
        this.register = register;
        this.login = login;
        this.game = game;
        this.user = user;
        this.frame = frame;
        this.giveUsername = giveUsername;
        this.givePassword = givePassword;
        this.all = new AllUsers();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String uname = giveUsername.getText();
        char[] passw = givePassword.getPassword();

        if (ae.getSource() == register) {
            if (register.getText().equals("Register")) {
                if (all.findUser(uname)) {
                    badUsername("The username already in use. Pick another one");
                } else { //username fine
                    user = new User(uname);
                    user.setPassword(passw);
                    all.addUser(user);
                    game.setUser(user);
                    register.setText("Logout");
                    login.setEnabled(false);
                    register.setEnabled(true);
                    welcome();

                }
            } else if (register.getText().equals("Logout")) {
                frame.setTitle("Typetutor: Hello new user!");
                all.writeToFile(user);
                user = new User("temp");
                game.setUser(user);
                register.setText("Register");
                login.setEnabled(true);
                register.setEnabled(true);
                clearUp();
            }
        }
        if (ae.getSource() == login) {
            if (!all.findUser(uname)) {
                badUsername("User not found.");
            } else if (user.testPassword(passw)) {
                welcome();
                login.setEnabled(false);
                register.setText("Logout");
                register.setEnabled(true);
                user = all.getUser(uname);
                game.setUser(user);
            }
        }
    }

//private methods for creating popup windows for error messages etc. and cleaning up the window.  
    private void welcome() {
        frame.setTitle("TypeTutor: Happy typing " + user.getUsername() + "!");
        game.setUser(user);
        clearUp();
        welcomeDialog();
    }

    private void welcomeDialog() {
        JDialog jd = new JDialog();
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] options = {"Cool!"};
        String welcome = "Welcome " + user.getUsername() + "! Your score will now be saved. Don't forget your password!";
        int response = JOptionPane.showOptionDialog(jd, welcome, "Welcome!",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    private void badUsername(String error) {
        JDialog jd = new JDialog();
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] options = {"Ok"};
        int response = JOptionPane.showOptionDialog(jd, "Username not found", "Username",
                JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (response == JOptionPane.YES_OPTION) {
            jd.dispose();
        }
    }

    private void clearUp() {
        all.writeToFile(user);
        this.giveUsername.setText("");
        this.givePassword.setText("");
        frame.validate();
        frame.repaint();
    }
}
