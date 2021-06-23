public class LinkedList<E> {
    private Node<E> head;
    private int N = 0;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        return N;
    }

    public void add(E data) {
        Node<E> temp = new Node<>(data);
        if (this.head == null) {
            head = temp;
        } else {
            Node<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        N++;
    }

    public void add(int pos, E data) {
        if (pos > N+1) {
            System.out.println("Position unavailable in LinkedList");
            return;
        }
        if (pos == 1) {
            Node<E> temp = head;
            head = new Node<>(data);
            head.next = temp;
            return;
        }
        Node<E> temp = head;
        Node<E> prev = new Node<>(null);
        while (pos-1 > 0) {
            prev = temp;
            temp = temp.next;
            pos--;
        }
        prev.next = new Node<>(data);
        prev.next.next = temp;
        N++;
    }

    public void remove(E key) {
        Node<E> prev = new Node<>(null);
        prev.next = head;
        Node<E> next = head.next;
        Node<E> temp = head;
        boolean exists = false;
        if (head.data == key) {
            head = head.next;
            exists = true;
        }
        while (temp.next != null) {
            if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }
        if (!exists && String.valueOf(temp.data).equals(String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }
        if (exists) {
            N--;
        } else {
            System.out.println("Value unavailable in LinkedList");
        }
    }

    public void clear() {
        head = null;
        N = 0;
    }

    @Override
    public String toString() {
        StringBuilder S = new StringBuilder("{");
        Node<E> curr = head;
        if (curr == null) return S.append(" }").toString();
        while (curr.next != null) {
            S.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        S.append(curr.data);
        return S.append(" }").toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(100);
        list1.add(200);
        list1.add(300);
        System.out.println(list1);


        LinkedList<String> list2 = new LinkedList<>();
        list2.add("adnan");
        list2.add("shaikh");
        System.out.println(list2);

        LinkedList<Float> list3 = new LinkedList<>();
        list3.add(20.25f);
        list3.add(50.42f);
        list3.add(30.99f);
        System.out.println(list3);

        list1.clear();
        list2.clear();
        list3.clear();

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }
}

/*
        OUTPUT:
        {100 -> 200 -> 300 }
        {adnan -> shaikh }
        {20.25 -> 50.42 -> 30.99 }
        { }
        { }
        { }
 */
