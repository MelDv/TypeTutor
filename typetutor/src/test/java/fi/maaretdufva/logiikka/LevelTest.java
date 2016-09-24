/*
 * This class tests the Level class.
 */
package fi.maaretdufva.logiikka;

import fi.maaretdufva.logic.Level;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maaret
 */
public class LevelTest {

    static Level b;

    @Before
    public void setUp() {
        b = new Level();
    }

    @Test
    public void konstruktoriAsettaaLevelin() {
        assertEquals(b.getLevel(), 0);
    }

    @Test
    public void setteriAsettaaLevelin() {
        b.setLevel(18);
        assertEquals(b.getLevel(), 18);
    }

    @Test
    public void getteriAntaaLevelin() {
        b.setLevel(7);
        int level = b.getLevel();
        assertEquals(level, 7);
    }

    @Test
    public void determineLevel() {
        b.determineLevel(333);
        assertEquals(b.getLevel(), 1);
        b.determineLevel(100);
        assertEquals(b.getLevel(), 0);
        b.determineLevel(200);
        assertEquals(b.getLevel(), 1);
        b.determineLevel(4145);
        assertEquals(b.getLevel(), 20);
        b.determineLevel(444);
        assertEquals(b.getLevel(), 2);
        b.determineLevel(-333);
        assertEquals(b.getLevel(), 0);
        b.determineLevel(0);
        assertEquals(b.getLevel(), 0);
    }

}
