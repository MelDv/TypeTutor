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
    private String learned;

    /**
     * Constructor.
     *
     * @param givenUser Gui class provides user.
     */
    public Game(User givenUser) {
        this.user = givenUser;
        this.typeThis = null;
        this.level = 0;
        this.typeLetter = 's';
        this.learned = "";
    }

    /**
     * Constructor.
     */
    public Game() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    /**
     * Determines the user's level.
     *
     * @return level as an integer.
     */
    public int determineLevel() {
        if (this.level != user.countLevelbyPoints()) {
            this.level = user.countLevelbyPoints();
            Tutorial tut = new Tutorial();
            tut.letterTutorials(level);
        }
        return this.level;
    }

    /**
     * Determines a string by calling method determineString in Letters class.
     * Saves the string into a private parameter 'typeThis'.
     */
    public void determineTypeThis() {
        Letters letters = new Letters();
        typeThis = letters.determineString(level);
    }
    
    /**
     * Determines a string of learned lettersby calling method getLearnedLetters in Letters class.
     * Saves the string into a private parameter 'learned'.
     */
    private String determineLettersLearned() {
        Letters letters = new Letters();
        this.learned = letters.getLearnedLetters(level);
        return learned;
    }

    /**
     * Takes the first character from the string to be typed and returns it. The
     * Listener class uses this method to test wheter the user has typed the
     * correct character.
     *
     * @return the character that should be typed next
     */
    public char sendToListener() {
        if (typeThis == null) {
            determineLevel();
            determineTypeThis();
            determineLettersLearned();
            typeLetter = typeThis.charAt(0);
            return typeLetter;
        } else if (typeThis.length() == 1) {
            typeLetter = typeThis.charAt(0);
            determineLevel();
            determineTypeThis();
            determineLettersLearned();
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

    public int getLevel() {
        return level;
    }

    public String getLettersLearned() {
        return this.learned;
    }
}
