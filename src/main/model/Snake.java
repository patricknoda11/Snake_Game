package model;

import ui.GamePanel;

import java.util.LinkedList;
import java.util.List;

// Represents a snake with a direction. Each Snake is made up of one or more Components
public class Snake {
    public static final int INITIAL_X_POSITION = GamePanel.GAME_PANEL_WIDTH / 2;
    public static final int INITIAL_Y_POSITION = GamePanel.GAME_PANEL_HEIGHT / 2;
    public static final Direction INITIAL_DIRECTION = Direction.NORTH;
    public static final int INITIAL_BODY_COMPONENTS = 2;

    private Component head = new Component(new Position(INITIAL_X_POSITION, INITIAL_Y_POSITION), INITIAL_DIRECTION);
    private LinkedList<Component> body = new LinkedList<>();

    // constructor
    public Snake() {
        createSnakeBody();
    }

    // MODIFIES: this
    // EFFECTS: constructs vertically positioned snake body with each component having a direction facing NORTH
    private void createSnakeBody() {
        int previousComponentYPosition = INITIAL_Y_POSITION;

        for (int i = 0; i < INITIAL_BODY_COMPONENTS; i++) {
            this.body.add(new Component(new Position(INITIAL_X_POSITION,
                    previousComponentYPosition + 1), INITIAL_DIRECTION));
            previousComponentYPosition ++;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds new body component to the end of the body
    public void grow() {
        Component lastBodyComponent = this.body.getLast();
        this.body.addLast(new Component
                (new Position(lastBodyComponent.getPosition().getX(), lastBodyComponent.getPosition().getY())
                        , lastBodyComponent.getDirection()));
    }

    // EFFECTS: updates snake head and body component positions
    public void updatePosition() {
        int previousHeadPositionX = this.head.getPosition().getX(); // records the Snake head x position before update
        int previousHeadPositionY = this.head.getPosition().getY(); // records the Snake head y position before update

        switch (this.head.getDirection()) {                                   // updates current Snake head position
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

        updateBody(previousHeadPositionX, previousHeadPositionY);  // updates rest of the body components based off
                                                                   // previous component position
    }

    // MODIFIES: this
    // EFFECTS: moves snake body by setting body component position to the previous components position
    private void updateBody(int previousComponentPositionX, int previousComponentPositionY) {
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
        switch (this.head.getDirection()) {
            case NORTH:
                this.head.setDirection(Direction.EAST);
                break;
            case EAST:
                this.head.setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                this.head.setDirection(Direction.WEST);
                break;
            default:
                this.head.setDirection(Direction.NORTH);
        }
    }

    // MODIFIES: this
    // EFFECTS: rotates snake counterclockwise
    public void turnCounterClockwise() {
        switch (this.head.getDirection()) {
            case NORTH:
                this.head.setDirection(Direction.WEST);
                break;
            case EAST:
                this.head.setDirection(Direction.NORTH);
                break;
            case SOUTH:
                this.head.setDirection(Direction.EAST);
                break;
            default:
                this.head.setDirection(Direction.SOUTH);
        }
    }

    // getters
    public Component getHead() {
        return this.head;
    }

    public List<Component> getBody() {
        return this.body;
    }

}
