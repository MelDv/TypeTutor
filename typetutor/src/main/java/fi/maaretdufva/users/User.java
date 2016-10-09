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

    public User(String username) {
        this.username = username;
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.password = "1234";
        this.points = 0;
        this.level = 0;
    }

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

    public void addPoint() {
        setPoints(getPoints() + 1);
    }

    public void deductPoint() {
        setPoints(getPoints() - 1);
    }

    public int countLevelbyPoints() {
        //level can only grow
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
