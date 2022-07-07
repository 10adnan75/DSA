import java.io.PrintStream;

public class BinaryTreePrinter {
    private final BinaryTreeModel tree;

    public BinaryTreePrinter(BinaryTreeModel tree) {
        this.tree = tree;
    }

    private String traversePreOrder(BinaryTreeModel root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.getData());
        String pointerRight = "└──";
        String pointerLeft = (root.getRightChild() != null) ? "├──" : "└──";
        traverseNodes(sb, "", pointerLeft, root.getLeftChild(), root.getRightChild() != null);
        traverseNodes(sb, "", pointerRight, root.getRightChild(), false);
        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, BinaryTreeModel node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n").append(padding).append(pointer).append(node.getData());
            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }
            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRightChild() != null) ? "├──" : "└──";
            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeftChild(), node.getRightChild() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRightChild(), false);
        }
    }

    public void print(PrintStream os) {
        os.print(traversePreOrder(tree));
    }
}
