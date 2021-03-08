package chap12;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;

public class TextAreaFrame extends JFrame implements ActionListener {

    private JTextField textFiled;
    private JTextArea textArea;

    public TextAreaFrame() {
        setTitle("text area test");
        setDefaultCloseOperation(3);

        JPanel panel = new JPanel();
        textFiled = new JTextField(30);
        textFiled.addActionListener(this);

        textArea = new JTextArea(10, 30);
        textArea.setPreferredSize(new Dimension(300, 200));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea); // 이후 textArea를 패널에 add하면 안됨!!!
        scrollPane.setVerticalScrollBarPolicy(22);

        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);
        add(textFiled, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textFiled.getText();
        textArea.append(text + "\n");
        textFiled.selectAll();
        textFiled.setText("");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        new TextAreaFrame();
    }
}
