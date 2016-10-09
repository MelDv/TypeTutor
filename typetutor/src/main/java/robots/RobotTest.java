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
            case 'k':
                r.keyPress(KeyEvent.VK_K);
                r.keyRelease(KeyEvent.VK_K);
                break;
            case 'd':
                r.keyPress(KeyEvent.VK_D);
                r.keyRelease(KeyEvent.VK_D);
                break;
            case 'l':
                r.keyPress(KeyEvent.VK_L);
                r.keyRelease(KeyEvent.VK_L);
                break;
            case 's':
                r.keyPress(KeyEvent.VK_S);
                r.keyRelease(KeyEvent.VK_S);
                break;
            case 'a':
                r.keyPress(KeyEvent.VK_A);
                r.keyRelease(KeyEvent.VK_A);
                break;
            case 'r':
                r.keyPress(KeyEvent.VK_R);
                r.keyRelease(KeyEvent.VK_R);
                break;
            case 'u':
                r.keyPress(KeyEvent.VK_U);
                r.keyRelease(KeyEvent.VK_U);
                break;
            case 'm':
                r.keyPress(KeyEvent.VK_M);
                r.keyRelease(KeyEvent.VK_M);
                break;
            case 'v':
                r.keyPress(KeyEvent.VK_V);
                r.keyRelease(KeyEvent.VK_V);
                break;
            case 'i':
                r.keyPress(KeyEvent.VK_I);
                r.keyRelease(KeyEvent.VK_I);
                break;
            case 'e':
                r.keyPress(KeyEvent.VK_E);
                r.keyRelease(KeyEvent.VK_E);
                break;
            case 'c':
                r.keyPress(KeyEvent.VK_C);
                r.keyRelease(KeyEvent.VK_C);
                break;
            case 'x':
                r.keyPress(KeyEvent.VK_X);
                r.keyRelease(KeyEvent.VK_X);
                break;
            case 'o':
                r.keyPress(KeyEvent.VK_O);
                r.keyRelease(KeyEvent.VK_O);
                break;
            case 'w':
                r.keyPress(KeyEvent.VK_W);
                r.keyRelease(KeyEvent.VK_W);
                break;
            case 'z':
                r.keyPress(KeyEvent.VK_Z);
                r.keyRelease(KeyEvent.VK_Z);
                break;
            case ',':
                r.keyPress(KeyEvent.VK_COMMA);
                r.keyRelease(KeyEvent.VK_COMMA);
                break;
            case '.':
                r.keyPress(KeyEvent.VK_PERIOD);
                r.keyRelease(KeyEvent.VK_PERIOD);
                break;
            case '-':
                r.keyPress(KeyEvent.VK_MINUS);
                r.keyRelease(KeyEvent.VK_MINUS);
                break;
            case '!':
                r.keyPress(KeyEvent.VK_EXCLAMATION_MARK);
                r.keyRelease(KeyEvent.VK_EXCLAMATION_MARK);
                break;
                //check ? and add ä and ö + caps
//            case '?':
//                r.keyPress(KeyEvent.VK_DEAD_TILDE);
//                r.keyPress(KeyEvent.VK_QUOTEDBL);
//                r.keyRelease(KeyEvent.VK_QUOTEDBL);
//                r.keyRelease(KeyEvent.VK_DEAD_TILDE);
//                break;
            default:
                r.keyPress(KeyEvent.VK_F);
                r.keyRelease(KeyEvent.VK_F);
                break;
        }
        Thread.sleep(0);
    }
}
