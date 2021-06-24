package ui;

import model.Direction;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JFrame {
    private static final int GAME_FRAME_WIDTH = 600;
    private static final int GAME_FRAME_HEIGHT = 650;
    private static final int REFRESH_INTERVAL = 50;

    private Game game;
    private GamePanel gamePanel;
    private ScorePanel scorePanel;
    private Timer timer;

    public SnakeGame() {
        setupJFrame();
        initializeJComponents();

        addGameObserver();
        addKeyListener(new GameKeyAdapter());
        setVisible(true);
        initializeTimer();
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    private void setupJFrame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setLayout(new BorderLayout());
        setSize(GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
        setLocationRelativeTo(null); // sets the location of the window to the center of screen
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    private void initializeJComponents() {
        this.game = new Game();
        this.gamePanel = new GamePanel(this);
        this.scorePanel = new ScorePanel(this);
        add(this.scorePanel, BorderLayout.NORTH);
        add(this.gamePanel, BorderLayout.CENTER);
    }

    // MODIFIES:
    // EFFECTS: todo !!!
    private void addGameObserver() {
        this.game.addObserver(this.scorePanel);
    }

    // MODIFIES:
    // EFFECTS: todo!!!
    private void initializeTimer() {
        this.timer = new Timer(REFRESH_INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.tick();
                gamePanel.repaint();
            }
        });

        this.timer.start();
    }

    // getter
    public Game getGame() {
        return this.game;
    }

    private class GameKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    game.getSnake().getHead().setDirection(Direction.EAST);
                    break;
                case KeyEvent.VK_RIGHT:
                    game.getSnake().getHead().setDirection(Direction.WEST);
                    break;
                case KeyEvent.VK_UP:
                    game.getSnake().getHead().setDirection(Direction.NORTH);
                    break;
                case KeyEvent.VK_DOWN:
                    game.getSnake().getHead().setDirection(Direction.SOUTH);
                    break;
                case KeyEvent.VK_R:
                    game.reset();
                default:
                    break;
            }
        }
    }
}
