package chap12;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// todo 이미지 사이즈 자체도 조정 
// todo - layout 적용 

public class SliderFrame extends JFrame implements ChangeListener {

    static final int INIT_VALUE = 15;
    private JButton buttonOK;
    private JSlider slider;
    private JButton button;

    public SliderFrame() {
        JPanel panel;

        setTitle("SliderFrame");
        setDefaultCloseOperation(3);

        panel = new JPanel();
        JLabel label = new JLabel("슬라이더를 움직여 보세요", JLabel.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        slider = new JSlider(0, 50, INIT_VALUE);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        panel.add(slider);

        button = new JButton("");
        ImageIcon icon = new ImageIcon("src/chap12/cat.jpg");
        button.setIcon(icon);
        button.setSize(INIT_VALUE * 10, INIT_VALUE * 10);
        panel.add(button);
        add(panel);

        setSize(300, 300);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        JSlider source = (JSlider) e.getSource();
        // !getValueIsAdjusting으로 하면 조정 중ing 일때는 메소드가 실행되지 않게한다.
        // if (!source.getValueIsAdjusting()) {
        // int value = (int) source.getValue();
        // button.setSize(value * 10, value * 10);
        // }

        int value = (int) source.getValue();
        button.setSize(value * 10, value * 10);

    }

    public static void main(String[] args) {
        new SliderFrame();
    }
}
