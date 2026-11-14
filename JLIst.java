import javax.swing.*;

public class MyList {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(250, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] items = {"Java", "Python", "C++", "JavaScript", "Go"};
        JList<String> list = new JList<>(items);

        frame.add(new JScrollPane(list));
        frame.setVisible(true);
    }
}
