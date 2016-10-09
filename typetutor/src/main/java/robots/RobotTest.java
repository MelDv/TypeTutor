package robots;

import fi.maaretdufva.gui.Gui;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

/**
 * This class is an automatic robot for testing the gui.
 * <p>
 * It can be used to quickly check that the gui works properly and that you get
 * proper practice strings on different levels. The robot makes it easier to
 * check that the points, levels and all other information that should updates
 * correctly as the user's skills advance.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class RobotTest {

    private char type;

    /**
     * Constructor.
     */
    public RobotTest() {
        this.type = 's';
    }

    /**
     * This class can be used as Main class when running the program for test
     * purposes. This is the main method.
     *
     * @param args Automatic.
     * @throws Exception in case of trouble.
     */
    public static void main(String args[]) throws Exception {
        Gui gui = new Gui();
        SwingUtilities.invokeLater(gui);
        Thread.sleep(1500);

        {
            Robot r = new Robot();
            r.mouseMove(300, 220);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            r.keyPress(10);
            r.keyRelease(10);
        }

    }

    /**
     * This method tells the robot which key to press.
     *
     * @param newType The character to be pressed from the Game class.
     * @throws Exception in case of trouble.
     */
    //Only knows j, f and space for now
    public void setText(char newType) throws Exception {
        Robot r = new Robot();
        type = newType;
        switch (type) {
            case 'j':
                r.keyPress(KeyEvent.VK_J);
                r.keyRelease(KeyEvent.VK_J);
                break;
            case 'f':
                r.keyPress(KeyEvent.VK_F);
                r.keyRelease(KeyEvent.VK_F);
                break;
            case ' ':
                r.keyPress(KeyEvent.VK_SPACE);
                r.keyRelease(KeyEvent.VK_SPACE);
                break;
            default:
                r.keyPress(KeyEvent.VK_F);
                r.keyRelease(KeyEvent.VK_F);
                break;
        }
        Thread.sleep(20);
    }
}
