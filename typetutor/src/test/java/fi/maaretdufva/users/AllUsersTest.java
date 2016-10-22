package fi.maaretdufva.users;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
        au = new AllUsers();
        all = new HashMap<>();
        all.put(user.getUsername(), user);
    }

    //Only works if the file is empty! Tests don't read the file.
    @Test
    public void getUsersReturnsMapOfUsers() {
        au.addUser(user);
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
        au.addUser(user1);
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
        au.addUser(user);
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
        assertEquals(au.numberOfUsers(), 0);
        au.addUser(user1);
        assertEquals(au.numberOfUsers(), 1);
        au.deleteUser(user);
        au.addUser(user1);
        au.addUser(user2);
        assertEquals(au.numberOfUsers(), 2);
    }

    @Test
    public void writeFileAndReadFileWork() {
        User u = new User("Doom");
        u.setLevel(4);
        u.addPoint();
        char c[] = {'d', '2', 'R'};
        u.setPassword(c);
        au.writeToFile(user);
        au.addUser(u);
        assertEquals(au.numberOfUsers(), 1);
        assertEquals(au.getUser("Doom").getPassword(), c);
        assertEquals(au.getUser("Doom").getLevel(), 4);
        assertEquals(au.getUser("Doom").getPoints(), 1);
    }
}
