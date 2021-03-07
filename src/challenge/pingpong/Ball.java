package challenge.pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

    public static final int SIZE = 16;

    private int x, y;
    private int xVel, yVel;
    private int speed = 5;

    public Ball() {

        reset();

    }

    public static int sign(double d) {
        if (d >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    void reset() {

        x = Game.WIDTH / 2 - SIZE / 2;
        y = Game.HEIGHT / 2 - SIZE / 2;

        xVel = sign(Math.random() * 2 - 1);
        yVel = sign(Math.random() * 2 - 1);

    }

    public void changeXDir() {
        xVel *= -1;
    }

    public void changeYDir() {
        yVel *= -1;
    }

    public void draw(Graphics g) {

        g.setColor(Color.white);
        g.fillOval(x, y, SIZE, SIZE);

    }

    public void update(Paddle paddle1, Paddle paddle2) {
        x += xVel * speed;
        y += yVel * speed;

        if (y >= Game.HEIGHT - SIZE || y <= 0) {
            changeYDir();
        }

        if (x >= Game.WIDTH - SIZE) {
            paddle1.addPoint();
            reset();
        }
        if (x <= 0) {
            paddle2.addPoint();
            reset();
        }
    }

    public void stop() {
        xVel = 0;
        yVel = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}