package chap12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener {

    private int sum, temp1, temp2, temp3;
    private JButton order_button, cancel_button;
    private JPanel down_panel;
    private JTextField text;

    WelcomePanel Welcom_panel = new WelcomePanel();
    TypePanel TypePanel = new TypePanel();
    ToppingPanel ToppingPanel = new ToppingPanel();
    SizePanel SizePanel = new SizePanel();

    public MyFrame() {

        this.setSize(500, 200);
        this.setDefaultCloseOperation(3);
        this.setTitle("피자 주문");

        this.order_button = new JButton("주문");
        this.order_button.addActionListener(this);

        this.cancel_button = new JButton("취소");
        this.cancel_button.addActionListener(this);

        this.text = new JTextField();
        text.setEditable(false);
        text.setColumns(6);

        down_panel = new JPanel();
        down_panel.add(this.order_button);
        down_panel.add(this.cancel_button);
        down_panel.add(this.text);

        this.setLayout(new BorderLayout());

        this.add(Welcom_panel, BorderLayout.NORTH);
        this.add(down_panel, BorderLayout.SOUTH);
        this.add(SizePanel, BorderLayout.EAST);
        this.add(TypePanel, BorderLayout.WEST);
        this.add(ToppingPanel, BorderLayout.CENTER);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.order_button) {
            this.text.setText("" + 20000);
        }
        if (e.getSource() == this.cancel_button) {
            temp1 = 0;
            temp2 = 0;
            temp3 = 0;
            sum = 0;
            this.text.setText("" + sum);
        }
    }

}

public class PizzaTest {
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }
}

class WelcomePanel extends JPanel {
    private JLabel message;

    public WelcomePanel() {
        message = new JLabel("웰컴 패널 메세지");
        add(message);

    }

}

class TypePanel extends JPanel {
    private JRadioButton combo, potato, bulgogi;
    private ButtonGroup bg;

    public TypePanel() {
        setLayout(new GridLayout(3, 1));

        combo = new JRadioButton("콤보", true);
        potato = new JRadioButton("포테이토");
        bulgogi = new JRadioButton("불고기");

        bg = new ButtonGroup();
        bg.add(combo);
        bg.add(potato);
        bg.add(bulgogi);
        setBorder(BorderFactory.createTitledBorder("메뉴"));

        add(combo);
        add(potato);
        add(bulgogi);

    }
}

class ToppingPanel extends JPanel {
    private JRadioButton pepper, cheese, peperoni, bacon;
    private ButtonGroup bg;

    public ToppingPanel() {
        setLayout(new GridLayout(3, 1));

        pepper = new JRadioButton("피망", true);
        cheese = new JRadioButton("치즈");
        peperoni = new JRadioButton("페퍼로니");
        bacon = new JRadioButton("베이컨");

        bg = new ButtonGroup();
        bg.add(pepper);
        bg.add(cheese);
        bg.add(peperoni);
        bg.add(bacon);
        setBorder(BorderFactory.createTitledBorder("메뉴"));

        add(pepper);
        add(cheese);
        add(peperoni);
        add(bacon);

    }
}

class SizePanel extends JPanel {
    private JRadioButton small, medium, large;
    private ButtonGroup bg;

    public SizePanel() {
        setLayout(new GridLayout(3, 1));

        small = new JRadioButton("Small", true);
        medium = new JRadioButton("Medium");
        large = new JRadioButton("Large");

        bg = new ButtonGroup();
        bg.add(small);
        bg.add(medium);
        bg.add(large);
        setBorder(BorderFactory.createTitledBorder("Size"));

        add(small);
        add(medium);
        add(large);

    }
}