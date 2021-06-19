package model;

// Game class representing
public class Game {
    public static final int TICKS_IN_A_SECOND = 5;
    public static final int X_UPPER_BOUNDARY = 150;
    public static final int Y_UPPER_BOUNDARY = 150;

    private Snake snake = new Snake();
    private Food food;
    private int score = 0;
    private boolean isFoodEaten = false;
    private boolean isGameOver = false;

    // MODIFIES: this
    // EFFECTS: updates game state
    public void tick() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: updates snake
    private void updateSnake() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: updates score
    private void updateScore() {
        // stub
    }

    // REQUIRES: this.food == null
    // MODIFIES: this
    // EFFECTS: generates new food at a random position
    private void generateNewFood() {
        // stub
    }

    // EFFECTS: returns whether snake is outside of game boundary
    private boolean isOutOfBounds() {
        return false;
    }

    // EFFECTS: returns whether snake has collided into itself
    private boolean hasCollided() {
        return false;
    }

    public boolean isGameOver() {
        return false; // stub
    }

    // getters
    public Snake getSnake() {
        return this.snake;
    }

    public Food getFood() {
        return null;
    }

    public int getScore() {
        return 0;
    }

}
