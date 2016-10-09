package fi.maaretdufva.users;

/**
 * This is a class for individual users.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class User {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int points;
    private int level;

    /**
     * Constructor.
     *
     * @param username Given by user.
     */
    public User(String username) {
        this.username = username;
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.password = "1234";
        this.points = 0;
        this.level = 0;
    }

    /**
     * Sets several parameters for the user: first and last name and email.
     *
     * @param firtsname Given by user as a String.
     * @param lastname Given by user as a String.
     * @param email Given by user as a String.
     */
    public void setAll(String firtsname, String lastname, String email) {
        this.firstname = firtsname;
        this.lastname = lastname;
        this.email = email;
    }

    public void setFirstname(String newFirstname) {
        this.firstname = newFirstname;
    }

    public void setUsername(String newName) {
        this.username = newName;
    }

    public void setLastname(String newLastname) {
        this.lastname = newLastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
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
    public boolean testPassword(String testThis) {
        if (this.password.equals(testThis)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.username + ": " + this.firstname + " "
                + this.lastname + ", points: " + this.points + "\n email: " + this.email;
    }
}
