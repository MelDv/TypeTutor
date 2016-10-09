package fi.maaretdufva.logic;

import fi.maaretdufva.users.User;

/**
 * This is the main logic class.
 * <p>
 * This class creates characters and strings for the gui and user. It sends them
 * to the listener and determines which level the user is currently on.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class Game {

    private User user;
    private String typeThis;
    private int level;
    private char typeLetter;

    public Game(User givenUser) {
        this.user = givenUser;
        this.typeThis = null;
        this.level = 0;
        this.typeLetter = 's';
    }

    public Game() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void start() {
        determineLevel();
        sendToListener();
    }

    public int determineLevel() {
        if (this.level != user.countLevelbyPoints()) {
            this.level = user.countLevelbyPoints();
            if (level < 0) {
                level = 0;
            }
            if (level > 17) {
                level = 17;
            }
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

    public char getKey() {
        return typeThis.charAt(0);
    }

    public String getTypeThis() {
        return typeThis;
    }
}
