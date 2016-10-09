package fi.maaretdufva.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class test the Turorial class.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class TutorialTest {

    static Tutorial tut;

    @Before
    public void setUp() {
        tut = new Tutorial();
    }

    @Test
    public void letterTutorialsPrintsGuides() {
        assertEquals(tut.letterTutorials(0), "Nakuta äffää ja jiitä etusormilla.");
    }
    // More added when the Tutorial class grows.
}
