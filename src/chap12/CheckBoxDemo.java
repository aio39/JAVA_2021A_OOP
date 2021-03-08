package chap12;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxDemo extends JPanel implements ItemListener {

    JCheckBox[] checkBoxes = new JCheckBox[4];
    String[] fruits = { "apple", "grape", "orange" };
    JLabel[] pictureLabel = new JLabel[3];
    ImageIcon[] icon = new ImageIcon[3];

    public CheckBoxDemo() {
        // super(new GridLayout(0, 4)); (오버라이딩 하지 않으면 this super가 같음)
        this.setLayout(new GridLayout(0, 4));

        for (int i = 0; i < checkBoxes.length; i++) {
            if (i == (checkBoxes.length - 1)) {
                checkBoxes[i] = new JCheckBox("all");
                checkBoxes[i].addItemListener(this);
                System.out.println("all");
            } else {
                System.out.println(i);
                checkBoxes[i] = new JCheckBox(fruits[i]);
                checkBoxes[i].addItemListener(this);
                pictureLabel[i] = new JLabel(fruits[i] + ".jpg");
                icon[i] = new ImageIcon("src/chap12/" + fruits[i] + ".jpg");
            }
        }

        JPanel checkPanel = new JPanel(new GridLayout(0, 1)); // 한 줄로 쭈우욱
        for (int i = 0; i < checkBoxes.length; i++)
            checkPanel.add(checkBoxes[i]);

        add(checkPanel);

        for (int i = 0; i < pictureLabel.length; i++) {
            add(pictureLabel[i]);

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        // ImageIcon image = null;

        Object source = e.getItemSelectable();
        for (int i = 0; i < checkBoxes.length; i++) {
            if (source == checkBoxes[i]) {
                if (i == fruits.length) {
                    for (int j = 0; j < fruits.length; j++) {
                        if (e.getStateChange() == ItemEvent.DESELECTED) {
                            pictureLabel[j].setIcon(null);
                            pictureLabel[j].setText(fruits[j] + ".jpg");
                            checkBoxes[j].setSelected(false);
                        } else {
                            pictureLabel[j].setIcon(icon[j]);
                            pictureLabel[j].setText("");
                            checkBoxes[j].setSelected(true);

                        }

                    }
                } else {
                    if (e.getStateChange() == ItemEvent.DESELECTED) {
                        pictureLabel[i].setIcon(null);
                        pictureLabel[i].setText(fruits[i] + ".jpg");
                    } else {
                        pictureLabel[i].setIcon(icon[i]);
                        pictureLabel[i].setText("");
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBox");
        frame.setDefaultCloseOperation(3);
        CheckBoxDemo panel = new CheckBoxDemo();
        panel.setOpaque(true);
        frame.add(panel);
        frame.setSize(500, 200);
        frame.setVisible(true);

    }

}
