package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

// Represents the score panel that allows user to see current game score
public class ScorePanel extends JPanel implements Observer {
    private static final Color BACKGROUND_COLOR = new Color(18, 26, 76);

    private SnakeGame snakeGame;
    private JLabel scoreLabel;

    // constructor
    public ScorePanel(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setBackground(BACKGROUND_COLOR);
        setupScoreLabel();
    }

    // MODIFIES: this
    // EFFECTS: setup score label that will be used to visually display score to user and adds it to this
    private void setupScoreLabel() {
        this.scoreLabel = new JLabel("Score: " + this.snakeGame.getGame().getScore());
        this.scoreLabel.setForeground(Color.WHITE);
        add(this.scoreLabel);
    }

    // MODIFIES: this
    // EFFECTS: updates score label whenever the score in the game changes
    @Override
    public void update(Observable o, Object arg) {
        int score = (int) arg;
        this.scoreLabel.setText("Score: " + score);
    }
}
