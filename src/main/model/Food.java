package model;

import java.awt.*;

// Represents a food object in game
public class Food {
    public static final int POINTS_GAINED_FOR_EACH_FOOD = 10;
    public static final Color FOOD_COLOR  = new Color(255, 165,0);

    private Position position;

    public Food() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: sets random position within Game boundary
    private void generateRandomFoodPosition() {
        // stub
    }
}
