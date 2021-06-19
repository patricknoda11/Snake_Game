package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game testGame;
    private Snake testSnake;

    @BeforeEach
    public void setUp() {
        this.testGame = new Game();
        this.testSnake = this.testGame.getSnake();

    }

    @Test
    public void testInitialFields() {
        assertEquals(new Position(Game.X_UPPER_BOUNDARY / 2, Game.Y_UPPER_BOUNDARY / 2),
                this.testSnake.getHead().getPosition());
        assertEquals(0, this.testSnake.getBody().size());
        assertEquals(Direction.NORTH, this.testSnake.getDirection());
        assertFalse(this.testGame.isGameOver());
        assertEquals(0, this.testGame.getScore());
    }

    @Test
    public void testOnTickMoveNorth() {
        this.testGame.tick();

        assertEquals(new Position(Game.X_UPPER_BOUNDARY / 2, Game.Y_UPPER_BOUNDARY / 2 - 1),
                this.testSnake.getHead().getPosition());
        assertEquals(0, this.testSnake.getBody().size());
        assertEquals(Direction.NORTH, this.testSnake.getDirection());
        assertFalse(this.testGame.isGameOver());
    }

    @Test
    public void testOnTickMoveEast() {
        this.testSnake.turnClockwise();
        this.testGame.tick();

        assertEquals(new Position(Game.X_UPPER_BOUNDARY / 2 + 1, Game.Y_UPPER_BOUNDARY / 2),
                this.testSnake.getHead().getPosition());
        assertEquals(Direction.EAST, this.testSnake.getDirection());
    }

    @Test
    public void testOnTickMoveSouth() {
        this.testSnake.turnClockwise(); // facing East
        this.testSnake.turnClockwise(); // facing South
        this.testGame.tick();

        assertEquals(new Position(Game.X_UPPER_BOUNDARY / 2, Game.Y_UPPER_BOUNDARY / 2 + 1),
                this.testSnake.getHead().getPosition());
        assertEquals(Direction.SOUTH, this.testSnake.getDirection());
    }

    @Test
    public void testOnTickMoveWest() {
        this.testSnake.turnCounterClockwise(); // facing West
        this.testGame.tick();

        assertEquals(new Position(Game.X_UPPER_BOUNDARY / 2 - 1, Game.Y_UPPER_BOUNDARY / 2),
                this.testSnake.getHead().getPosition());
        assertEquals(Direction.WEST, this.testSnake.getDirection());
    }

    @Test
    public void testOnTickMoveSameDirectionTwice() {
        this.testGame.tick();
        this.testGame.tick();

        assertEquals(new Position(Game.X_UPPER_BOUNDARY / 2, Game.Y_UPPER_BOUNDARY / 2 - 2),
                this.testSnake.getHead().getPosition());
    }

    @Test
    public void testOnTickMoveInDifferentDirection() {
        this.testGame.tick();
        this.testSnake.turnCounterClockwise();
        this.testGame.tick();

        assertEquals(new Position(Game.X_UPPER_BOUNDARY / 2 - 1, Game.Y_UPPER_BOUNDARY / 2 - 1),
                this.testSnake.getHead().getPosition());
    }

    @Test
    public void testOnTickConsumeFood() {
        // Moves snake one tick away from initial food location
        for (int i = 1; i < Food.GAME_START_Y_POSITION - Snake.INITIAL_POSITION.getY(); i ++) {
            this.testGame.tick();
        }
        assertEquals(0, this.testGame.getScore());

        this.testGame.tick();
        assertEquals(Food.POINTS_GAINED_FOR_EACH, this.testGame.getScore());
        assertEquals(1, this.testSnake.getBody().size());
        assertFalse(this.testGame.isGameOver());
    }


    @Test
    public void testOnTickSnakeCollision() {
        // setup snake to be long enough to collide
        for (int i = 0; i < 5; i ++) {
            this.testSnake.grow();
        }
        assertEquals(5, this.testSnake.getBody().size());
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
        // Moves snake one tick away from game border
        for (int i = 1; i < Snake.INITIAL_POSITION.getY(); i ++) {
            this.testGame.tick();
        }
        assertFalse(this.testGame.isGameOver());

        this.testGame.tick();
        assertTrue(this.testGame.isGameOver());
    }
}
