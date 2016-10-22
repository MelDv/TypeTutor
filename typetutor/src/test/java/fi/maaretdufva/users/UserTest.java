package fi.maaretdufva.users;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    static User t;
    
    @Before
    public void setUp() {
        t = new User("name");
    }
    
    @Test
    public void constructorSetsUsername() {
        assertEquals(t.getUsername(), "name");
    }
    
    @Test
    public void constructorSetsLevel() {
        assertEquals(t.getLevel(), 0);
    }
    
    @Test
    public void constructorSetsPassword() {
        char[] a = t.getPassword();
        String p = new String(a);
        assertEquals(p, "1234");
    }
    
    @Test
    public void constructorSetsPoints() {
        assertEquals(t.getPoints(), 0);
    }
    
    @Test
    public void addPointAddsPoint() {
        t.setPoints(8);
        t.addPoint();
        t.addPoint();
        assertEquals(10, t.getPoints());
        t.addPoint();
        t.addPoint();
        t.addPoint();
        assertEquals(13, t.getPoints());
    }
    
    @Test
    public void deductPointDeductsPoint() {
        t.setPoints(8);
        t.deductPoint();
        t.deductPoint();
        assertEquals(6, t.getPoints());
        t.deductPoint();
        assertEquals(5, t.getPoints());
    }
    
    public void testPassword() {
        char[] temp = {'d', '4', 't', 'R'};
        t.setPassword(temp);
        assertEquals(t.testPassword(temp), true);
        char[] temp1 = {'d', '4', 't', 'r'};
        assertEquals(t.testPassword(temp1), false);
        char[] temp2 = {'Ö'};
        t.setPassword(temp2);
        assertEquals(t.testPassword(temp2), true);
        char[] temp3 = {'ä'};
        assertEquals(t.testPassword(temp3), false);
        char[] temp4 = {'d', '4', 't', 'R', ',', '4', 'T', '!'};
        t.setPassword(temp);
        assertEquals(t.testPassword(temp4), true);
        char[] temp5 = {',', '4', 'T', '!'};
        assertEquals(t.testPassword(temp5), false);
    }
    
    public void countLevelbyPointsCountsLevelinCorrectly() {
        t.setPoints(-7744);
        assertEquals(t.countLevelbyPoints(), -38);
        t.setPoints(-77);
        assertEquals(t.countLevelbyPoints(), 0);
        t.setPoints(344);
        assertEquals(t.countLevelbyPoints(), 1);
        t.setPoints(555);
        assertEquals(t.countLevelbyPoints(), 2);
        t.setPoints(777);
        assertEquals(t.countLevelbyPoints(), 3);
        t.setPoints(-55555);
        assertEquals(t.countLevelbyPoints(), 3);
        t.setPoints(2000);
        assertEquals(t.countLevelbyPoints(), 10);
        t.setPoints(3440);
        assertEquals(t.countLevelbyPoints(), 17);
        t.setPoints(344000);
        assertEquals(t.countLevelbyPoints(), 1720);
    }
    
    @Test
    public void setterSetsLevel() {
        t.setLevel(18);
        assertEquals(t.getLevel(), 18);
    }
    
    @Test
    public void getterReturnsLevel() {
        t.setLevel(7);
        int level = t.getLevel();
        assertEquals(level, 7);
    }
    
    @Test
    public void testPasswordWorks() {
        char c[] = {'r', 'Y', '3'};        
        assertFalse(t.testPassword(c));
        t.setPassword(c);
        assertTrue(t.testPassword(c));
    }
}
