import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {

    JTextField display;
    double num1, num2, result;
    char operator;

    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, modButton;
    JButton decimalButton, equalButton, clearButton;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 25));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Number buttons 0-9
        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].addActionListener(this);
        }

        // Operation buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        JButton[] operationButtons = {
            addButton, subButton, mulButton, divButton,
            modButton, decimalButton, equalButton, clearButton
        };

        for (JButton button : operationButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
        }

        // 4 x 4 GridLayout
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);

        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        panel.add(equalButton);
        panel.add(addButton);

        add(panel, BorderLayout.CENTER);

        // Extra buttons
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        bottomPanel.add(modButton);
        bottomPanel.add(clearButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // Numbers
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        }

        // Decimal point
        else if (command.equals(".")) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        }

        // Clear
        else if (command.equals("C")) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = '\0';
        }

        // Operators
        else if (command.equals("+") || command.equals("-") ||
                 command.equals("*") || command.equals("/") ||
                 command.equals("%")) {

            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        }

        // Equals
        else if (command.equals("=")) {

            if (!display.getText().isEmpty()) {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        if (num2 == 0) {
                            display.setText("Cannot divide by 0");
                            return;
                        }
                        result = num1 / num2;
                        break;

                    case '%':
                        result = num1 % num2;
                        break;
                }

                display.setText(String.valueOf(result));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
