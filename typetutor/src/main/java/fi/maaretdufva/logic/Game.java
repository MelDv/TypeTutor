/*
 * The main class for the program.
 * @author md
 */
package fi.maaretdufva.logic;

import fi.maaretdufva.users.User;

public class Game {
    private User user;
    private String typeThis;
    private int level;

    public Game(User user) {
        this.user = user;
        this.typeThis = "";
        this.level = user.getLevel();
    }

    public Game() {
        start();
    }

    public void start() {
        if (user == null || user.getPoints() == 0) {
            OnBoarding begin = new OnBoarding();
            begin.start();
        } else {
            sendToListener();
        }
    }

    public char sendToListener() {
        if (this.level != user.getLevel()) {
            this.level = user.getLevel();
            Tutorial tut = new Tutorial();
            tut.letterTutorials(level);
        }
        if (typeThis.isEmpty()) {
            Letters letters = new Letters();
            typeThis = letters.determineString(level);
        }

        char typeLetter = typeThis.charAt(0);
        typeThis = typeThis.substring(1);
        return typeLetter;
    }

    public void addPoint() {
        user.setPoints(user.getPoints() + 1);
    }

    public void deductPoint() {
        user.setPoints(user.getPoints() - 1);
    }

}
