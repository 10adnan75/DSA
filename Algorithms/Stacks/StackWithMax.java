public class StackWithMax<E> {
    private E[] stack;
    private int N;

    public StackWithMax() {
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
        if (N >= 0) System.arraycopy(stack, 0, newStack, 0, N);
        stack = newStack;
    }

    public void push(E data) {
        stack[N++] = data;
        if (N == stack.length) resize(stack.length * 2);
    }

    public E pop() {
        if (isEmpty()) throw new NullPointerException("Stack underflow!");
        E data = stack[--N];
        stack[N] = null;
        if (N > 0 && N == stack.length / 4) resize(stack.length / 2);
        return data;
    }

    public int getMax() {
        if (isEmpty()) throw new NullPointerException("Stack underflow!");
        int copySize = N, max = 0;
        while (copySize-- > 0) {
            if ((int) stack[copySize] > max) max = (int) stack[copySize];
        }
        return max;
    }

    public void display() {
        if (isEmpty()) throw new NullPointerException("Stack underflow!");
        int copySize = N;
        while (copySize-- > 0) System.out.print(stack[copySize] + " ");
    }

    public static void main(String[] args) {
        StackWithMax<Integer> stack = new StackWithMax<>();
        int i = 0;
        while (i++ < 20) stack.push(i);
        for (; i > 10; i--) {
            System.out.println("Max: " + stack.getMax() + ", Popped element: " + stack.pop());
        }
        System.out.print("\nStack: "); stack.display();
        System.out.println("\nStack size: " + stack.size());
    }
}

/*
    OUTPUT:
    Max: 20, Popped element: 20
    Max: 19, Popped element: 19
    Max: 18, Popped element: 18
    Max: 17, Popped element: 17
    Max: 16, Popped element: 16
    Max: 15, Popped element: 15
    Max: 14, Popped element: 14
    Max: 13, Popped element: 13
    Max: 12, Popped element: 12
    Max: 11, Popped element: 11
    Max: 10, Popped element: 10

    Stack: 9 8 7 6 5 4 3 2 1
    Stack size: 9
 */
