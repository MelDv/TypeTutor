/*
 * The main class for the program.
 * @author md
 */
package fi.maaretdufva.logic;

import fi.maaretdufva.users.AllUsers;
import fi.maaretdufva.users.User;

public class Game {

    private User user;
    private AllUsers all;
    private String typeThis;
    private int level;

    public Game(User givenUser) {
        this.user = givenUser;
        this.all = new AllUsers(user);
        this.typeThis = null;
        this.level = 0;
        System.out.println(user.getPoints());
    }

    public Game() {
        start();
    }

    public User myUser() {
        return this.user;
    }

    public void start() {
        determineLevel();
        sendToListener();
    }

    public int determineLevel() {
        if (this.level != user.getLevel()) {
            this.level = user.getLevel();
            Tutorial tut = new Tutorial();
            tut.letterTutorials(level);
        }
        return this.level;
    }

    public void determineTypeThis() {
        Letters letters = new Letters();
        typeThis = letters.determineString(level);
    }

    public char sendToListener() {
        char typeLetter = 's';

        if (typeThis == null) {
            determineLevel();
            determineTypeThis();
            typeLetter = typeThis.charAt(0);
            return typeLetter;
        } else if (typeThis.length() == 1) {
            typeLetter = typeThis.charAt(0);
            determineLevel();
            determineTypeThis();
            return typeLetter;
        }

        typeLetter = typeThis.charAt(0);
        typeThis = typeThis.substring(1);
        return typeLetter;
    }

    public String getTypeThis() {
        return typeThis;
    }
}
