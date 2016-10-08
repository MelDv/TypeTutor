/*
 * This class tests how the gui works by using automation.
 */
package robots;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Maaret
 */
public class RobotTest {
    //You need to run the program first and then this file.

    private char type;

    public RobotTest() {
        this.type = 's';
    }

    public static void main(String args[]) throws Exception {
        {
            Robot r = new Robot();
            r.mouseMove(300, 220);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            Thread.sleep(20);
            r.keyPress(10);
            r.keyRelease(10);
        }
    }

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
