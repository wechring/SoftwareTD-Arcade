package tetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {
    Location locationOne;
    Location locationTwo;
    Location locationThree;

    @BeforeEach
    void setUp() {
        locationOne = new Location(1, 2);
        locationTwo = new Location(2, 3);
        locationThree = new Location(3, 4);
    }

    // tests that getRow and getCol returns the right values
    @Test
    public void testGetter() {
        assertEquals(1, locationOne.getRow());
        assertEquals(2, locationOne.getCol());
    }

    // tests that equals correctly compares two of the
    // same locations
    @Test
    public void testEqualsSameLocation() {
        Location location = new Location(1, 2);

        assertTrue(location.equals(locationOne));
        assertEquals(location.hashCode(), locationOne.hashCode());
    }

    // tests that equals correctly compares two different
    // locations
    @Test
    public void testEqualsDifferentLocation() {
        assertFalse(locationOne.equals(locationTwo));
        assertFalse(locationOne.equals(locationThree));
        assertFalse(locationTwo.equals(locationThree));
        assertNotEquals(locationOne.hashCode(), locationTwo.hashCode());
    }

    // tests that compareTo correctly compares the row values
    @Test
    public void testCompareToRows() {
        Location location = new Location(1, 2);

        assertEquals(0, location.compareTo(locationOne));
        assertTrue(locationOne.compareTo(locationTwo) < 0);
        assertTrue(locationThree.compareTo(locationOne) > 0);
    }

    // tests that compareTo correctly compares the column values
    @Test
    public void testCompareToCols() {
        Location location = new Location(1, 2);

        assertEquals(0, location.compareTo(locationOne));
        assertTrue(locationOne.compareTo(locationTwo) < 0);
        assertTrue(locationThree.compareTo(locationOne) > 0);
    }

    // tests that toString works as expected
    @Test
    public void testToString() {
        assertEquals("(1, 2)", locationOne.toString());
    }
}
