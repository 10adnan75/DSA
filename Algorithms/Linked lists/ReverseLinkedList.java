import java.util.Scanner;

public class ReverseLinkedList {

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
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
        }
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Node linkedList = new Node();
        System.out.print("Enter size: "); int size = input.nextInt();
        System.out.print("Enter keys: "); for (int i=0; i<size; i++) linkedList.add(linkedList, input.nextInt());
        Node reversedLL = reverseList(linkedList);
        System.out.print("After reversing: "); linkedList.display(reversedLL);
    }
}

/*
        OUTPUT:
        Enter size: 5
        Enter keys: 1 2 3 4 5
        After reversing: 5 4 3 2 1
 */
