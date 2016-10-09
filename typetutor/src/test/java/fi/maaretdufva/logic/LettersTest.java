package fi.maaretdufva.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests that the Letters class works properly.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class LettersTest {

    static Letters lt;
    static String s;

    @Before
    public void setUp() {
        lt = new Letters();
        s = "";
    }

    @Test
    public void determineStringGivesRightString() {
        assertTrue(stringTest(lt.determineString(-22), "jf"));
        assertTrue(stringTest(lt.determineString(0), "jf"));
        assertTrue(stringTest(lt.determineString(10), "mv"));
        assertTrue(stringTest(lt.determineString(4), "jfkdls"));
        assertTrue(stringTest(lt.determineString(7), "jfkdlsöa"));
        assertTrue(stringTest(lt.determineString(16), "pqz-"));
    }

    @Test
    public void randomStringGivesCorrectStringLength() {
        String temp = lt.randomString("jf", 3);
        assertEquals(temp.length(), 39);
        temp = lt.randomString("jfkdlsöaru", 5);
        assertEquals(temp.length(), 59);
        temp = lt.randomString("jfkdlsöarumv", 15);
        assertEquals(temp.length(), 159);
        temp = lt.randomString("urmv", 3);
        assertEquals(temp.length(), 39);
    }

    @Test
    public void randomStringLastCharNotSpace() {
        String temp = lt.randomString("jf", 3);
        if (temp.charAt(temp.length() - 1) == ' ') {
            fail();
        }
        temp = lt.randomString("jfkdlsöarumviecxow,.pqz-", 6);
        if (temp.charAt(temp.length() - 1) == ' ') {
            fail();
        }
        temp = lt.randomString("urmv", 2);
        if (temp.charAt(temp.length() - 1) == ' ') {
            fail();
        }
        temp = lt.randomString("öa", 10);
        if (temp.charAt(temp.length() - 1) == ' ') {
            fail();
        }
    }

    @Test
    public void randomStringFirstCharNotSpace() {
        String temp = lt.randomString("jf", 3);
        if (temp.charAt(0) == ' ') {
            fail();
        }
        temp = lt.randomString("jfkdlsöarumv", 1);
        if (temp.charAt(0) == ' ') {
            fail();
        }
        temp = lt.randomString("iec", 4);
        if (temp.charAt(0) == ' ') {
            fail();
        }
        temp = lt.randomString("owx.", 10);
        if (temp.charAt(0) == ' ') {
            fail();
        }
    }

    private boolean stringTest(String testThis, String original) {
        String temp = "";

        for (int i = 0; i < testThis.length(); i++) {
            String letter = String.valueOf(testThis.charAt(i));
            if (original.contains(letter) && !temp.contains(letter)) {
                temp = temp + letter;
            }
        }
        if (temp.length() == original.length()) {
            return true;
        }
        return false;
    }
}
