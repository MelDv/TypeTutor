/*
 * This class tests the Basic class.
 */
package fi.maaretdufva.logiikka;

import fi.maaretdufva.logic.Basic;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maaret
 */
public class BasicTest {

    static Basic b;

    @Before
    public void setUp() {
        b = new Basic(0);
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
    public void jfJosLevel0() {
        assertEquals(b.getLevel(), 0);
    }

}
