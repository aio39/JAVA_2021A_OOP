package chap12;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.*;
import java.io.File;

public class ImageLabelTest extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public ImageLabelTest() {
        this.setSize(300, 250);
        this.setDefaultCloseOperation(3);

        panel = new JPanel();
        label = new JLabel("이미지를 보려면 버튼을 누르세요");

        button = new JButton("이미지 보기");

        ImageIcon icon = new ImageIcon("icon.gif");

        button.setIcon(icon);

        button.addActionListener(this);

        panel.add(label);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ImageLabelTest();
    }

    ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        ImageIcon dog = new ImageIcon("src/chap12/dog.png");
        Image temp = dog.getImage(); // transform it
        Image resizedImgae = temp.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        dog = new ImageIcon(resizedImgae); // transform it back

        File file = new File("dog.png");
        System.out.println(file.getAbsolutePath()); // 파일 경로 얻기

        label.setIcon(dog);
        label.setText(null);

    }

}
