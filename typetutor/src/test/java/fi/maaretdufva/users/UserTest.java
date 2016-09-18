/*
 * This is a test class for User
 */
package fi.maaretdufva.users;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maaret Dufva
 */
public class UserTest {

    static User t;

    @Before
    public void setUp() {
        t = new User("nimi");
    }

    @Test
    public void konstruktoriAsettaaKayttajatunnuksen() {
        assertEquals(t.getKayttajanimi(), "nimi");
    }

    @Test
    public void toStringPalauttaaOikeanSyotteen() {
        String syote = "nimi:  , taso: 0\n sähköposti: ";
        assertEquals(syote, t.toString());
    }

    @Test
    public void toStringPalauttaaOikeanSyotteen1() {
        t.setEtunimi("Ville");
        t.setSukunimi("Virta");
        t.setLevel(7);
        t.setEmail("juu@huu.fi");
        String syote = "nimi: Ville Virta, taso: 7\n sähköposti: juu@huu.fi";
        assertEquals(syote, t.toString());
    }
}
