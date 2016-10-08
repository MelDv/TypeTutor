/*
 * This class remembers all users.
 */
package fi.maaretdufva.users;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maaret
 */
public class AllUsers {

    private User user;
    private Map<String, User> all;

    public AllUsers(User user) {
        this.user = user;
        this.all = new HashMap<>();
        this.all.put(user.getUsername(), user);
    }

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

    public void addUser(User addThis) {
        this.all.put(addThis.getUsername(), addThis);
    }

    public void deleteUser(User deleteMe) {
        this.all.remove(deleteMe.getUsername());
    }

    public boolean findUser(String username) {
        if (this.all == null) {
            return false;
        }
        if (this.all.containsKey(username)) {
            return true;
        }
        return false;
    }

    public void updateUser(String oldUsername, User user) {
        if (!this.all.containsKey(oldUsername)) {
            addUser(user);
        }
        this.all.remove(oldUsername);
        this.all.put(user.getUsername(), user);
    }

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
