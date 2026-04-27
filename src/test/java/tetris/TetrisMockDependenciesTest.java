package tetris;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TetrisMockDependenciesTest {

    // MOCKITO TESTING

    // mocks the random number generation for tetrad blocks
    @Test
    void testRandomTetradPieces() {
        Random random = Mockito.mock(Random.class);

        // make random always pick tetrad type 6 (Z block)
        when(random.nextInt(7)).thenReturn(6);
        assertEquals(6, random.nextInt(7));
        verify(random, atLeastOnce()).nextInt(7);
    }

    // mocks the game clock
    @Test
    void testGameClock() {
        Clock clock = Mockito.mock(Clock.class);

        // the clock should return the mock time every time it's checked
        Instant instant = Instant.parse("2026-04-01T00:00:00.00Z");
        when(clock.instant()).thenReturn(instant);
        when(clock.getZone()).thenReturn(ZoneId.of("UTC"));
        assertEquals(instant, clock.instant());
    }
}
