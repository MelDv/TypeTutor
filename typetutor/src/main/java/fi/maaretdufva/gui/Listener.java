package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import robots.RobotTest;

/*
 * This is a keylistener class for the main game window. It listen's to what 
 * the user types and compares it with what she is expected to type. 
 * It also counts points and letters the user has already learned. 
 * <p>
 * This class listens to user input and updates the window accordingly. It receives character information fron Game class and compares it to user input.
 * It also sends information to the RobotTest class, when it is 
 * used for testing purposes.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since   0.1.0
 */
public class Listener implements KeyListener {

    private JTextArea writingArea;
    private JTextArea text;
    private JLabel points;
    private JLabel level;
    private Game game;
    private User user;
    private JLabel letters;

    /**
     * Constructor.
     */
    Listener(User user, Game game, JTextArea writingArea, JTextArea text, JLabel points, JLabel level, JLabel letters) {
        this.writingArea = writingArea;
        this.text = text;
        this.game = game;
        this.user = user;
        this.points = points;
        this.level = level;
        this.letters = letters;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyChar() == game.sendToListener()) {
            user.addPoint();
        } else {
            user.deductPoint();
        }

        //sendToRobot();
        String userpoints = String.valueOf(user.getPoints());
        points.setText(userpoints);
        level.setText(String.valueOf(game.getLevel()));
        text.setText(game.getTypeThis());
        writingArea.setText("");
        letters.setText(game.getLettersLearned());
    }

    /**
     * If the RobotTest is being used, this method will provide it with
     * information about the next character to type.
     */
    public void sendToRobot() {
        //This is code for the gui test robot. Unquote the command in keyTyped(), 
        //and run the program from RobotTest class. 
        //(Right click -> Run file or set RobotTest to Main class.)
        //
        RobotTest robot = new RobotTest();
        try {
            robot.setText(game.getKey());
        } catch (Exception ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //Pressing enter doesn't deduct points
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            user.addPoint();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    public int getPoints() {
        return user.getPoints();
    }

}
