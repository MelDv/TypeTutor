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
        assertEquals(t.getUsername(), "nimi");
    }

    public void setAllAsettaaTiedot() {
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
    public void toStringPalauttaaOikeanSyotteen() {
        String syote = "nimi:  , pisteet: 0\n sähköposti: ";
        assertEquals(syote, t.toString());
    }

    public void getLevelLaskeeLevelinOikein() {
        t.setPoints(344);
        assertEquals(t.getLevel(), 3);
    }

    @Test
    public void toStringPalauttaaOikeanSyotteen1() {
        t.setEtunimi("Ville");
        t.setSukunimi("Virta");
        t.setPoints(7);
        t.setEmail("juu@huu.fi");
        String syote = "nimi: Ville Virta, pisteet: 7\n sähköposti: juu@huu.fi";
        assertEquals(syote, t.toString());
    }

//    @Test
//    public void konstruktoriAsettaaLevelin() {
//        assertEquals(b.getLevel(), 0);
//    }
//
//    @Test
//    public void setteriAsettaaLevelin() {
//        b.setLevel(18);
//        assertEquals(b.getLevel(), 18);
//    }
//
//    @Test
//    public void getteriAntaaLevelin() {
//        b.setLevel(7);
//        int level = b.getLevel();
//        assertEquals(level, 7);
//    }
//
//    @Test
//    public void determineLevel() {
//        b.determineLevel(333);
//        assertEquals(b.getLevel(), 1);
//        b.determineLevel(100);
//        assertEquals(b.getLevel(), 0);
//        b.determineLevel(200);
//        assertEquals(b.getLevel(), 1);
//        b.determineLevel(4145);
//        assertEquals(b.getLevel(), 20);
//        b.determineLevel(444);
//        assertEquals(b.getLevel(), 2);
//        b.determineLevel(-333);
//        assertEquals(b.getLevel(), 0);
//        b.determineLevel(0);
//        assertEquals(b.getLevel(), 0);
    
}
