//package tetris;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TetrisTest {
//    private Tetris tetris;
//
//    @BeforeEach
//    void setup() throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            tetris = new Tetris();
//        });
//        thread.start();
//        Thread.sleep(500);
//    }
//
//    // tests that the initial state of the Tetris board shows
//    // up correctly
//    @Test
//    void testTetrisDefaultState() {
//        assertEquals(0, tetris.getLevel());
//        assertEquals(0, tetris.getScore());
//        assertFalse(tetris.isPaused());
//        assertFalse(tetris.hasLost());
//        assertNotNull(tetris.getNextBoard());
//    }
//
//    // tests that the pause action of the game correctly
//    // pauses the game state
//    @Test
//    void testPause() {
//        tetris.pause();
//        assertTrue(tetris.isPaused());
//        tetris.pause();
//        assertFalse(tetris.isPaused());
//    }
//
//    // tests that the play action of the game correctly
//    // resumes the game state
//    @Test
//    void testResume() {
//        tetris.pause();
//        assertTrue(tetris.isPaused());
//        tetris.play();
//        assertFalse(tetris.isPaused());
//    }
//
//    // tests that reset correctly resets the current game
//    // state to the default game
//    @Test
//    void testReset() {
//        tetris.pause();
//        tetris.reset();
//        assertFalse(tetris.isPaused());
//        assertEquals(0, tetris.getLevel());
//        assertEquals(0, tetris.getScore());
//        assertFalse(tetris.hasLost());
//    }
//}
