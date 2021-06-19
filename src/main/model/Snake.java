package model;

import java.awt.*;
import java.util.List;


// Represents a snake with a direction. Each Snake is made up of one or more Components
public class Snake {
    public static final Position INITIAL_POSITION =
            new Position(Game.X_UPPER_BOUNDARY / 2, Game.Y_UPPER_BOUNDARY / 2);
    public static final Direction INITIAL_DIRECTION = Direction.NORTH;
    public static final Color SNAKE_COLOR = new Color(63, 153, 26);

    private Component head;
    private List<Component> body;
    private Direction direction;

    // constructor
    public Snake() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: lengthens body by adding additional component
    public void grow() {
        // stub
    }

    // EFFECTS: updates snake head and body positions
    public void move() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: rotates snake clockwise
    public void turnClockwise(){
        // stub
    }

    // MODIFIES: this
    // EFFECTS: rotates snake counterclockwise
    public void turnCounterClockwise() {
        // stub
    }

    // getters
    public Component getHead() {
        return null; // stub
    }

    public List<Component> getBody() {
        return null; // stub
    }

    public Direction getDirection() {
        return null; // stub
    }




}
