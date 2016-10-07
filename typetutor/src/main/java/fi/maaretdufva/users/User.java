/*
 * This is the main class for individual users.
 */
package fi.maaretdufva.users;

import java.util.Scanner;

/**
 *
 * @author Maaret
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

    public void setEtunimi(String newFirstname) {
        this.firstname = newFirstname;
    }

    public void setUsername(String newName) {
        this.username = newName;
    }

    public void setSukunimi(String newLastname) {
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

    public int getLevel() {
        if (points < 200) {
            level = 0;
        } else {
            level = points / 200;
        }
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
                + this.lastname + ", pisteet: " + this.points + "\n sähköposti: " + this.email;
    }
}
