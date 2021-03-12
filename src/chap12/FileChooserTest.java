package chap12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// fc는 modal 대화상자 - 모달은 모달 작업이 끝나기 전까지는 다른 자겅ㅂ이 중지됨

public class FileChooserTest extends JFrame implements ActionListener {
    JButton openButton, saveButton;
    JFileChooser fc;
    // 파일 선택 창만 제공하고 , 열거나 쓰는 것은 사용자가 만들어야 함

    public FileChooserTest() {
        setTitle("fiel chooser Test");
        setDefaultCloseOperation(3);
        setSize(300, 200);

        fc = new JFileChooser("C:");

        JLabel label = new JLabel("파일 선택기 컴포넌트 테스트 입니다.");
        openButton = new JButton("파일 오픈");
        openButton.addActionListener(this);

        saveButton = new JButton("파일 저장");
        saveButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(openButton);
        panel.add(saveButton);

        add(panel);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(this);
            // open 창을 열고 저장, 취소 어느 버튼을 눌렀는지 return 해준다.
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // 만약 리턴값이 OK 라면
                File file = fc.getSelectedFile();
                System.out.println(file);
            } else {

            }
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println(file);
            } else {

            }
        }
    }

    public static void main(String[] args) {
        FileChooserTest frame = new FileChooserTest();
    }

}
