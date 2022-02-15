import java.util.Scanner;

public class ShuffleLL {

    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = new Node(data);
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void shuffle () {
        if (this.head == null) return;
        Node half = splitAtHalf (head);
        interleave (head, half);
        head = half;
        display();
        //for (Node curr = head; curr != null; curr = curr.next)
    }

    public Node splitAtHalf (Node first) {
        Node fast = first;
        while (fast.next.next != null) {
            fast = fast.next.next;
            first = first.next;
        }
        Node result = first.next;
        first.next = null;
        return result;
    }

    public void interleave (Node first, Node second) {
        Node tail = null;
        while (second != null) {
            if (tail == null) tail = second;
            else tail.next = second;
            Node next = second.next;
            second.next = first;
            second = next;
            tail = first;

            next = first.next;
            first.next = null;
            first = next;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShuffleLL myList = new ShuffleLL();
        int n = input.nextInt();
        while (n-- > 0) {
            myList.add(input.nextInt());
        }
        myList.shuffle();
    }
}

/*      OUTPUT:
        10
        0 1 2 3 4 5 6 7 8 9
        5 0 6 1 7 2 8 3 9 4 
*/
