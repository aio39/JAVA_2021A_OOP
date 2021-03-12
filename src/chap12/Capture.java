package chap12;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jdk.vm.ci.hotspot.JFR;

public class Capture {
    public static void main(String[] args) {
        JFrame capture = new JFrame();
        capture.setDefaultCloseOperation(3);

        Dimension d;
        Rectangle rect = new Rectangle(500, 500);
        capture.setSize(d = new Dimension(500, 500));

        try {
            Robot robot = new Robot();
            final BufferedImage image = robot.createScreenCapture(rect); // rectangle 객체를 매개변수로 받음
            image.flush();
            JPanel panel = new JPanel() {
                public void paintComponent(Graphics g) {
                    g.drawImage(image, 0, 0, d.width, d.height, this);
                }
            };
            panel.setOpaque(false); // 불투명?
            panel.prepareImage(image, panel); // 이미지 준비
            panel.repaint();
            capture.getContentPane().add(panel); // getContentPane은 JFrame 당시 생성된 컨탠트 팬을 리턴한다.
            // 스윙에서는 컨터트팬에만 컴포넌트를 붙일 수 있다.
        } catch (Exception e) {
            e.printStackTrace();
        }

        capture.setVisible(true);

    }
}
