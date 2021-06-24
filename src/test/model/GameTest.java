package model;

import org.junit.jupiter.api.*;
import ui.SnakeGame;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game testGame;
    private Snake testSnake;

    @BeforeEach
    public void setUp() {
        this.testGame = new Game();
        this.testSnake = testGame.getSnake();
    }

    @Test
    public void testInitialFields() {
        assertEquals(new Position(Snake.INITIAL_X_POSITION, Snake.INITIAL_Y_POSITION),
                this.testSnake.getHead().getPosition());
        assertEquals(Snake.INITIAL_BODY_COMPONENTS, this.testSnake.getBody().size());
        checkBodySetup();
        assertEquals(Snake.INITIAL_DIRECTION, this.testSnake.getHead().getDirection());
        assertFalse(this.testGame.isGameOver());
        assertEquals(0, this.testGame.getScore());
    }

    private void checkBodySetup() {
        int previousComponentYPosition = Snake.INITIAL_Y_POSITION;

        for (Component c : this.testSnake.getBody()) {
            assertEquals(Snake.INITIAL_X_POSITION, c.getPosition().getX());
            assertEquals(previousComponentYPosition + SnakeGame.UNIT, c.getPosition().getY());
            previousComponentYPosition += SnakeGame.UNIT;
        }
    }

    @Test
    public void testOnTickMoveNorth() {
        this.testGame.tick();

        assertEquals(new Position(Snake.INITIAL_X_POSITION, Snake.INITIAL_Y_POSITION - SnakeGame.UNIT),
                this.testSnake.getHead().getPosition());
        assertEquals(Snake.INITIAL_BODY_COMPONENTS, this.testSnake.getBody().size());
        assertEquals(Direction.NORTH, this.testSnake.getHead().getDirection());
        assertFalse(this.testGame.isGameOver());
    }

    @Test
    public void testOnTickMoveEast() {
        this.testSnake.turnClockwise();
        this.testGame.tick();

        assertEquals(new Position(Snake.INITIAL_X_POSITION + SnakeGame.UNIT, Snake.INITIAL_Y_POSITION),
                this.testSnake.getHead().getPosition());
        assertEquals(Direction.EAST, this.testSnake.getHead().getDirection());
    }

    @Test
    public void testOnTickMoveSouth() {
        this.testSnake.turnClockwise(); // facing East
        this.testSnake.turnClockwise(); // facing South
        this.testGame.tick();

        assertEquals(new Position(Snake.INITIAL_X_POSITION, Snake.INITIAL_Y_POSITION + SnakeGame.UNIT),
                this.testSnake.getHead().getPosition());
        assertEquals(Direction.SOUTH, this.testSnake.getHead().getDirection());
    }

    @Test
    public void testOnTickMoveWest() {
        this.testSnake.turnCounterClockwise(); // facing West
        this.testGame.tick();

        assertEquals(new Position(Snake.INITIAL_X_POSITION - SnakeGame.UNIT, Snake.INITIAL_Y_POSITION),
                this.testSnake.getHead().getPosition());
        assertEquals(Direction.WEST, this.testSnake.getHead().getDirection());
    }


    @Test
    public void testOnTickMoveSameDirectionTwice() {
        this.testGame.tick();
        this.testGame.tick();

        assertEquals(new Position(Snake.INITIAL_X_POSITION, Snake.INITIAL_Y_POSITION - SnakeGame.UNIT * 2),
                this.testSnake.getHead().getPosition());
    }

    @Test
    public void testOnTickMoveInDifferentDirection() {
        this.testGame.tick();
        this.testSnake.turnCounterClockwise();
        this.testGame.tick();

        assertEquals(new Position(Snake.INITIAL_X_POSITION - SnakeGame.UNIT,
                        Snake.INITIAL_Y_POSITION - SnakeGame.UNIT),
                this.testSnake.getHead().getPosition());
    }

    @Test
    public void testOnTickConsumeFood() {
        // Moves snake one tick away from initial food location
        for (int i = 1; i < (Snake.INITIAL_Y_POSITION - Game.START_FOOD_Y_POSITION) / SnakeGame.UNIT; i ++) {
            this.testGame.tick();
        }
        assertEquals(0, testGame.getScore());

        this.testGame.tick();
        assertEquals(Food.POINTS_GAINED_FOR_EACH, this.testGame.getScore());
        assertEquals(Snake.INITIAL_BODY_COMPONENTS + 1, this.testSnake.getBody().size());
        assertFalse(this.testGame.isGameOver());
    }


    @Test
    public void testOnTickSnakeCollision() {
        // setup snake to be long enough to collide despite initial snake size
        for (int i = 0; i < 5; i ++) {
            this.testSnake.grow();
        }
        assertEquals(Snake.INITIAL_BODY_COMPONENTS + 5, this.testSnake.getBody().size());
        // Move snake one tick away from colliding into its body
        this.testSnake.turnClockwise();
        this.testGame.tick();
        this.testSnake.turnClockwise();
        this.testGame.tick();
        this.testSnake.turnClockwise();
        assertFalse(this.testGame.isGameOver());

        this.testGame.tick();
        assertTrue(this.testGame.isGameOver());
    }

    @Test
    public void testOnTickSnakeOutOfBounds() {
        // Moves snake one tick away from leaving game boundary
        for (int i = 0; i < Snake.INITIAL_Y_POSITION / SnakeGame.UNIT ; i ++) {
            this.testGame.tick();
        }
        assertFalse(this.testGame.isGameOver());

        this.testGame.tick();
        assertTrue(this.testGame.isGameOver());
    }

    @AfterEach
    public void tearDown() {
        this.testGame = null;
        this.testSnake = null;
    }
}
