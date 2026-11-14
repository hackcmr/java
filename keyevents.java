import javax.swing.*;
import java.awt.event.*;

public class MinimalKeyEvent {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Keyboard Event");
        JLabel label = new JLabel("Press any key", SwingConstants.CENTER);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + e.getKeyChar());
            }
        });

        frame.add(label);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
