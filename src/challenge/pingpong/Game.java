package challenge.pingpong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = WIDTH * 9 / 16;
    public static String winner;

    Ball ball;
    Paddle paddle1;
    Paddle paddle2;

    public static boolean running = false;
    public static boolean ended = false;
    private Thread gameThread;

    public Game() {
        initialize();
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(new KeyInput(paddle1, paddle2, ball));
        this.setFocusable(true);
        new Window("PingPong", this);
    }

    private void initialize() {
        ball = new Ball();
        paddle1 = new Paddle(Color.blue, true);
        paddle2 = new Paddle(Color.red, false);

    }

    @Override
    public void run() {

        this.requestFocus();

        while (running) {
            update();
            draw();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void draw() {
        BufferStrategy strategy = this.getBufferStrategy();

        if (strategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = strategy.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        ball.draw(g);
        paddle1.draw(g);
        paddle2.draw(g);

        if (ended) {
            g.setColor(Color.white);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Popup popup = new Popup();
            popup.draw(g);
            ball.stop();
        }

        g.dispose();
        strategy.show();

    }

    private void update() {
        ball.update(paddle1, paddle2);
        paddle1.update(ball);
        paddle2.update(ball);
    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }

}
