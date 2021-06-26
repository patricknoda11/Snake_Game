package model;

import ui.SnakeGame;

import java.awt.*;
import java.util.Random;

// Represents a food object in game
public class Food {
    public static final int POINTS_GAINED_FOR_EACH = 10;
    private static final Color COLOR  = new Color(232, 117, 28);

    private Position position = new Position(Game.START_FOOD_X_POSITION,
            Game.START_FOOD_Y_POSITION);                                    // initial food position at game start

    // MODIFIES: this
    // EFFECTS: sets random position within Game boundary
    public void generateRandomFoodPosition(int xUpperBoundary, int yUpperBoundary) {
        Random random = new Random();
        int randomXPosition = random.nextInt(xUpperBoundary / SnakeGame.UNIT) * SnakeGame.UNIT;
        int randomYPosition = random.nextInt(yUpperBoundary / SnakeGame.UNIT) * SnakeGame.UNIT;
        this.position = new Position(randomXPosition, randomYPosition);
    }

    // EFFECTS: draws this with specific color and size at this x, y
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(this.position.getX(), this.position.getY(), SnakeGame.UNIT, SnakeGame.UNIT);
    }

    // getter
    public Position getPosition() {
        return this.position;
    }
}
