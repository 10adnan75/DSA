import java.io.FileNotFoundException;
import java.io.PrintStream;

public class BinaryTree {
    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeModel root = new BinaryTreeModel("root");

        BinaryTreeModel node1 = new BinaryTreeModel("node1");
        BinaryTreeModel node2 = new BinaryTreeModel("node2");
        root.setLeftChild(node1);
        root.setRightChild(node2);

        BinaryTreeModel node3 = new BinaryTreeModel("node3");
        BinaryTreeModel node4 = new BinaryTreeModel("node4");
        node1.setLeftChild(node3);
        node1.setRightChild(node4);

        node2.setLeftChild(new BinaryTreeModel("node5"));
        node2.setRightChild(new BinaryTreeModel("node6"));

        BinaryTreeModel node7 = new BinaryTreeModel("node7");
        node3.setLeftChild(node7);
        node7.setLeftChild(new BinaryTreeModel("node8"));
        node7.setRightChild(new BinaryTreeModel("node9"));

        BinaryTreePrinter bTree = new BinaryTreePrinter(root);
        bTree.print(new PrintStream("output.txt"));
    }
}
