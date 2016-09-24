/*
 * This is a test class for Game.
 * @author Maaret Dufva
 */
package fi.maaretdufva.logiikka;

import fi.maaretdufva.logic.Level;
import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    static Game g;
    static User u;
    static Level b;

    @Before
    public void setUp() {
        u = new User("nimi");
        g = new Game(u);
        b = new Level();
    }



}
