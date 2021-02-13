public class StackArray<E> {
    private E[] stack;
    private int N;

    public StackArray() {
        stack = (E[]) new Object[1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int capacity) {
        E[] newStack = (E[]) new Object[capacity];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public void push(E data) {
        stack[N++] = data;
        if (N == stack.length) resize(stack.length * 2);
    }

    public E pop() {
        if (isEmpty()) throw new NullPointerException("Stack underflow!");
        return stack[--N];
    }

    public void display() {
        if (isEmpty()) throw new NullPointerException("Stack underflow!");
        int copySize = N;
        while (copySize-- > 0) System.out.print(stack[copySize] + " ");
    }

    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>();
        int i = 0;
        while (i++ < 10) stack.push(i);
        for (; i > 5; i--) System.out.println(stack.pop());
        stack.display();
        System.out.println("\nStack size: " + stack.size());
    }
}
