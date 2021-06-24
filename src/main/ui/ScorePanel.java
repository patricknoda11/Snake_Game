package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ScorePanel extends JPanel implements Observer {
    private static final Color BACKGROUND_COLOR = new Color(18, 26, 76);

    private SnakeGame snakeGame;
    private JLabel scoreLabel;

    public ScorePanel(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setBackground(BACKGROUND_COLOR);
        setupScoreLabel();
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    private void setupScoreLabel() {
        this.scoreLabel = new JLabel("Score: " + this.snakeGame.getGame().getScore());
        this.scoreLabel.setForeground(Color.WHITE);
        this.add(this.scoreLabel);
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    @Override
    public void update(Observable o, Object arg) {
        int score = (int) arg;
        this.scoreLabel.setText("Score: " + score);
    }
}
