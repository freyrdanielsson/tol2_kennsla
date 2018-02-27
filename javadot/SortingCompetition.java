package javadot;

import edu.princeton.cs.algs4.*;
import static javadot.PlotRunningTimes.timeInsertionSort;

public class SortingCompetition {


    private static long timeMergeSort(int arraySize, int numTrials, long seed) {
        /*
        Skilar meðalkeyrslutíma sameiningarröðunar á slembfylki af stærð arraySize eftir numTrials keyrslur.
         */
        long before, after;
        long totalElapsed = 0;
        Double[] a;

        for (int i = 0; i < numTrials; i++) {
            a = MoreRandom.getRandomDoubleArray(arraySize, seed);
            before = System.nanoTime();
            Merge.sort(a);
            after = System.nanoTime();
            totalElapsed += (after - before);
        }

        return totalElapsed / numTrials;
    }


    public static void main(String[] args) {

        int maxN = 1000; // Við gefumst upp eftir 1000 stök
        int numTrials = 50000; // Fjöldi mælinga fyrir hverja stærð fylkis, hér mjög stórt
        long seed = 203; // Fastur grunnur fyrir slembitölugjafann
        int n = 10; // Byrjum að skoða fylki í þessari stærð

        long insertionTime = 0;
        long mergeTime = Long.MAX_VALUE;
        while ( n < maxN) {
            insertionTime = timeInsertionSort(n, numTrials, seed);
            mergeTime = timeMergeSort(n, numTrials, seed);
            StdOut.println("size: " + n);
            StdOut.println("insertionSort: " + insertionTime);
            StdOut.println("mergeSort: " + mergeTime + '\n');
            n++;
        }
    }

}