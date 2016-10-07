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
        this.typeThis = "";
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
        if (user == null || user.getPoints() == 0) {
            OnBoarding begin = new OnBoarding();
            begin.start();
        } else {
            determineLevel();
            System.out.println(level);
            determineTypeThis();
            System.out.println(typeThis);
            sendToListener();
        }
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
        if (typeThis == null || typeThis.length() == 0) {
            determineLevel();
            determineTypeThis();
        }

        char typeLetter = typeThis.charAt(0);
        typeThis = typeThis.substring(1);
        return typeLetter;
    }

    public String getTypeThis() {
        return typeThis;
    }
}
