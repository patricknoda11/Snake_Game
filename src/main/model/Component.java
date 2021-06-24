package model;

import ui.SnakeGame;

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
    // EFFECTS: increments y position by SnakeGame unit
    public void shiftNorth() {
        this.position.setY(this.position.getY() - SnakeGame.UNIT);
    }

    // MODIFIES: this
    // EFFECTS: increments x position by SnakeGame unit
    public void shiftEast() {
        this.position.setX(this.position.getX() + SnakeGame.UNIT);
    }

    // MODIFIES: this
    // EFFECTS: increments y position by SnakeGame unit
    public void shiftSouth() {
        this.position.setY(this.position.getY() + SnakeGame.UNIT);
    }

    // MODIFIES: this
    // EFFECTS: increments x position by SnakeGame unit
    public void shiftWest() {
        this.position.setX(this.position.getX() - SnakeGame.UNIT);
    }

    // MODIFIES:
    // EFFECTS: todo
    public void draw(Graphics g) {
        g.setColor(SNAKE_COLOR);
        g.fillRect(this.position.getX(), this.position.getY(), SnakeGame.UNIT, SnakeGame.UNIT);
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
