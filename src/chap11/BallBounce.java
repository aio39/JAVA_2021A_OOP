package chap11;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Shape;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.geom.Ellipse2D;

public class BallBounce extends JPanel implements ActionListener {

    static final int WIDTH = 500;
    static final int HEIGHT = 500;

    private final int ballsize = 20;
    private final int halfsize = ballsize / 2;
    private Timer timer;

    private float speedX = 10;
    private float speedY = 10;

    private float ballX = WIDTH / 2;
    private float ballY = HEIGHT / 2;

    public BallBounce() {
        timer = new Timer(50, this);
        timer.start();
    }

    public float random() {
        float random = ((float) Math.random() * 10 + 10);
        return random;
    }

    public void changeSpeed() {
        if (ballX > (WIDTH - ballsize) || (ballX < 0)) {
            if (speedX > 0) {
                speedX = -1 * (random());
            } else {
                speedX = random();

            }
        }
        if ((ballY > HEIGHT - ballsize - 40) || (ballY < 0)) {
            if (speedY > 0) {
                speedY = -1 * (random());
            } else {
                speedY = random();

            }
        }
        restrictVel();

    }

    public void restrictVel() {
        float t = (float) (Math.abs(speedX) / Math.abs(speedY));
        if (t > 10 || t < 0.1) {
            changeSpeed();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval((int) ballX, (int) ballY, ballsize, ballsize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeSpeed();
        ballX += speedX;
        ballY += speedY;
        System.out.println(ballX);
        System.out.println(ballY);
        repaint();

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new BallBounce());
        frame.setTitle("Ball Bounce");
        frame.setDefaultCloseOperation(3);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }

}
