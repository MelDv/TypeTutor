package fi.maaretdufva.users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class remembers all users.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class AllUsers {

    private File file;
    private Map<String, User> all;

    /**
     * Constructor. Creates a user and a hashmap for stroring them. Adds the
     * parameter user to the map. It takes users from file and stores them into
     * a file.
     *
     */
    public AllUsers() {
        file = new File("users.txt");
        if (!file.canExecute()) {
            try {
                file.createNewFile();
                System.out.println("File not created at AllUsers constructor");
            } catch (IOException ex) {
                Logger.getLogger(AllUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.all = new HashMap<>();

        readFile();
    }

    /**
     * Writes new users to file.
     */
    public void writeToFile(User user) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            if (!all.isEmpty()) {
                for (int i = 0; i < all.size(); i++) {
                    String input = all.keySet().toString();
                    writer.append(input + " \n");
                    input = new String(user.getPassword());
                    writer.append(input + " \n");
                    int points = user.getPoints();
                    input = String.valueOf(points);
                    writer.append(input + " \n");
                    input = String.valueOf(user.getLevel());
                    writer.append(input + " \n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AllUsers.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in writeToFile");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(AllUsers.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error in writeToFile writer close");
            }
        }
    }

    public Map getUsers() {
        return this.all;
    }

    /**
     * Return the user whose username is given as a parameter.
     *
     * @param username To be sought for from the map of user.
     * @return user, if it can be found from the map of users. If not, returns
     * null value.
     */
    public User getUser(String username) {
        if (all.containsKey(username)) {
            return all.get(username);
        }
        return null;
    }

    /**
     * Adds a user given as parameter to the map of users.
     *
     * @param addThis A user to be added to the map.
     */
    public void addUser(User addThis) {
        this.all.put(addThis.getUsername(), addThis);
    }

    /**
     * Deletes the user given as parameter from the map of users.
     *
     * @param deleteMe A user to be deleted from the map.
     */
    public void deleteUser(User deleteMe) {
        this.all.remove(deleteMe.getUsername());
    }

    /**
     * Tests whether the user given as parameter exists in the map of users.
     *
     * @param username A user to be sought for from the map.
     * @return boolean value true if the user is in the map; false if not.
     */
    public boolean findUser(String username) {
        if (this.all.isEmpty()) {
            return false;
        }
        if (this.all.containsKey(username)) {
            return true;
        }
        return false;
    }

    /**
     * Updates a user in the map by first deleting and then adding as a new
     * user.
     *
     * @param oldUsername The username to be used when searching for the user to
     * be deleted.
     * @param user the new user to be added to the map of users.
     */
    public void updateUser(String oldUsername, User user) {
        if (!this.all.containsKey(oldUsername)) {
            addUser(user);
        }
        this.all.remove(oldUsername);
        this.all.put(user.getUsername(), user);
    }

    /**
     * Counts the number of users in the map of users.
     *
     * @return the number of users as an integer.
     */
    public int numberOfUsers() {
        if (all.isEmpty() || all == null) {
            return 0;
        }
        return this.all.size();
    }

    /**
     * Reads the users from file and saves them to a map of users.
     */
    public void readFile() {

        try (Scanner reader = new Scanner(file)) {
            int lines = 0;
            int index = 0;
            String uname = "";
            String passw = "";
            String points = "";
            String level = "";

            while (reader.hasNext()) {
                if (index == 0) {
                    uname = reader.next();
                    index++;
                }
                if (index == 1) {
                    passw = reader.next();
                    index++;
                }
                if (index == 2) {
                    points = reader.next();
                    index++;
                }
                if (index == 3) {
                    level = reader.next();
                    index = 0;

                    User knownUser = new User(uname);
                    knownUser.setPassword(passw.toCharArray());
                    int num = Integer.parseInt(points);
                    knownUser.setPoints(num);
                    num = Integer.parseInt(level);
                    knownUser.setLevel(num);
                    all.put(uname, knownUser);

                    index = 0;
                }
                lines++;
            }
        } catch (Exception e) {
            System.out.println("Error reading file in AllUsers readFile." + e.getMessage());
        }
    }
}
