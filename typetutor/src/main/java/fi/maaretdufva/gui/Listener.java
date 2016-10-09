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
 * This is the action listener class. 
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

    Listener(User user, JTextArea writingArea, JTextArea text, JLabel points, JLabel level) {
        this.writingArea = writingArea;
        this.text = text;
        this.user = user;
        this.game = new Game(user);
        this.points = points;
        this.level = level;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

        if (ke.getKeyChar() == game.sendToListener()) {
            user.addPoint();
        } else {
            user.deductPoint();
        }

        //sendToRobot();
        points.setText(String.valueOf(user.getPoints()));
        level.setText(String.valueOf(user.countLevelbyPoints()));
        writingArea.setText("");
        text.setText(game.getTypeThis());
    }

    public void sendToRobot() {
        //This is code for the the gui test robot. Unquote the command in keyTyped(), 
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

    public int returnPoints() {
        return user.getPoints();
    }
}
