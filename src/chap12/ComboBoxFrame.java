package chap12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame implements ActionListener {

    JLabel label;

    public ComboBoxFrame() {
        setTitle("ComboBoxFrame");
        setDefaultCloseOperation(3);
        setSize(300, 200);

        String[] animals = { "lion", "cat", "monkey" };
        JComboBox animalList = new JComboBox(animals);

        animalList.setSelectedIndex(0);
        animalList.addActionListener(this);
        animalList.setEditable(true);

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        changePicture(animals[animalList.getSelectedIndex()]);
        add(animalList, BorderLayout.PAGE_START);
        // ComboBox로 선택을 받으면 이벤트리스너로 Label의 이미지를 수정하는 메소드를 실행시킨다.
        add(label, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "comboBoxEdited") {

            JComboBox cb = (JComboBox) e.getSource();
            String text = (String) cb.getSelectedItem();
            cb.addItem(text);

        }

        if (e.getActionCommand() == "comboBoxChanged") {

            JComboBox cb = (JComboBox) e.getSource();
            String name = (String) cb.getSelectedItem();
            System.out.println(name);
            changePicture(name);
        }
    }

    public void changePicture(String name) {
        ImageIcon icon = new ImageIcon("src/chap12/" + name + ".jpg");
        label.setIcon(icon);
        if (icon != null) {
            label.setText(null);
        } else {
            label.setText("이미지가 없습니다.");
        }

    }

    public static void main(String[] args) {
        ComboBoxFrame frame = new ComboBoxFrame();
    }
}
