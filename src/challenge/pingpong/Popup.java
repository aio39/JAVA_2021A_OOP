package challenge.pingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Popup {

    public Popup() {
    }

    public void draw(Graphics g) {
        int fontSize = 70;
        String winner = "Winner - " + Game.winner;
        Font font = new Font("Serif", Font.BOLD, fontSize);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(winner, 100, 300);
        g.drawString("Press Enter to ReStart", 80, 500);
    }

}
