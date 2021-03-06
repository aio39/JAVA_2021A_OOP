package chap11;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationBasic extends JPanel implements ActionListener {

    private BufferedImage image;
    private Timer timer;
    private float x, y;

    private final float WIDTH = 500, HEIGHT = 300;
    private final float START_X = 0, START_Y = 250;

    private final float ratio = (HEIGHT / WIDTH);

    public AnimationBasic() {
        // 이미지 파일을 읽어서
        // 20ms 마다 이벤틀를 발생시키는 timer객체를 생성하고 timer를 star시킴

        File file = new File("./src/chap12/space.jpg");
        try {
            // 혹시나 권한이나 파일 유무 문제로 멈출수 있으므로
            image = ImageIO.read(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }

        x = START_X;
        y = START_Y;

        timer = new Timer(20, this);
        // this 액션 리스너
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(image, (int) x, (int) y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // X,y 좌표 변경

        if (x > (WIDTH - 100)) {
            x = WIDTH - 100;
            y = 0;
            this.timer.stop();

        } else {
            x += 1;
            y -= ratio;
        }
        repaint();

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new AnimationBasic());
        frame.setTitle("Animation Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

}