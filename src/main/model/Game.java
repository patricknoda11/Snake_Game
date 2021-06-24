package model;

import ui.GamePanel;

import java.awt.*;
import java.util.Observable;

// Game class representing
public class Game extends Observable {
    public static final int START_FOOD_X_POSITION = GamePanel.GAME_PANEL_WIDTH / 2;
    public static final int START_FOOD_Y_POSITION = GamePanel.GAME_PANEL_HEIGHT / 2 - (GamePanel.GAME_PANEL_HEIGHT * 2 / 15);

    private Snake snake = new Snake();
    private Food food = new Food();
    private int score = 0;
    private boolean gameOver = false;

    // MODIFIES: this
    // EFFECTS: updates snake position, checks whether food has been consumed, and checks game status
    public void tick() {
        this.snake.updatePosition();
        checkFoodStatus();
        checkGameStatus();
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
    // EFFECTS: if food has been consumed, then update score, make snake grow and generate new food in random position
    private void checkFoodStatus() {
        if (isFoodConsumed()) {
            updateScore();
            this.snake.grow();
            generateNewFoodInRandomPosition();
        }
    }

    // REQUIRES: food.getPosition() != null
    // EFFECTS: returns true if snake head has the same x and y position as food, otherwise return false
    private boolean isFoodConsumed() {
        return this.snake.getHead().getPosition().getX() == this.food.getPosition().getX()
                && this.snake.getHead().getPosition().getY() == this.food.getPosition().getY();
    }

    // MODIFIES: this
    // EFFECTS: updates score and notifies observers regarding change
    private void updateScore() {
        this.score += Food.POINTS_GAINED_FOR_EACH;
        setChanged();
        notifyObservers(this.score);
    }

    // REQUIRES: this.food == null
    // MODIFIES: this
    // EFFECTS: generates new food at a random position
    private void generateNewFoodInRandomPosition() {
        this.food = new Food();
        this.food.generateRandomFoodPosition(GamePanel.GAME_PANEL_WIDTH, GamePanel.GAME_PANEL_HEIGHT);
    }

    // EFFECTS: returns whether snake is outside of game boundary
    private boolean isOutOfBounds(int snakeHeadXPosition, int snakeHeadYPosition) {
        return snakeHeadXPosition < 0 || GamePanel.GAME_PANEL_WIDTH < snakeHeadXPosition
                || snakeHeadYPosition < 0 || GamePanel.GAME_PANEL_HEIGHT < snakeHeadYPosition;
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

    // MODIFIES:
    // EFFECTS: todo !!!
    public void drawGame(Graphics g) {
        drawSnake(g);
        this.food.draw(g);
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    private void drawSnake(Graphics g) {
        this.snake.getHead().draw(g);
        for (Component c : this.snake.getBody()) {
            c.draw(g);
        }
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    public void reset() {
        this.snake = new Snake();
        this.score = 0;
        this.food = new Food();
        this.gameOver = false;
    }

    // MODIFIES:
    // EFFECTS: todo !!
    public boolean isGameOver() {
        return this.gameOver;
    }

    // getters
    public Snake getSnake() {
        return this.snake;
    }

    public int getScore() {
        return this.score;
    }
}
