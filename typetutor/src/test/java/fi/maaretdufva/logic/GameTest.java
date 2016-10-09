package fi.maaretdufva.logic;

import fi.maaretdufva.users.User;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    static Game g;
    static User u;

    @Before
    public void setUp() {
        u = new User("nimi");
        g = new Game(u);
    }

    @Test
    public void determineLevel() {
        assertEquals(0, g.determineLevel());
        u.setLevel(0);
        assertEquals(0, g.determineLevel());
        u.setPoints(-555);
        assertEquals(0, g.determineLevel());
        u.setPoints(256);
        assertEquals(1, g.determineLevel());
        u.setPoints(0);
        assertEquals(1, g.determineLevel());
        u.setPoints(200);
        assertEquals(1, g.determineLevel());
        u.setPoints(270);
        assertEquals(1, g.determineLevel());
        u.setPoints(874);
        u.setLevel(12);
        assertEquals(12, g.determineLevel());
        u.setPoints(3000);
        assertEquals(15, g.determineLevel());
        u.setPoints(5800);
        assertEquals(17, g.determineLevel());
        u.setPoints(17040);
        assertEquals(17, g.determineLevel());
        u.setLevel(44);
        assertEquals(17, g.determineLevel());
    }

    @Test
    public void sendToListenerReturnsCorrectly() {
        char test = 'S';
        test = g.sendToListener();
        assertEquals(test, 'j', 'f');
    }

    public void sendToListenerReturnsCorrectly1() {
        char test;
        u.setLevel(14);
        test = g.sendToListener();
        assertEquals(test, anyOf(is('o'), is('w'), is('x'), is('.')));
    }

    public void sendToListenerReturnsCorrectly2() {
        char test;
        u.setLevel(5);
        test = g.sendToListener();
        assertEquals(test, anyOf(is('u'), is('r'), is('m'), is('v')));
    }

    public void sendToListenerReturnsCorrectly3() {
        char test;
        u.setLevel(16);
        test = g.sendToListener();
        assertEquals(test, anyOf(is('p'), is('q'), is('z'), is('-')));
    }
}
