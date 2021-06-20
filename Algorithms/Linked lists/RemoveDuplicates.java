import java.util.Scanner;

public class RemoveDuplicates {

    private static class Node {
        private final int data;
        private Node next;

        public Node() {
            this(0);
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public void add(Node head, int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else if (head.next == null) {
                head.next = newNode;
            } else {
                Node start = head;
                while (start.next != null) {
                    start = start.next;
                }
                start.next = newNode;
            }
        }

        public void display(Node head) {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
                System.out.print(curr.data + " ");
            }
        }
    }

    public static void removeDuplicates(Node ll) {
        Node curr = ll;
        while (curr != null) {
            Node next = curr.next;
            while (next != null && next.data == curr.data) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Node linkedList = new Node();
        System.out.print("Enter size: "); int size = input.nextInt();
        System.out.print("Enter keys: "); for (int i=0; i<size; i++) linkedList.add(linkedList, input.nextInt());
        RemoveDuplicates.removeDuplicates(linkedList);
        System.out.print("After removing duplicates: "); linkedList.display(linkedList);
    }
}

/*
        OUTPUT:
        Enter size: 5
        Enter keys: 1 1 1 2 3
        After removing duplicates: 1 2 3
 */
