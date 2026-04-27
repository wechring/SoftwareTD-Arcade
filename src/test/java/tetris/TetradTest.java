package tetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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

    // tests that tetrad can move when grid is empty
    @Test
    void translationIsValid() {
        // moves down one, right one
        boolean translate = tetrad.translate(1, 1);
        assertTrue(translate);
    }

    // tests that tetrad can rotate 90 degrees when grid is empty
    @Test
    void rotationIsValid() {
        // 90 degree rotation
        boolean rotate = tetrad.rotate();
        assertTrue(rotate);
    }

    // getter returns correct type
    @Test
    void testGetType() {
        assertEquals(0, tetrad.getType());
    }

    // tests that remove successfully removes the four squares
    // within a tetrad from the grid
    @Test
    void testRemove() {
        tetrad.remove();
        verify(grid, Mockito.atLeast(4)).remove(any(Location.class));
    }

    // BA & EG TESTS

    // tests that a block cannot have a translation if the location
    // is out of bounds or occupied
    @Test
    void testCollisionTranslation() {
        when(grid.isEmpty(any(Location.class))).thenReturn(false);
        boolean translate = tetrad.translate(1, 0);

        assertFalse(translate);
    }

    // tests that a block cannot rotate 90 degrees if the location
    // is out of bounds or occupied
    @Test
    void testCollisionRotation() {
        when(grid.isEmpty(any(Location.class))).thenReturn(false);
        boolean rotate = tetrad.rotate();
        assertFalse(rotate);
    }
}

