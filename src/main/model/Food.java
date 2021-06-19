package model;

import java.awt.*;

// Represents a food object in game
public class Food {
    public static final int POINTS_GAINED_FOR_EACH = 10;
    public static final Color COLOR  = new Color(255, 165,0);
    public static final int GAME_START_X_POSITION = Game.X_UPPER_BOUNDARY;
    public static final int GAME_START_Y_POSITION = Game.Y_UPPER_BOUNDARY - 20;

    private Position position;

    // constructor
    public Food() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: sets game start food position
    public void setInitialFoodPosition() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: sets random position within Game boundary
    public void generateRandomFoodPosition() {
        // stub
    }

    // getter
    public Position getPosition() {
        return null; // stub
    }

}
