import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PingPongGame extends JFrame implements ActionListener, KeyListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private int paddleX = WIDTH / 2 - 50;
    private int paddleY = HEIGHT - 50;
    private int paddleSpeed = 10;

    private int ballX = WIDTH / 2 - 10;
    private int ballY = HEIGHT / 2 - 10;
    private int ballSpeedX = 5;
    private int ballSpeedY = 5;

    public PingPongGame() {
        setTitle("Ping Pong Game");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(10, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        moveBall();
        movePaddle();
        checkCollision();
        repaint();
    }

    private void moveBall() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        if (ballX <= 0 || ballX >= WIDTH - 20) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballY <= 0 || ballY >= HEIGHT - 20) {
            ballSpeedY = -ballSpeedY;
        }
    }

    private void movePaddle() {
        if (paddleX >= 0 && paddleX <= WIDTH - 100) {
            paddleX += paddleSpeed;
        } else if (paddleX < 0) {
            paddleX = 0;
        } else {
            paddleX = WIDTH - 100;
        }
    }

    private void checkCollision() {
        if (ballX >= paddleX && ballX <= paddleX + 100 && ballY >= paddleY - 20 && ballY <= paddleY) {
            ballSpeedY = -ballSpeedY;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillRect(paddleX, paddleY, 100, 20);

        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, 20, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PingPongGame game = new PingPongGame();
            game.setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddleSpeed = -Math.abs(paddleSpeed);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddleSpeed = Math.abs(paddleSpeed);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddleSpeed = 0;
    }
}
