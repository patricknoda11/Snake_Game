package model;

import ui.GamePanel;

import java.awt.*;
import java.util.Random;

// Represents a food object in game
public class Food {
    public static final int POINTS_GAINED_FOR_EACH = 10;
    private static final Color COLOR  = new Color(255, 0, 0);

    private Position position = new Position(Game.START_FOOD_X_POSITION,
            Game.START_FOOD_Y_POSITION);                                    // initial food position at game start

    // MODIFIES: this
    // EFFECTS: sets random position within Game boundary
    public void generateRandomFoodPosition(int xUpperBoundary, int yUpperBoundary) {
        Random random = new Random();
        int randomXPosition = random.nextInt(xUpperBoundary);
        int randomYPosition = random.nextInt(yUpperBoundary);
        this.position = new Position(randomXPosition, randomYPosition);
    }

    // MODIFIES:
    // EFFECTS: todo
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(this.position.getX(), this.position.getY(), GamePanel.UNIT, GamePanel.UNIT);
    }

    // getter
    public Position getPosition() {
        return this.position;
    }
}
