package ui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final int GAME_PANEL_WIDTH = 600;
    public static final int GAME_PANEL_HEIGHT = 600;
    public static final int UNIT = 20;
    public static final int TOTAL_UNITS = GAME_PANEL_WIDTH * GAME_PANEL_HEIGHT / UNIT;

    private SnakeGame snakeGame;

    public GamePanel(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setupJPanel();

    }

    // MODIFIES:
    // EFFECTS: todo !!!
    private void setupJPanel() {
        setBackground(BACKGROUND_COLOR);
        setFocusable(true);
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGame(g);

        if (this.snakeGame.getGame().isGameOver()) {
            drawGameOver(g);
        }
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    private void drawGame(Graphics g) {
        this.snakeGame.getGame().drawGame(g);
    }


    // MODIFIES:
    // EFFECTS: todo !!!
    private void drawGameOver(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 30));
        FontMetrics fontMetrics = g.getFontMetrics();
        g.drawString("GAME OVER",
                GAME_PANEL_WIDTH / 2 , GAME_PANEL_HEIGHT / 2);
    }


}
