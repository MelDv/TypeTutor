/*
 * This is a test class for Game.
 * @author Maaret Dufva
 */
package fi.maaretdufva.logic;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    static Game g;
    static User u;
    static String s;
    static int level;

    @Before
    public void setUp() {
        u = new User("nimi");
        g = new Game(u);
        s = "Testaus";
        level = 0;
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
}
