package chap12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextConverter extends JFrame {
    JButton converter;
    JButton canceler;
    JTextArea textIn;
    JTextArea textOut;

    public TextConverter() {
        super("텍스트 변환 "); // ??

        textIn = new JTextArea(10, 14); // row column
        textOut = new JTextArea(10, 14);
        textIn.setLineWrap(true); // 자동 줄 바꿈
        textOut.setLineWrap(true);
        textOut.setEnabled(false); // 출력 창은 조작 불가로 한다 .

        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20)); // row column gap gap
        textAreaPanel.add(textIn);
        textAreaPanel.add(textOut);

        converter = new JButton("Translate");
        canceler = new JButton("Cancel");
        converter.addActionListener(new ButtonActionListener());
        canceler.addActionListener(new ButtonActionListener());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(converter);
        buttonPanel.add(canceler);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // 갭
        mainPanel.add(BorderLayout.CENTER, textAreaPanel);
        mainPanel.add(BorderLayout.SOUTH, buttonPanel);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        add(mainPanel);
        pack(); // 내용물에 알 맞게 창 사이즈를 조절 해준다.
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == converter) {
                textOut.setText("");
                String result = toEnglish(textIn.getText());
                textOut.append(result);
            }
            if (e.getSource() == canceler) {
                textOut.setText("");
            }

        }

        private String toEnglish(String korean) {
            String result = korean;
            result = result.replace("텍스트", "Text");
            result = result.replace("영어", "English");
            return result;
        }
    }

    public static void main(String[] args) {
        TextConverter translate = new TextConverter();
    }
}
