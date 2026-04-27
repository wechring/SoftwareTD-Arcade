package tetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TetradTest {

    private MyBoundedGrid<Block> grid;
    private Tetrad tetrad;

    @BeforeEach
    void setUp() {
        grid = (MyBoundedGrid<Block>) Mockito.mock(MyBoundedGrid.class);

        // our default is the board is empty which means it's valid
        when(grid.isEmpty(any(Location.class))).thenReturn(true);
        when(grid.isValid(any(Location.class))).thenReturn(true);

        // create block of type 0 (I block)
        tetrad = new Tetrad(grid, 0);
    }

    // EP & WHITEBOX TESTS

    @Test
    void translationIsValid() {
        // moves down one, right one
        boolean translate = tetrad.translate(1, 1);
        assertTrue(translate);
    }

    @Test
    void rotationIsValid() {
        // 90 degree rotation
        boolean rotate = tetrad.rotate();
        assertTrue(rotate);
    }

    // BA & EG TESTS

    @Test
    void testCollisionTranslation() {
        when(grid.isValid(any(Location.class))).thenReturn(false);
        boolean translate = tetrad.translate(1, 0);

        assertFalse(translate);
    }

    @Test
    void testCollisionRotation() {
        when(grid.isValid(any(Location.class))).thenReturn(false);
        boolean rotate = tetrad.rotate();
        assertFalse(rotate);
    }
}
