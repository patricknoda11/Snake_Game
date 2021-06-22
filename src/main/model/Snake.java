package model;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// Represents a snake with a direction. Each Snake is made up of one or more Components
public class Snake {
    public static final int INITIAL_X_POSITION = Game.X_UPPER_BOUNDARY / 2;
    public static final int INITIAL_Y_POSITION = Game.Y_UPPER_BOUNDARY / 2;
    public static final Direction INITIAL_DIRECTION = Direction.NORTH;
    public static final int INITIAL_BODY_COMPONENTS = 2;
    public static final int MAXIMUM_INITIAL_BODY_COMPONENTS = 10;
    public static final Color SNAKE_COLOR = new Color(63, 153, 26);

    private Component head = new Component(new Position(INITIAL_X_POSITION, INITIAL_Y_POSITION));
    private LinkedList<Component> body = new LinkedList<>();
    private Direction direction = INITIAL_DIRECTION;


    // constructor
    public Snake() {
        createSnakeBody();
    }

    // MODIFIES: this
    // EFFECTS: if INITIAL_BODY_COMPONENTS < MAXIMUM_INITIAL_BODY_COMPONENTS &&
    //          MAXIMUM_INITIAL_BODY_COMPONENTS < Game.Y_UPPER_BOUNDARY / 2,
    //          then create snake body by adding the correct number of body components
    private void createSnakeBody() {
        int previousComponentYPosition = INITIAL_Y_POSITION;

        for (int i = 0; i < INITIAL_BODY_COMPONENTS; i++) {
            this.body.add(new Component(new Position(INITIAL_X_POSITION, previousComponentYPosition + 1)));
            previousComponentYPosition ++;
        }
    }

    // REQUIRES: Snake body must have at least one element
    // MODIFIES: this
    // EFFECTS: lengthens body by adding additional component to the end of snake body
    public void grow() {
        Component lastComponent = this.body.getLast();
    }

    // EFFECTS: updates snake head and body component positions
    public void updatePosition() {
        int previousHeadPositionX = this.head.getPosition().getX(); // records the current Snake head x position
        int previousHeadPositionY = this.head.getPosition().getY(); // records the current Snake head y position

        switch (this.direction) {                                   // updates current Snake head position
            case NORTH:
                this.head.shiftNorth();
                break;
            case EAST:
                this.head.shiftEast();
                break;
            case SOUTH:
                this.head.shiftSouth();
                break;
            default:
                this.head.shiftWest();
        }

        moveBody(previousHeadPositionX, previousHeadPositionY);    // updates rest of the body components based off
                                                                   // previous component position
    }

    // MODIFIES: this
    // EFFECTS: moves snake body by setting body component position to the previous components position
    private void moveBody(int previousComponentPositionX, int previousComponentPositionY) {
        for (Component c : this.body) {
            int currentComponentPositionX = c.getPosition().getX();
            int currentComponentPositionY = c.getPosition().getY();

            c.getPosition().setX(previousComponentPositionX);
            c.getPosition().setY(previousComponentPositionY);

            previousComponentPositionX = currentComponentPositionX;
            previousComponentPositionY = currentComponentPositionY;
        }
    }

    // MODIFIES: this
    // EFFECTS: rotates snake clockwise
    public void turnClockwise(){
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.WEST;
                break;
            default:
                this.direction = Direction.NORTH;
        }
    }

    // MODIFIES: this
    // EFFECTS: rotates snake counterclockwise
    public void turnCounterClockwise() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.WEST;
                break;
            case EAST:
                this.direction = Direction.NORTH;
                break;
            case SOUTH:
                this.direction = Direction.EAST;
                break;
            default:
                this.direction = Direction.SOUTH;
        }
    }

    // getters
    public Component getHead() {
        return this.head;
    }

    public List<Component> getBody() {
        return this.body;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
