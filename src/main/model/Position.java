package model;

import java.util.Objects;

// Represents a position within game boundaries
public class Position {
    private int x;
    private int y;

    // constructor
    public Position(int x, int y) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: increments y position by -1
    public void moveNorth() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: increments x position by +1
    public void moveEast() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: increments y position by +1
    public void moveSouth() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: increments x position by -1
    public void moveWest() {
        // stub
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // getters
    public int getX() {
        return 0; // stub

    }

    public int getY() {
        return 0; // stub
    }


}
