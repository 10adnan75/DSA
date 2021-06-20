import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedBag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int N;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public LinkedBag() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Iterator<Item> iterator() {
       return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedBag<String> bag = new LinkedBag<>();
        System.out.print("Enter size of bag: "); int size = input.nextInt();
        System.out.print("Enter items in bag: "); for (int i=0; i<size; i++) bag.add(input.next());
        System.out.println("Bag size: " + bag.size());
        System.out.print("Bag contents: ") ;for (String s : bag) System.out.print(s + " ");
    }
}
 /*
        OUTPUT:
        Enter size of bag: 5
        Enter items in bag: 1 2 3 4 5
        Bag size: 5
        Bag contents: 5 4 3 2 1
  */
