package tetris;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyBoundedGridTest {
    MyBoundedGrid<Block> board;
    Location valid;
    Location invalid;
    Block block;

    @BeforeEach
    void setUp() {
        board = new MyBoundedGrid<>(15, 10);
        valid = new Location(5, 5);
        invalid = new Location(15, 10);
        block = new Block();
    }
    // BA TESTS

    // tests for invalid upper bound row value
    @Test
    void testInvalidUpperBoundRow() {
        // create board with 15 rows, 10 columns
        Location upperRow = new Location(15, 5);
        assertFalse(board.isValid(upperRow));
    }

    // tests for invalid lower bound row value
    @Test
    void testInvalidLowerBoundRow() {
        Location lowerRow = new Location(-1, 5);
        assertFalse(board.isValid(lowerRow));
    }

    // tests for invalid upper bound column value
    @Test
    void testInvalidUpperBoundColumn() {
        Location upperRow = new Location(5, 10);
        assertFalse(board.isValid(upperRow));
    }

    // tests for invalid lower bound column value
    @Test
    void testInvalidLowerBoundColumn() {
        Location lowerRow = new Location(5, -1);
        assertFalse(board.isValid(lowerRow));
    }

    // EP TESTS

    // tests that a block is successfully placed in valid location
    @Test
    void testPutValidLocation() {
        assertNull(board.put(valid, block));
        assertEquals(block, board.get(valid)); // block should be in appropriate location
    }

    // tests that a block placed in an invalid location throws
    // IllegalArgumentException
    @Test
    void testPutInvalidLocation() {
        assertThrows(IllegalArgumentException.class, () -> board.put(invalid, block));
    }

    // tests that overwriting a block returns the old block value
    @Test
    void testOverwritePut() {
        board.put(valid, block);
        Block blockTwo = new Block();
        assertEquals(block, board.put(valid, blockTwo));
        assertEquals(blockTwo, board.get(valid));
    }

    // tests that a block is successfully removed from a valid location
    @Test
    void testRemoveValidLocation() {
       board.put(valid, block);
       assertEquals(block, board.remove(valid));
       assertTrue(board.isEmpty(valid));
    }

    // tests that a block 'removed' from an invalid location throws
    // IllegalArgumentException
    @Test
    void testRemoveInvalidLocation() {
        assertThrows(IllegalArgumentException.class, () -> board.remove(invalid));
    }

    // tests that the board is initially empty
    @Test
    void testIsEmptyOnCreation() {
        assertTrue(board.isEmpty(valid));
    }

    // tests that after removing all blocks, a board is empty
    @Test
    void testIsEmptyAfterRemoval() {
        board.put(valid, block);
        assertFalse(board.isEmpty(valid));
        board.remove(valid);
        assertTrue(board.isEmpty(valid));
    }

    // tests that an empty board has zero occupied locations
    @Test
    void testOccupiedLocationsEmptyBoard() {
        assertEquals(0, board.getOccupiedLocations().size());
    }

    // tests that a non-empty board returns the correct amount of
    // occupied locations
    @Test
    void testOccupiedLocationsNonEmptyBoard() {
        board.put(valid, block);
        board.put(new Location(3, 2), new Block());
        board.put(new Location(3, 3), new Block());
        assertEquals(3, board.getOccupiedLocations().size());

        board.remove(valid);
        assertEquals(2, board.getOccupiedLocations().size());
    }

    // tests that clearAll clears all blocks on the board
    @Test
    public void testClearAll() {
        board.put(valid, block);
        board.put(new Location(3, 2), new Block());
        assertEquals(2, board.getOccupiedLocations().size());

        board.clearAll();
        assertEquals(0, board.getOccupiedLocations().size());
        assertTrue(board.isEmpty(valid));
    }

    // EG TESTS

    // tests whether a null value is returned as invalid
    @Test
    void testNullLocationAsValid() {
        assertFalse(board.isValid(null));
    }

    // WHITEBOX TESTS

    // tests getters for dimensions work correctly
    @Test
    void testGetDimensions() {
        assertEquals(15, board.getNumRows());
        assertEquals(10, board.getNumCols());
    }

}
