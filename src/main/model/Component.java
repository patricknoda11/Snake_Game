package model;

// Represents a component that makes up Snake
public class Component {
    private Position position;

    // constructor
    public Component(Position pos) {
        this.position = pos;
    }

    // MODIFIES: this
    // EFFECTS: increments y position by -1
    public void shiftNorth() {
        this.position.setY(this.position.getY() - 1);
    }

    // MODIFIES: this
    // EFFECTS: increments x position by +1
    public void shiftEast() {
        this.position.setX(this.position.getX() + 1);
    }

    // MODIFIES: this
    // EFFECTS: increments y position by +1
    public void shiftSouth() {
        this.position.setY(this.position.getY() + 1);
    }

    // MODIFIES: this
    // EFFECTS: increments x position by -1
    public void shiftWest() {
        this.position.setX(this.position.getX() - 1);
    }

    // getters
    public Position getPosition() {
        return this.position;
    }

}
