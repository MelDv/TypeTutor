/*
 * This is a test class for Game.
 * @author Maaret Dufva
 */
package fi.maaretdufva.logiikka;

import fi.maaretdufva.users.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    static Game g;
    static User u;
    static Basic b;

    @Before
    public void setUp() {
        u = new User("nimi");
        g = new Game(u);
        b = new Basic(0);
    }

    @Test
    public void start() {
        assertEquals(u.getLevel(), 0);
    }

    @Test
    public void start2() {
        u.setLevel(2);
        assertEquals(u.getLevel(), 2);
    }

    @Test
    public void startToiminto() {
        if (u.getLevel() < 0) {
            fail();
        }
    }

}
