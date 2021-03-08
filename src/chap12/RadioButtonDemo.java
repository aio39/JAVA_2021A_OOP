package chap12;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {

    private JPanel topPanel, sizePanel, resultPanel;

    private JRadioButton small, medium, large;

    private JLabel textLabel; // 여러 메소들에서 참조해야함

    public RadioButtonDemo() {
        topPanel = new JPanel();
        JLabel label = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
        topPanel.add(label);

        sizePanel = new JPanel();

        small = new JRadioButton("small size");
        small.addActionListener(this);
        medium = new JRadioButton("medium size");
        medium.addActionListener(this);
        large = new JRadioButton("large size");
        large.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(small);
        group.add(medium);
        group.add(large);

        sizePanel.add(small);
        sizePanel.add(medium);
        sizePanel.add(large);

        // 라디오 버튼을 감싸는 경계선
        Border border = BorderFactory.createTitledBorder("사이즈");
        sizePanel.setBorder(border);

        this.add(sizePanel, BorderLayout.CENTER);

        resultPanel = new JPanel();
        textLabel = new JLabel("크기가 선택되지 않았습니다.");
        textLabel.setForeground(Color.red);
        resultPanel.add(textLabel);

        this.add(resultPanel, BorderLayout.SOUTH);

        this.setSize(300, 150);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == small) {
            textLabel.setText("Small 크기가 선택되었습니다.");
        } else if (e.getSource() == medium) {
            textLabel.setText("Medium 크기가 선택되었습니다.");
        } else {
            textLabel.setText("Large 크기가 선택되었습니다.");
        }

    }

    public static void main(String[] args) {
        new RadioButtonDemo();
    }

}
