package minesweeper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MinesweeperMockDependenciesTest {
    // MOCKITO TESTING

    // mocks the random number generation for mine locations
    @Test
    void testMineLocations() {
        Random random = Mockito.mock(Random.class);

        // make random always pick the number 3
        when(random.nextInt(anyInt())).thenReturn(3);
        int mineIdx = random.nextInt(50);
        assertEquals(3, mineIdx);
        verify(random, times(1)).nextInt(50);
    }
}
