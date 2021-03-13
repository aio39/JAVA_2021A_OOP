package chap12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener {

    private int sum, temp1, temp2, temp3;
    private JButton order_button, cancel_button;
    private JPanel down_panel;
    private JTextField text;

    MenuButtonListener menuButtonListener = new MenuButtonListener();

    public class JRadioButtonHavePrice extends JRadioButton {
        public int price;
        public int menu;

        /**
         * @param price
         */
        public JRadioButtonHavePrice(String text, boolean selected, int price, int menu) {
            super(text, selected);
            this.price = price;
            this.menu = menu;
        }

        /**
         * @return the price
         */
        public int getPrice() {
            return price;
        }

        /**
         * @param price the price to set
         */
        public void setPrice(int price) {
            this.price = price;
        }

        /**
         * @return the menu
         */
        public int getMenu() {
            return menu;
        }

        /**
         * @param menu the menu to set
         */
        public void setMenu(int menu) {
            this.menu = menu;
        }

    }

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
            sum = temp1 + temp2 + temp3;
            this.text.setText("" + sum);
        }
        if (e.getSource() == this.cancel_button) {
            sum = 0;
            this.text.setText("" + sum);
        }
    }

    private class MenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int price = ((JRadioButtonHavePrice) e.getSource()).getPrice();
            int menu = ((JRadioButtonHavePrice) e.getSource()).getMenu();
            System.out.println("prcie:" + price + "menu:" + menu);
            switch (menu) {
            case 1:
                temp1 = price;
                break;
            case 2:
                temp2 = price;
                break;
            case 3:
                temp3 = price;
                break;
            default:
                break;
            }
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
        private JRadioButtonHavePrice combo, potato, bulgogi;
        private ButtonGroup bg;

        public TypePanel() {
            setLayout(new GridLayout(3, 1));

            combo = new JRadioButtonHavePrice("콤보", true, 10000, 1);
            potato = new JRadioButtonHavePrice("포테이토", false, 11000, 1);
            bulgogi = new JRadioButtonHavePrice("불고기", false, 12000, 1);

            combo.addActionListener(menuButtonListener);
            potato.addActionListener(menuButtonListener);
            bulgogi.addActionListener(menuButtonListener);

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
        private JRadioButtonHavePrice pepper, cheese, peperoni, bacon;
        private ButtonGroup bg;

        public ToppingPanel() {
            setLayout(new GridLayout(3, 1));

            pepper = new JRadioButtonHavePrice("피망", true, 1000, 2);
            cheese = new JRadioButtonHavePrice("치즈", false, 2000, 2);
            peperoni = new JRadioButtonHavePrice("페퍼로니", false, 3000, 2);
            bacon = new JRadioButtonHavePrice("베이컨", false, 4000, 2);

            pepper.addActionListener(menuButtonListener);
            cheese.addActionListener(menuButtonListener);
            peperoni.addActionListener(menuButtonListener);
            bacon.addActionListener(menuButtonListener);

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
        private JRadioButtonHavePrice small, medium, large;
        private ButtonGroup bg;

        public SizePanel() {
            setLayout(new GridLayout(3, 1));

            small = new JRadioButtonHavePrice("Small", true, 0, 3);
            medium = new JRadioButtonHavePrice("Medium", false, 3000, 3);
            large = new JRadioButtonHavePrice("Large", false, 5000, 3);

            small.addActionListener(menuButtonListener);
            medium.addActionListener(menuButtonListener);
            large.addActionListener(menuButtonListener);

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
}

public class PizzaTest {
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }
}