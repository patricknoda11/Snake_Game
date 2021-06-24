package ui;

import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGame extends JFrame {
    public static final int UNIT = 20;
    private static final int GAME_FRAME_WIDTH = 600;
    private static final int GAME_FRAME_HEIGHT = 650;
    private static final int REFRESH_INTERVAL = 200;

    private Game game;
    private GamePanel gamePanel;
    private ScorePanel scorePanel;
    private Timer timer;

    public SnakeGame() {
        setupJFrame();
        initializeJComponents();

        addGameObserver();
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
                if (!game.isGameOver()) {
                    game.tick();
                    gamePanel.repaint();
                }
            }
        });

        this.timer.start();
    }

    // getter
    public Game getGame() {
        return this.game;
    }

}
