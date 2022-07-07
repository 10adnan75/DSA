public class BinaryTreeModel {
    private Object data;
    private BinaryTreeModel leftChild;
    private BinaryTreeModel rightChild;

    public BinaryTreeModel(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinaryTreeModel getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(BinaryTreeModel leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeModel getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(BinaryTreeModel rightChild) {
        this.rightChild = rightChild;
    }
}
