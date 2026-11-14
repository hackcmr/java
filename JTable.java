import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class MinimalTableExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Define column headers and row data
            String[] columns = {"ID", "Name", "Role"};
            Object[][] data = {
                {1, "Alice", "Developer"},
                {2, "Bob", "Designer"},
                {3, "Charlie", "Manager"},
                {4, "Diana", "QA Engineer"},
                {5, "Evan", "DevOps"}
            };

            // 2. Create the JTable and place it inside a JScrollPane
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);

            // 3. Set up the JFrame window
            JFrame frame = new JFrame("JTable & JScrollPane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(400, 150); // Intentionally short so the scrollbar is visible
            frame.setLocationRelativeTo(null); // Center on screen
            frame.setVisible(true);
        });
    }
}
