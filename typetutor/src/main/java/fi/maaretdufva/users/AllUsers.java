package fi.maaretdufva.users;

import java.util.HashMap;
import java.util.Map;

/**
 * This class remembers all users.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class AllUsers {

    private User user;
    private Map<String, User> all;

    /**
     * Constructor. Creates a user and a hashmap for stroring them. Adds the
     * parameter user to the map.
     *
     * @param user When the first user is created, the user is given as a
     * parameter to create a list of users.
     */
    public AllUsers(User user) {
        this.user = user;
        this.all = new HashMap<>();
        this.all.put(user.getUsername(), user);
    }

    /**
     * Constructor.
     */
    public AllUsers() {
    }

    public Map getUsers() {
        return this.all;
    }

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
        if (this.all == null) {
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

    @Override
    public String toString() {
        StringBuilder userlist = new StringBuilder();
        if (all.isEmpty()) {
            return "This user list is empty";
        }

        for (int i = 0; i < all.size(); i++) {
            userlist.append(user.toString() + "\n");
        }
        return userlist.toString();
    }
}
