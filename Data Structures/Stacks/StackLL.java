public class StackLL<E> {
    private Node TOP;
    private int size;

    private class Node {
        private E data;
        private Node next;
    }

    public StackLL() {
        this.TOP = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return TOP == null;
    }

    public int size() {
        return size;
    }

    public void push(E data) {
        Node oldTop = TOP;
        TOP = new Node();
        TOP.data = data;
        TOP.next = oldTop;
        size++;
    }

    public E pop() {
        if (isEmpty()) throw new NullPointerException("Stack underflow!\n");
        E data = TOP.data;
        TOP = TOP.next;
        size--;
        return data;
    }

    public E top() {
        if (isEmpty()) throw new NullPointerException("Stack is empty!\n");
        return TOP.data;
    }

    public void display() {
        if (isEmpty()) throw new NullPointerException("Stack is empty!\n");
        Node node = TOP;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        StackLL<Integer> stack = new StackLL<>();
        int i = 11;
        while (i-- > 1) stack.push(i);
        stack.display();
    }
}
