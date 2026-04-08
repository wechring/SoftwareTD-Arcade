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

    // tests for invalid rows and columns
    //
    @Test
    void testInvalidUpperBoundRow() {
        // create board with 15 rows, 10 columns
        Location upperRow = new Location(15, 5);
        assertFalse(board.isValid(upperRow));
    }

    //
    @Test
    void testInvalidLowerBoundRow() {
        Location lowerRow = new Location(-1, 5);
        assertFalse(board.isValid(lowerRow));
    }

    //
    @Test
    void testInvalidUpperBoundColumn() {
        Location upperRow = new Location(5, 10);
        assertFalse(board.isValid(upperRow));
    }

    //
    @Test
    void testInvalidLowerBoundColumn() {
        Location lowerRow = new Location(5, -1);
        assertFalse(board.isValid(lowerRow));
    }

    // EP TESTS

    //
    @Test
    void testPutValidLocation() {
        assertNull(board.put(valid, block));
        assertEquals(block, board.get(valid)); // block should be in apprpriate location
    }

    //
    @Test
    void testPutInvalidLocation() {
        assertThrows(IllegalArgumentException.class, () -> board.put(invalid, block));
    }
}
