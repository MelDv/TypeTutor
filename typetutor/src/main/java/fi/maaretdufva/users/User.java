package fi.maaretdufva.users;

import java.util.Arrays;

/**
 * This is a class for individual users.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class User {

    private String username;
    private char[] password;
    private int points;
    private int level;

    /**
     * Constructor.
     *
     * @param username Given by user.
     */
    public User(String username) {
        this.username = username;
        this.password = new char[]{'1', '2', '3', '4'};
        this.points = 0;
        this.level = 0;
    }

    public void setPassword(char[] newPassword) {
        this.password = newPassword;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    /**
     * Adds a point to the user's points.
     */
    public void addPoint() {
        setPoints(getPoints() + 1);
    }

    /**
     * Deletes a point from the user's points.
     */
    public void deductPoint() {
        setPoints(getPoints() - 1);
    }

    /**
     * Counts the level by dividing user's points with 200. The level can only
     * grow.
     *
     * @return level as an integer.
     */
    public int countLevelbyPoints() {
        int temp = points / 200;
        if (level < temp) {
            level = temp;
        }
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getUsername() {
        return this.username;
    }

    public int getPoints() {
        return this.points;
    }

    /**
     * Tests whether the user has given the correct password.
     *
     * @param testThis The password given by user.
     * @return boolean value true, if the password is correct. False if not.
     */
    public boolean testPassword(char[] testThis) {
        if (testThis == null) {
            return false;
        } else if (Arrays.equals(this.password, testThis)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.username + ": " + ", points: " + this.points + "level: " + this.level;
    }
}
