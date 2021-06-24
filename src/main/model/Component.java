package model;

import ui.GamePanel;

import java.awt.*;

// Represents a component that makes up Snake
public class Component {
    private static final Color SNAKE_COLOR = new Color(63, 153, 26);

    private Position position;
    private Direction direction;

    // constructor
    public Component(Position pos, Direction dir) {
        this.position = pos;
        this.direction = dir;
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

    // MODIFIES:
    // EFFECTS: todo
    public void draw(Graphics g) {
        g.setColor(SNAKE_COLOR);
        g.fillOval(this.position.getX(), this.position.getY(), GamePanel.UNIT, GamePanel.UNIT);
    }

    // getters
    public Position getPosition() {
        return this.position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    // setter
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
}
