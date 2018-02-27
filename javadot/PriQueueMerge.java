package javadot;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

class PriQueueMerge {

    public static <Key> MaxPQ<Key> merge(MaxPQ<Key> pq1, MaxPQ<Key> pq2) {
        // Merges two priqueues.
        // Side effect: Both input priqueues end up empty. This could be avoided by copying.
        MaxPQ<Key> newPQ = new MaxPQ<>();
        // Fetch elements from the first PriQ:
        while (!pq1.isEmpty()) {
            newPQ.insert(pq1.delMax());
        }
        // Fetch elements from the second PriQ:
        while (!pq2.isEmpty()) {
            newPQ.insert(pq2.delMax());
        }
        return newPQ;
    }

    public static void main(String[] args) {
        // Creating a PQ of odd numbers
        MaxPQ<Integer> odds = new MaxPQ<>();
        for (Integer i = 1; i < 10; i += 2) {
            odds.insert(i);
        }
        // Creating a PQ of even numbers
        MaxPQ<Integer> evens = new MaxPQ<>();
        for (Integer j = 0; j < 10; j += 2) {
            evens.insert(j);
        }
        // Performing the merger
        MaxPQ<Integer> numbersBelow10 = merge(odds, evens);
        while (!numbersBelow10.isEmpty()) {
            StdOut.print(numbersBelow10.delMax() + " ");
        }
        StdOut.println("");
    }

}