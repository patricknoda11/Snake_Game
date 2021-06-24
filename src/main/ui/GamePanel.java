package ui;

import model.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final int GAME_PANEL_WIDTH = 600;
    public static final int GAME_PANEL_HEIGHT = 600;

    private SnakeGame snakeGame;

    public GamePanel(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setupJPanel();
        addKeyListener(new GameKeyAdapter());
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
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        FontMetrics fontMetrics = g.getFontMetrics();
        g.drawString("GAME OVER",
                (GAME_PANEL_WIDTH  - fontMetrics.stringWidth("GAME OVER")) / 2 ,
                GAME_PANEL_HEIGHT / 2);
        g.drawString("Press 'R' to Replay",
                (GAME_PANEL_WIDTH  - fontMetrics.stringWidth("Press 'R' to Replay")) / 2 ,
                GAME_PANEL_HEIGHT / 2 + 40);
    }

    private class GameKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    snakeGame.getGame().getSnake().getHead().setDirection(Direction.WEST);
                    break;
                case KeyEvent.VK_RIGHT:
                    snakeGame.getGame().getSnake().getHead().setDirection(Direction.EAST);
                    break;
                case KeyEvent.VK_UP:
                    snakeGame.getGame().getSnake().getHead().setDirection(Direction.NORTH);
                    break;
                case KeyEvent.VK_DOWN:
                    snakeGame.getGame().getSnake().getHead().setDirection(Direction.SOUTH);
                    break;
                case KeyEvent.VK_R:
                    snakeGame.getGame().reset();
                default:
                    break;
            }
        }
    }

}
