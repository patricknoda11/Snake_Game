package model;

import java.util.Observable;

// Game class representing
public class Game extends Observable {
    public static final int TICKS_IN_A_SECOND = 5;
    public static final int X_UPPER_BOUNDARY = 150;
    public static final int Y_UPPER_BOUNDARY = 150;
    public static final int GAME_START_FOOD_X_POSITION = Game.X_UPPER_BOUNDARY / 2;
    public static final int GAME_START_FOOD_Y_POSITION = Game.Y_UPPER_BOUNDARY / 2 - 20;

    private Snake snake = new Snake();
    private Food food = null;
    private int score = 0;
    private boolean foodEaten = false;
    private boolean gameOver = false;

    // constructor
    public Game() {
        this.food = new Food();
        this.food.setInitialFoodPosition(GAME_START_FOOD_X_POSITION, GAME_START_FOOD_Y_POSITION);
    }
    // MODIFIES: this
    // EFFECTS: update game state by updating snake position
    //          if food is consumed, then update score and generate new food in random location
    public void tick() {
        checkFoodStatus();
        updateSnake();
        // todo if food is consumed, then update score and generate new food in random location!!!
        checkGameStatus();

        if (gameOver) {
            // todo !!!
        }

    }

    // MODIFIES: this
    // EFFECTS: if snake is out of bounds or has collided into itself, sets gameOver to true
    private void checkGameStatus() {
        int snakeHeadXPosition = this.snake.getHead().getPosition().getX();
        int snakeHeadYPosition = this.snake.getHead().getPosition().getY();
        if (isOutOfBounds(snakeHeadXPosition, snakeHeadYPosition)
                || hasCollided(snakeHeadXPosition, snakeHeadYPosition)) {
            this.gameOver = true;
        }
    }

    // MODIFIES: this
    // EFFECTS: todo !!!!
    private void checkFoodStatus() {

    }

    // MODIFIES: this
    // EFFECTS: updates snake
    private void updateSnake() {
        this.snake.updatePosition();
    }

    // MODIFIES: this
    // EFFECTS: updates score and notifies observers regarding change
    private void updateScore() {
        this.score += Food.POINTS_GAINED_FOR_EACH;
        setChanged();
        notifyObservers();
    }

    // REQUIRES: this.food == null
    // MODIFIES: this
    // EFFECTS: generates new food at a random position
    private void generateNewFoodInRandomPosition() {
        this.food = new Food();
        this.food.generateRandomFoodPosition(X_UPPER_BOUNDARY, Y_UPPER_BOUNDARY);
    }

    // EFFECTS: returns whether snake is outside of game boundary
    private boolean isOutOfBounds(int snakeHeadXPosition, int snakeHeadYPosition) {
        return snakeHeadXPosition < 0 || X_UPPER_BOUNDARY < snakeHeadXPosition
                || snakeHeadYPosition < 0 || Y_UPPER_BOUNDARY < snakeHeadYPosition;
    }

    // EFFECTS: returns whether snake has collided into itself
    private boolean hasCollided(int snakeHeadXPosition, int snakeHeadYPosition) {
        for (Component c : this.snake.getBody()) {
            int componentXPosition = c.getPosition().getX();
            int componentYPosition = c.getPosition().getY();

            if (snakeHeadXPosition == componentXPosition && snakeHeadYPosition == componentYPosition) {
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

    // getters
    public Snake getSnake() {
        return this.snake;
    }

    public Food getFood() {
        return this.food;
    }

    public int getScore() {
        return this.score;
    }

}
