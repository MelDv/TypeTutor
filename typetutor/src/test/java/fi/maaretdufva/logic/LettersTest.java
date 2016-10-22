package fi.maaretdufva.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LettersTest {

    static Letters lt;
    static String s;

    @Before
    public void setUp() {
        lt = new Letters();
        s = "";
    }

    @Test
    public void determineStringGivesCorrectString() {
        String typ = lt.determineString(3);

        for (int i = 0; i < typ.length(); i++) {
            if (typ.charAt(i) != 'l' || typ.charAt(i) != 's') {
                assertFalse(false);
            } else {
                assertTrue(true);
            }
        }

        typ = lt.determineString(11);
        for (int i = 0; i < typ.length(); i++) {
            if (typ.charAt(i) != 'r' || typ.charAt(i) != 'u') {
                assertFalse(false);
            } else {
                assertTrue(true);
            }
        }
    }

    @Test
    public void determineStringUsesCorrectLetters() {
        lt.determineString(-22);
        assertEquals(lt.getLetters(), "jf");
        lt.determineString(0);
        assertEquals(lt.getLetters(), "jf");
        lt.determineString(4);
        assertEquals(lt.getLetters(), "jfkdls");
        lt.determineString(7);
        assertEquals(lt.getLetters(), "hg");
        lt.determineString(10);
        assertEquals(lt.getLetters(), "hgjfkdlsööaaää");
        lt.determineString(16);
        assertEquals(lt.getLetters(), "jfkdlsööaaatyyruueeeii");
        lt.determineString(24);
        assertEquals(lt.getLetters(), "mvcxznb");
        lt.determineString(25);
        assertEquals(lt.getLetters(), "jfkdlsööaaaatyruuueeeeiiioowpqåmvcxznb");
        lt.determineString(66);
        assertEquals(lt.getLetters(), "jfkdlsööaaaatyruuueeeeiiioowpqåmvcxznb");
    }

    @Test
    public void determineLevelGivesCorrectLevel() {
        assertEquals(lt.determineLevel(-99), 0);
        assertEquals(lt.determineLevel(0), 0);
        assertEquals(lt.determineLevel(1), 1);
        assertEquals(lt.determineLevel(15), 15);
        assertEquals(lt.determineLevel(25), 25);
        assertEquals(lt.determineLevel(26), 25);
        assertEquals(lt.determineLevel(30), 25);
        assertEquals(lt.determineLevel(99), 25);
        assertEquals(lt.determineLevel(19845), 25);
    }

    @Test
    public void randomStringGivesCorrectStringLength() {
        lt.determineString(0);
        String[] temp = lt.randomString();
        assertEquals(temp.length, 15);
        String word = temp[5];
        assertEquals(word.length(), 4);
        lt.determineString(2);
        temp = lt.randomString();
        word = temp[5];
        assertEquals(word.length(), 4);
        lt.determineString(7);
        temp = lt.randomString();
        word = temp[5];
        assertEquals(word.length(), 4);
        lt.determineString(13);
        temp = lt.randomString();
        word = temp[5];
        assertEquals(word.length(), 4);
        lt.determineString(14);
        temp = lt.randomString();
        word = temp[5];
        assertEquals(word.length(), 4);
        lt.determineString(21);
        temp = lt.randomString();
        word = temp[5];
        assertEquals(word.length(), 4);
    }

    @Test
    public void randomStringLastCharNotSpace() {
        lt.determineString(-8);
        String[] temp = lt.randomString();
        String word = temp[7];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(2);
        temp = lt.randomString();
        word = temp[14];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(8);
        temp = lt.randomString();
        word = temp[0];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(13);
        temp = lt.randomString();
        word = temp[5];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(17);
        temp = lt.randomString();
        word = temp[14];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(22);
        temp = lt.randomString();
        word = temp[11];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(26);
        temp = lt.randomString();
        word = temp[3];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(44);
        temp = lt.randomString();
        word = temp[1];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
        lt.determineString(15783);
        temp = lt.randomString();
        word = temp[4];
        if (word.charAt(word.length() - 1) == ' ') {
            fail();
        }
    }

    @Test
    public void randomStringFirstCharNotSpace() {
        lt.determineString(-8);
        String[] temp = lt.randomString();
        String word = temp[0];
        if (word.charAt(0) == ' ') {
            fail();
        }
        lt.determineString(2);
        temp = lt.randomString();
        word = temp[0];
        if (word.charAt(0) == ' ') {
            fail();
        }
        lt.determineString(4);
        temp = lt.randomString();
        word = temp[0];
        if (word.charAt(0) == ' ') {
            fail();
        }
        lt.determineString(16);
        temp = lt.randomString();
        word = temp[0];
        if (word.charAt(0) == ' ') {
            fail();
        }
        lt.determineString(25);
        temp = lt.randomString();
        word = temp[0];
        if (word.charAt(0) == ' ') {
            fail();
        }
        lt.determineString(15783);
        temp = lt.randomString();
        word = temp[0];
        if (word.charAt(0) == ' ') {
            fail();
        }
    }
}
