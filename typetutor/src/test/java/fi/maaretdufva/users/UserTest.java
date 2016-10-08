/*
 * This is a test class for User
 */
package fi.maaretdufva.users;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maaret
 */
public class UserTest {

    static User t;

    @Before
    public void setUp() {
        t = new User("name");
    }

    @Test
    public void constructorSetsUsername() {
        assertEquals(t.getUsername(), "name");
    }

    public void setAllSetsCorrectInfo() {
        t.setAll("Elli", "Etana", "etana@posti.fi");
        assertEquals(t.getFirstname(), "Elli");
        assertEquals(t.getLastname(), "Etana");
        assertEquals(t.getEmail(), "etana@posti.fi");
    }

    public void testPassword() {
        t.setPassword("ji874kjlKKiirt9");
        assertEquals(t.testPassword("ji874kjlKKiirt9"), true);
        t.setPassword("ji874kjlKKiirt9");
        assertEquals(t.testPassword("ji874kjlKiirt9"), false);
    }

    @Test
    public void toStringReturnsCorrectOutput() {
        String syote = "name:  , points: 0\n email: ";
        assertEquals(syote, t.toString());
    }

    @Test
    public void toStringReturnsCorrectOutput1() {
        t.setFirstname("Ville");
        t.setLastname("Virta");
        t.setPoints(7);
        t.setEmail("juu@huu.fi");
        String syote = "name: Ville Virta, points: 7\n email: juu@huu.fi";
        assertEquals(syote, t.toString());
    }

    public void countLevelbyPointsCountsLevelinCorrectly() {
        t.setPoints(344);
        assertEquals(t.countLevelbyPoints(), 3);
        //add more tests
    }

    @Test
    public void addPointAddsPoint() {
        t.setPoints(8);
        t.addPoint();
        t.addPoint();
        assertEquals(10, t.getPoints());
        t.addPoint();
        t.addPoint();
        t.addPoint();
        assertEquals(13, t.getPoints());
    }

    @Test
    public void deductPointDeductsPoint() {
        t.setPoints(8);
        t.deductPoint();
        t.deductPoint();
        assertEquals(6, t.getPoints());
        t.deductPoint();
        assertEquals(5, t.getPoints());
    }

    @Test
    public void constructorSetsLevel() {
        assertEquals(t.countLevelbyPoints(), 0);
    }

    @Test
    public void setterSetsLevel() {
        t.setLevel(18);
        assertEquals(t.countLevelbyPoints(), 18);
    }

    @Test
    public void getterReturnsLevel() {
        t.setLevel(7);
        int level = t.countLevelbyPoints();
        assertEquals(level, 7);
    }
}
