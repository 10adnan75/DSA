  
public class QueueArray<E> {
    private E[] queue;
    private int head, tail, size;

    public QueueArray() {
        queue = (E[]) new Object[1];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int capacity) {
        E[] newQueue = (E[]) new Object[capacity];
        int i = head;
        for (; i < tail; i++) newQueue[i] = queue[i];
        queue = newQueue;
    }

    public void enQueue(E data) {
        if (size <= queue.length) resize(queue.length + 1);
        queue[tail++] = data;
        size++;
    }

    public E deQueue() {
        if (isEmpty()) throw new NullPointerException("Queue underflow!");
        E data = queue[head];
        queue[head] = null;
        head++;
        size--;
        if (size > 0 && size <= queue.length / 4) resize(queue.length / 2);
        return data;
    }

    public void display() {
        if (isEmpty()) throw new NullPointerException("Queue underflow!");
        for (int i = head; i < tail; i++) System.out.print(queue[i] + " ");
    }

    public static void main(String[] args) { // client
        QueueArray<Integer> que = new QueueArray<>();
        int i = 0;
        que.enQueue(786);
        que.deQueue();
        que.enQueue(3);
        que.deQueue();
        que.enQueue(3);
        que.deQueue();
        while (i++ < 10) que.enQueue(i);
        que.deQueue();
        que.deQueue();
        que.deQueue();
        que.display();
        System.out.println("\n" + que.head + " " + que.tail + " " + que.size);
    }
}
