package chap11;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoreShapes extends JFrame {
    public MoreShapes() {
        setSize(600, 200);
        setTitle("java 2d shapes");
        setDefaultCloseOperation(3);
        JPanel panel = new MyPanel();
        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MoreShapes();
    }

}

class MyPanel extends JPanel {
    ArrayList<Shape> shapeArray = new ArrayList<Shape>();

    public MyPanel() {

        Shape s;

        s = new Rectangle2D.Float(10, 10, 70, 80);
        shapeArray.add(s);

        s = new RoundRectangle2D.Float(110, 10, 70, 100, 20, 50);
        shapeArray.add(s);

        s = new Ellipse2D.Float(210, 10, 80, 40);
        shapeArray.add(s);

        s = new Arc2D.Float(310, 10, 80, 80, 90, 30, Arc2D.OPEN);
        shapeArray.add(s);

        s = new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);
        shapeArray.add(s);

        s = new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);
        shapeArray.add(s);
        // ________v 여기를 기준으로 각도 기준이 되고, 시계 반대 방향으로 다음 int 값 만큼 각도에 점 찍힘

    }

    public void paintComponent(Graphics g) {
        // Graphics g는 해당 프레임의 그래픽 객체이므로 선언하지 않아도 됨
        // Graphics z클래스에는 그림을 그리기 위한 모든 설정 값과 메소드를 가지고 있음
        super.paintComponent(g);
        // 자기 자신 뿐만 아니라 부모거 페인팅되기 위한 코드
        Graphics2D g2 = (Graphics2D) g; // 형변환

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티얼라이싱 키기

        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(3));
        for (Shape s : shapeArray)
            g2.draw(s);

    }

}