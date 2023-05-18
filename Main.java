import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;

	private static final int DOT_SIZE = 10;

	private static final int RAND_POS = 49;

	private static final int DELAY = 100;

	private List<Point> snake = new ArrayList<>();
	private Point food;

	private int score = 0;

	private boolean isRunning = true;
	private boolean isPaused = false;
	private boolean isGameOver = false;

	private int direction = KeyEvent.VK_RIGHT;

	public Main() {
		setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		startGame();
	}

	private void startGame() {
		snake.clear();
		snake.add(new Point(50, 50));
		snake.add(new Point(40, 50));
		snake.add(new Point(30, 50));
		generateFood();
		score = 0;
		direction = KeyEvent.VK_RIGHT;
		isPaused = false;
		isGameOver = false;
		new Thread(this).start();
	}

	private void generateFood() {
		Random rand = new Random();
		int x = rand.nextInt(RAND_POS) * DOT_SIZE;
		int y = rand.nextInt(RAND_POS) * DOT_SIZE;
		food = new Point(x, y);
	}

	private void move() {
		Point head = snake.get(0);
		Point newHead = (Point) head.clone();
		switch (direction) {
		case KeyEvent.VK_UP:
			newHead.translate(0, -DOT_SIZE);
			break;
		case KeyEvent.VK_DOWN:
			newHead.translate(0, DOT_SIZE);
			break;
		case KeyEvent.VK_LEFT:
			newHead.translate(-DOT_SIZE, 0);
			break;
		case KeyEvent.VK_RIGHT:
			newHead.translate(DOT_SIZE, 0);
			break;
		}
		snake.add(0, newHead);
		if (!newHead.equals(food)) {
			snake.remove(snake.size() - 1);
		} else {
			generateFood();
			score++;
		}
		checkCollision();
	}

	private void checkCollision() {
		Point head = snake.get(0);
		if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
			isGameOver = true;
		}
		for (int i = 1; i < snake.size(); i++) {
			if (head.equals(snake.get(i))) {
				isGameOver = true;
				break;
			}
		}
	}

	private void drawSnake(Graphics g) {
		g.setColor(Color.GREEN);
		for (Point p : snake) {
			g.fillRect(p.x, p.y, DOT_SIZE, DOT_SIZE);
		}
	}

	private void drawFood(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(food.x, food.y, DOT_SIZE, DOT_SIZE);
	}

	private void drawScore(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 10, 20);
	}

	private void drawGameOver(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Game Over!", WIDTH / 2 - 30, HEIGHT / 2 - 10);
		g.drawString("Press SPACE to play again", WIDTH / 2 - 70, HEIGHT / 2 + 10);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawSnake(g);
		drawFood(g);
		drawScore(g);
		if (isPaused) {
			g.setColor(Color.WHITE);
			g.drawString("Paused", WIDTH / 2 - 15, HEIGHT / 2);
		}
		if (isGameOver) {
			drawGameOver(g);
		}
	}

	@Override
	public void run() {
		while (isRunning) {
			if (!isPaused && !isGameOver) {
				move();
			}
			repaint();
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			startGame();
		} else if (keyCode == KeyEvent.VK_P) {
			isPaused = !isPaused;
		} else if (keyCode == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) {
			direction = KeyEvent.VK_UP;
		} else if (keyCode == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) {
			direction = KeyEvent.VK_DOWN;
		} else if (keyCode == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) {
			direction = KeyEvent.VK_LEFT;
		} else if (keyCode == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) {
			direction = KeyEvent.VK_RIGHT;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Main());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}