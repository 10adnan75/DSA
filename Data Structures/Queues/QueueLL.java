public class QueueLL<E> {
    private Node first, last;
    private int size;

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueLL() {
        this.first = this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enQueue(E data) {
        Node oldLast = last;
        last = new Node(data);
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    public E deQueue() {
        if (isEmpty()) throw new NullPointerException("Queue underflow!\n");
        E data = first.data;
        first = first.next;
        size--;
        return data;
    }

    public void display() {
        if (isEmpty()) throw new NullPointerException("Queue underflow!\n");
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        QueueLL<Integer> que = new QueueLL<>();
        int i = 0;
        while (i++ < 10) que.enQueue(i);
        System.out.print("Before: ");
        que.display();
        System.out.println("\nQueue size: " + que.size());
        System.out.println("Removed data: " + que.deQueue());
        System.out.println("Removed data: " + que.deQueue());
        System.out.print("After: ");
        que.display();
        System.out.println("\nQueue size: " + que.size());
    }
}
