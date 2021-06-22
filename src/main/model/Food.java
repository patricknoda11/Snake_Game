package model;

import java.awt.*;
import java.util.Random;

// Represents a food object in game
public class Food {
    public static final int POINTS_GAINED_FOR_EACH = 10;
    public static final Color COLOR  = new Color(255, 165,0);

    private Position position;

    // MODIFIES: this
    // EFFECTS: sets game start food position
    public void setInitialFoodPosition(int initialXPosition, int initialYPosition) {
        this.position = new Position(initialXPosition, initialYPosition);
    }

    // MODIFIES: this
    // EFFECTS: sets random position within Game boundary
    public void generateRandomFoodPosition(int xUpperBoundary, int yUpperBoundary) {
        Random random = new Random();
        int randomXPosition = random.nextInt(xUpperBoundary);
        int randomYPosition = random.nextInt(yUpperBoundary);
        this.position = new Position(randomXPosition, randomYPosition);
    }

}
