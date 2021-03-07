package challenge.pingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Paddle {

    private int x, y;
    private int vel = 0;
    private int speed = 15;
    private int width = 25, height = 100;
    private int score;
    private Color color;
    private boolean left;

    public Paddle(Color color, boolean left) {
        this.color = color;
        this.left = left;
        if (this.left) {
            x = 0;
        } else {
            x = Game.WIDTH - width;
        }
        y = Game.HEIGHT / 2 - height / 2;
    }

    public void addPoint() {
        score++;
        if (score == 3) {
            Game.ended = true;

        }

        if (left) {
            Game.winner = "Left Player";
        } else {
            Game.winner = "Right Player";
        }
    }

    public void draw(Graphics g) {

        g.setColor(color);
        g.fillRect(x, y, width, height);

        String scoreText = Integer.toString(score);
        int fontSize = 30;

        int scoreYaxis = 50;
        int scoreXaxis;
        int padding = 25;
        if (left) {
            scoreXaxis = Game.WIDTH / 2 - fontSize - padding;
        } else {
            scoreXaxis = Game.WIDTH / 2 + padding;
        }

        Font font = new Font("Serif", Font.BOLD, fontSize);
        g.setFont(font);

        g.drawString(scoreText, scoreXaxis, scoreYaxis);

    }

    public void update(Ball ball) {
        if (y > Game.HEIGHT - height) {
            y = Game.HEIGHT - height;
        } else if (y < 0) {
            y = 0;
        } else {
            y += vel;
        }

        int ballX = ball.getX();
        int ballY = ball.getY();

        if (left) {
            if (ballX <= width && ballY >= y - Ball.SIZE && ballY <= y + height) {
                ball.changeXDir();
            }
        } else {
            if (ballX >= x - Ball.SIZE && ballY >= y - Ball.SIZE && ballY <= y + height) {
                ball.changeXDir();
            }
        }

    }

    public void switchDirection(int dir) {

        vel = speed * dir;

    }

    public void stop() {

        vel = 0;

    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

}