package chap15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SimpleDictionary extends JPanel implements ActionListener {
    private JTextField inputField = new JTextField(30);
    private JButton searchBtn = new JButton("검색");
    private JButton addBtn = new JButton("추가");
    private JPanel searchAddPanel = new JPanel();
    private Map<String, String> dict = new HashMap<>();

    public SimpleDictionary() {
        searchAddPanel.add(inputField);
        searchAddPanel.add(searchBtn);
        searchBtn.addActionListener(this);
        searchAddPanel.add(addBtn);

        addBtn.addActionListener(this);
        searchAddPanel.setPreferredSize(new Dimension(600, 50));

        this.setLayout(new BorderLayout());
        this.add(searchAddPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            String key = inputField.getText();
            String value = dict.get(key);
            if (key.trim().length() == 0 || value == null) {
                JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다.", "단어 찾기 실패", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);

            }
            inputField.requestFocus();
        } else if (e.getSource() == addBtn) { //
            String key = inputField.getText();
            String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영어 단어를 입력하세요");

            if (key.trim().length() > 0 && value.trim().length() > 0) {
                dict.put(key, value);
                JOptionPane.showMessageDialog(this, "영어 단어가 추가되었습니다.", "추가 성공", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        JPanel panel = new SimpleDictionary();

        JFrame frame = new JFrame();

        frame.setTitle("나의 영어 단어장");
        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
