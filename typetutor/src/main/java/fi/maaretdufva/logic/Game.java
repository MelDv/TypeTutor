/*
 * The main class for the program.
 * @author md
 */
package fi.maaretdufva.logic;

import fi.maaretdufva.users.User;

public class Game {

    //TÄMÄ ON KESKENERÄINEN LUOKKA.
    private OnBoarding begin;
    private Level level;
    private User user;

    public Game(User user) {
        this.user = user;
    }

    public Game() {
    }

    public void start() {
        int points = user.getPoints();
        if (user == null || user.getPoints() == 0) {
            begin.start();
        }
    }

    public char sendToListener() {
        char typeThis = 'f';

        return typeThis;
    }

    public void newCharacter(boolean piste) {
        if (piste) {
            
        }
    }

}
