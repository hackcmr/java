import javax.swing.*;
import java.awt.event.*;

public class MinimalMouseEvent {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Events");
        JLabel label = new JLabel("Interact with the mouse here", SwingConstants.CENTER);

        MouseAdapter mouseHandler = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Clicked at (" + e.getX() + ", " + e.getY() + ")");
            }
            public void mousePressed(MouseEvent e) {
                label.setText("Pressed at (" + e.getX() + ", " + e.getY() + ")");
            }
            public void mouseDragged(MouseEvent e) {
                label.setText("Dragging at (" + e.getX() + ", " + e.getY() + ")");
            }
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered");
            }
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited");
            }
        };

        label.addMouseListener(mouseHandler);
        label.addMouseMotionListener(mouseHandler); // Required for mouseDragged

        frame.add(label);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
