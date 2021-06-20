import java.util.Stack;

public class QueueWithStacks {
    Stack<Integer> stack1, stack2;

    public QueueWithStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enQueue(int data) {
        stack1.push(data);
    }

    public int deQueue() {
        stackExchange();
        return stack2.pop();
    }

    public int peek() {
        stackExchange();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void stackExchange() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueWithStacks queueWithStacks = new QueueWithStacks();
        for (int i=1; i<11; i++) queueWithStacks.enQueue(i);
        while (!queueWithStacks.isEmpty()) System.out.print(queueWithStacks.deQueue() + " ");
    }
}

/*
        OUTPUT:
        1 2 3 4 5 6 7 8 9 10
 */
