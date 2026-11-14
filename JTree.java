import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class FruitTree {
    public static void main(String[] args) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Fruits");
        DefaultMutableTreeNode citrus = new DefaultMutableTreeNode("Citrus");
        citrus.add(new DefaultMutableTreeNode("Orange"));
        citrus.add(new DefaultMutableTreeNode("Lemon"));

        root.add(citrus);
        root.add(new DefaultMutableTreeNode("Apple"));
        root.add(new DefaultMutableTreeNode("Banana"));

        JFrame frame = new JFrame();
        frame.setSize(250, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(new JTree(root)));
        frame.setVisible(true);
    }
}
