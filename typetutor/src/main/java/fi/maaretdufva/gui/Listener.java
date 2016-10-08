/*
 * This is the action listener class. It listens to user input and updates the window.
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Maaret
 */
public class Listener implements KeyListener {

    private JTextArea writingArea;
    private JLabel text;
    private JLabel points;
    private JLabel level;
    private Game game;
    private User user;
    private Gui gui;

    Listener(User user, JTextArea writingArea, JLabel text, JLabel points, JLabel level) {
        this.writingArea = writingArea;
        this.text = text;
        this.user = user;
        this.game = new Game(user);
        this.gui = new Gui();
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
        level.setText(String.valueOf(user.getLevel()));
        text.setText(game.getTypeThis());
        writingArea.setText("");
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
