/*
 * This is the action listener class. It listens to user input and updates the window.
 */
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

/**
 *
 * @author Maaret
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

        points.setText(String.valueOf(user.getPoints()));
        level.setText(String.valueOf(user.countLevelbyPoints()));
        writingArea.setText("");
        text.setText(game.getTypeThis());

        //This is code for the the gui test robot. Unquote, start Typetutor and then
        //RobotTest class (go to class, right click and run file) to see how it works.
        //
//        RobotTest robot = new RobotTest();
//        try {
//            robot.setText(game.getKey());
//        } catch (Exception ex) {
//            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
