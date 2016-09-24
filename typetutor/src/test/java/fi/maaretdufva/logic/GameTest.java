/*
 * This is a test class for Game.
 * @author Maaret Dufva
 */
package fi.maaretdufva.logic;

import fi.maaretdufva.logic.Level;
import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    static Game g;
    static User u;
    static String s;

    @Before
    public void setUp() {
        u = new User("nimi");
        g = new Game(u);
        s = "Testaus";
    }

    @Test
    public void addPointAddsPoint() {
        u.setPoints(8);
        g.addPoint();
        g.addPoint();
        assertEquals(10, u.getPoints());
        g.addPoint();
        g.addPoint();
        g.addPoint();
        assertEquals(13, u.getPoints());
    }

    @Test
    public void deductPointDeductsPoint() {
        u.setPoints(8);
        g.deductPoint();
        g.deductPoint();
        assertEquals(6, u.getPoints());
        g.deductPoint();
        assertEquals(5, u.getPoints());
    }
}
