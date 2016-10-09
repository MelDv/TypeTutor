package fi.maaretdufva.users;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This is a test class for AllUsers class.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class AllUsersTest {

    static AllUsers au;
    static User user;
    static User user1;
    static User user2;
    static Map<String, User> all;

    @Before
    public void setUp() {
        user = new User("Matti");
        user1 = new User("Riina");
        user2 = new User("Kaija");
        au = new AllUsers(user);
        all = new HashMap<>();
        all.put(user.getUsername(), user);
    }

    @Test
    public void getUsersReturnsMapOfUsers() {
        assertEquals(au.getUsers(), all);
        au.addUser(user1);
        all.put("Riina", user1);
        assertEquals(au.getUsers(), all);
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
    public void findUserGivesCorrectBoolean() {
        if (au.findUser("Pekka")) {
            fail();
        }
        assertTrue(au.findUser("Matti") == true);
    }

    @Test
    public void updateUserUpdatesUser() {
        au.updateUser("Matti", user2);
        if (au.findUser("Matti")) {
            fail();
        }
        if (!au.findUser("Kaija")) {
            fail();
        }
    }

    @Test
    public void numberOfUsersGivesCorrectNummber() {
        au.addUser(user1);
        assertEquals(au.numberOfUsers(), 2);
        au.deleteUser(user);
        au.deleteUser(user1);
        assertEquals(au.numberOfUsers(), 0);
    }

    @Test
    public void toStringReturnsCorrectString() {
        au.deleteUser(user);
        assertEquals("This user list is empty", au.toString());
    }
}
