/*
 * This is a test class for AllUsers class.
 */
package fi.maaretdufva.users;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Maaret
 */
public class AllUsersTest {

    static AllUsers au;
    static User user;
    static User user1;
    static Map<String, User> map;

    @Before
    public void setUp() {
        user = new User("Matti");
        user1 = new User("Riina");
        au = new AllUsers(user);
        map = new HashMap<>();
        map.put(user.getUsername(), user);
    }

    @Test
    public void addUserAddsUser() {
        au.addUser(user1);
        assertEquals(au.getUser("Riina"), user1);
    }

    @Test
    public void deleteUserDeletesUser() {
        au.deleteUser(user1);
        if (au.findUser(user1.getUsername())) {
            fail();
        }
    }

    @Test
    public void numberOfUsersGivesCorrectNummber() {
        au.addUser(user1);
        assertEquals(au.numberOfUsers(), 2);
    }

    @Test
    public void getUsersReturnsMapOfUsers() {
        assertEquals(au.getUsers(), map);
    }

    @Test
    public void findUserGivesCorrectBoolean() {
        if (au.findUser("Pekka")) {
            fail();
        }
        assertTrue(au.findUser("Matti") == true);
    }

    @Test
    public void updateUserUpdatesUser() {
        User user2 = new User("Kaija");
        au.updateUser("Matti", user2);
        if (au.findUser("Matti")) {
            fail();
        }
        if (!au.findUser("Kaija")) {
            fail();
        }
    }
}
