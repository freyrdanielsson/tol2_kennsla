package javadot;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {


    private class Node {

        Node next;
        T data;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int length;

    SinglyLinkedList() {
        /*
        Smiður sem upphafsstillir tóman lista.
         */
        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        /*
        Skilar sönnu innihaldi listinn engin stök, annars ósönnu
         */
        return this.head == null;
    }

    public int size() {
        /*
        Skilar fjölda staka í listanum.
         */
        return this.length;
    }

    @Override
    public String toString() {
        /*
        Aðferð sem sýnir fallega strengjaframsetningu á listanum.
         */
        Node node = this.head;
        String representation = "";
        while (node != null) {
            representation += node.data.toString() + " -> "; // Ath. að þetta er ekki skilvirkt, dekkum seinna
            node = node.next;
        }
        return representation + "Ø";
    }

    public T get(int index) {
        /*
        Skilar staki númer <index> í listanum án þess að breyta honum.
         */
        if (index < 0 || this.size() <= index) {
            throw new ArrayIndexOutOfBoundsException("Vísað út fyrir lista");
        }

        Node node = this.head;
        int i = 0;
        while (node != null) {
            if (i == index) {
                return node.data;
            }
            node = node.next;
            i++;
        }
        return null;
    }

    public void insert(int index, T data) {
        /*
        Bætir staki við listann í sæti númer <index>, án þess að yfirskrifa stak.
        Öllum stökum sem koma á eftir nýja stakinu hliðrast í átt að enda listans.
         */
        if (index < 0 || this.size() < index) {
            throw new ArrayIndexOutOfBoundsException("Vísað út fyrir lista");
        }
        if (index == 0) {
            this.head = new Node(data, this.head);
        } else {
            Node node = this.head;
            int i = 0;
            while (node.next != null && i < index - 1) {
                node = node.next;
                i++;
            }
            node.next = new Node(data, node.next);
        }
        this.length++;
    }

    public void delete(int index) {
        /*
        Fjarlægir stak númer <index> úr listanum. Númer allra staka sem á eftir koma skulu lækka.
         */
        if (index < 0 || this.size() <= index) {
            throw new ArrayIndexOutOfBoundsException("Vísað út fyrir lista");
        }

        if (index == 0) { // Sértilfelli - byrjun listans
            this.head = this.head.next; // Tryggðum í upphafi að hausinn var ekki tómur
        } else {
            Node previous = this.head;
            for (int i = 0; i < index - 1; i++) { // Ath. að i < index < size
                previous = previous.next;
            }
            previous.next = previous.next.next;
        }
        this.length--;
    }

    public void swap(int index1, int index2) {
        /*
        Skiptir á staðsetningum hnúta númer <index1> og <index2> með því að uppfæra vísanir nágranna þeirra.
        Ekki er tryggt að <index1> sé minni en <index2>.
         */
        if (index1 < 0 || index2 < 0 || this.size() <= index1 || this.size() <= index2) {
            throw new ArrayIndexOutOfBoundsException("Vísað út fyrir lista");
        }

        Node beforeFirst = null, first = null, beforeSecond = null, second = null;
        Node current = this.head;
        int i = 0;
        while (current != null) {
            if (i == index1 - 1) {
                beforeFirst = current;
            }
            if (i == index1) {
                first = current;
            }
            if (i == index2 - 1) {
                beforeSecond = current;
            }
            if (i == index2) {
                second = current;
            }
            current = current.next;
            i++;
        }
        Node temp;
        if (beforeFirst != null && beforeSecond != null) {
            beforeFirst.next = second;
            beforeSecond.next = first;

        } else {
            if (beforeFirst == null) {
                this.head = second;
                beforeSecond.next = first;
            }
            if (beforeSecond == null) {
                this.head = first;
                beforeFirst.next = second;
            }
        }

        temp = first.next;
        first.next = second.next;
        second.next = temp;
    }

    public Iterator<T> iterator() {
        /*
        Einfaldur ítrari fyrir SinglyLinkedList klasann, sjá ListIterator
        */
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = head;

        public boolean hasNext() {
            return this.current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            T item = this.current.data;
            this.current = this.current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(0, 2);
        list.insert(0, 1);
        list.insert(2, 4);
        list.insert(2, 3);
        StdOut.println("Listinn er í upphafi:          " + list);
        StdOut.println("");

        // Prófum swap aðferðina
        StdOut.print("Skiptum á hnútum 1 og 3, ");
        list.swap(1, 3);
        StdOut.println("fáum: " + list);
        StdOut.print("Lagfærum listann aftur, ");
        list.swap(3, 1);
        StdOut.println("fáum:  " + list);
        StdOut.print("Prófum að skipta á endunum:    ");
        list.swap(0, list.size() - 1);
        StdOut.println(list);
        StdOut.print("Lagfærum aftur:                ");
        list.swap(list.size() - 1, 0);
        StdOut.println(list);

        // Prófum delete aðferðina
        StdOut.println("");
        StdOut.println("Hendum nú út öllum hnútunum í slembinni röð");

        int max = 10, count = 0; // Svo lykkjan keyri ekki endalaust þegar eyðingin er ókláruð
        int index = 0;
        while (!list.isEmpty() && count++ < max) {
            index = StdRandom.uniform(0, list.size()); // Veljum stak af handahófi
            StdOut.print("Hendum staki númer " + index);
            list.delete(index);
            StdOut.println(". Eftir eyðingu er listinn: " + list);
        }
    }
}