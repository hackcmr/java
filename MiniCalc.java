import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniCalc extends JFrame implements ActionListener {
    JTextField display = new JTextField();
    double num1 = 0;
    String op = "";

    public MiniCalc() {
        setTitle("Calculator");
        setSize(250, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 22));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if ("0123456789".contains(cmd)) {
            display.setText(display.getText() + cmd);
        } else if (cmd.equals("C")) {
            display.setText("");
            num1 = 0;
            op = "";
        } else if (cmd.equals("=")) {
            double num2 = Double.parseDouble(display.getText());
            switch (op) {
                case "+" -> display.setText(String.valueOf(num1 + num2));
                case "-" -> display.setText(String.valueOf(num1 - num2));
                case "*" -> display.setText(String.valueOf(num1 * num2));
                case "/" -> display.setText(num2 != 0 ? String.valueOf(num1 / num2) : "Error");
            }
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
