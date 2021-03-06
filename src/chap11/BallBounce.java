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

    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;

    private final int ballsize = 20;
    private final int halfsize = ballsize / 2;
    private Timer timer;

    private float speedX;
    private float speedY;

    private long timeXA = System.currentTimeMillis();
    private long timeXB;
    private long timeYA = System.currentTimeMillis();
    private long timeYB;

    private float ballX = WIDTH / 2;
    private float ballY = HEIGHT / 2;

    public BallBounce() {
        speedX = random();
        speedY = random();

        timer = new Timer(35, this);
        timer.start();
    }

    public float random() {
        float random = ((float) Math.random() * 10 + 10);
        return random;
    }

    public void changeSpeedX() {
        if (ballX > (WIDTH - ballsize) || (ballX < 0)) {
            if (speedX > 0) {
                speedX = -1 * (random());
            } else {
                speedX = random();
            }
            restrictVel();
        }
    }

    public void changeSpeedY() {
        if ((ballY > HEIGHT - ballsize - 40) || (ballY < 20)) {
            if (speedY > 0) {
                speedY = -1 * (random());
            } else {
                speedY = random();
            }
            restrictVel();
        }

    }

    public void restrictVel() {
        float t = (float) (Math.abs(speedX) / Math.abs(speedY));
        // 공의 방향이 너무 기울어지지 않도록 조절합니다.
        float s = (float) Math.sqrt(Math.pow(speedX, 2) + Math.pow(speedY, 2));
        // 공의 속도가 너무 느려지지 않도록 조절 합니다.
        if (t > 4 || t < 0.25 || s < 20) {
            if (ballX > (WIDTH - ballsize) || (ballX < 0))
                changeSpeedX();
            if ((ballY > HEIGHT - ballsize - 40) || (ballY < 20))
                changeSpeedY();
            // 공의 방향, 속도가 적절하지 않으면 다시 랜덤을 실행합니다.
        }
    }

    public boolean timeCheck(long time1, long time2) {
        time2 = System.currentTimeMillis();
        if ((time2 - time1) > 1000) {
            time1 = time2;
            return true;
        }
        return false;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval((int) ballX, (int) ballY, ballsize, ballsize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ballX <= (WIDTH - ballsize) && (ballX >= 0)) {
            ballX += speedX;
        } else if (timeCheck(timeXA, timeXB)) {
            changeSpeedX();
            ballX += speedX * 2;
        }

        if (ballY <= HEIGHT - ballsize - 40 && (ballY >= 20)) {
            ballY += speedY;
        } else if (timeCheck(timeYA, timeYB)) {
            changeSpeedY();
            ballY += speedY * 2;
        }

        System.out.println("X:" + ballX);
        System.out.println("Y:" + ballY);
        System.out.println("SX" + speedX);
        System.out.println("SY" + speedY);
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
