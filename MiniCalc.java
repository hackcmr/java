import javax.swing.*;
import java.awt.*;

public class MiniCalc extends JFrame {
    JTextField display = new JTextField();
    double num1 = 0;
    String op = "";

    public MiniCalc() {
        setSize(250, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4));
        for (String text : "7,8,9,/,4,5,6,*,1,2,3,-,C,0,=,+" .split(",")) {
            JButton btn = new JButton(text);
            btn.addActionListener(e -> handle(text));
            panel.add(btn);
        }

        add(panel);
        setVisible(true);
    }

    void handle(String cmd) {
        if ("0123456789".contains(cmd)) {
            display.setText(display.getText() + cmd);
        } else if (cmd.equals("C")) {
            display.setText("");
        } else if (cmd.equals("=")) {
            double num2 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(switch (op) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                default -> num1 / num2;
            }));
        } else {
            num1 = Double.parseDouble(display.getText());
            op = cmd;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new MiniCalc();
    }
}
