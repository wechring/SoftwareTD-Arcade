package tetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {
    private MyBoundedGrid<Block> grid;
    private Block block;
    private Location location;

    @BeforeEach
   void setUp() {
        grid = new MyBoundedGrid<>(10, 10);
        block = new Block();
        location = new Location(1,1);
    }

    // tests that the block starts off at the default color (blue)
    @Test
    void testGetColorDefault() {
        assertEquals(Color.BLUE, block.getColor());
    }

    // tests that getColor returns the correct color after the
    // block color is changed
    @Test
    void testGetColorChanged() {
        block.setColor(Color.RED);
        assertEquals(Color.RED, block.getColor());
    }

    // tests that the setColor correctly changes the color of
    // the block each time
    @Test
    void testSetColorChanged() {
        block.setColor(Color.RED);
        assertEquals(Color.RED, block.getColor());

        block.setColor(Color.BLUE);
        assertEquals(Color.BLUE, block.getColor());

        block.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, block.getColor());
    }

    // tests that putting a block on the grid returns the
    // correct location of the block
    @Test
    void testPutOnGrid() {
        block.putSelfInGrid(grid, location);
        assertEquals(location, block.getLocation());
        assertEquals(block, grid.get(location));
    }

    // tests that removing a block from the grid wipes the
    // value of the location from the grid and returns null
    @Test
    void testRemoveBlockFromGrid() {
        block.putSelfInGrid(grid, location);
        block.removeSelfFromGrid();

        assertNull(block.getLocation());
        assertNull(grid.get(location));
    }

    // tests that moving the block to a new location correctly
    // updates its position and wipes its old location
    @Test
    void testMoveToNewLocation() {
        Location locationTwo = new Location(2,2);

        block.putSelfInGrid(grid, location);
        assertEquals(location, block.getLocation());
        assertEquals(block, grid.get(location));

        block.moveTo(locationTwo);
        assertEquals(locationTwo, block.getLocation());
        assertEquals(block, grid.get(locationTwo));
        assertNull(grid.get(location));
    }

    @Test
    void testToString() {
        block.putSelfInGrid(grid, location);
        String string = block.toString();
        assertTrue(string.contains("(1, 1)"));
        assertTrue(string.contains(block.getColor().toString()));
    }
}
