package javadot;

import edu.princeton.cs.algs4.*;

public class CompareST {

    public static double timeBinarySearch(int arraySize, int numTrials, long seed) {
        //búa til bst og setja inn í það (0.0),(1.1),...,(arraySize-1.arraySize-1)
        BinarySearchST<Integer, Integer> bst = new BinarySearchST<>();
        for (Integer i = 0; i < arraySize; i++) {
            bst.put(i, i);
        }

        //leita að random Lykli sem er hér af taginu Integer í bst.
        StopwatchCPU timer = new StopwatchCPU();
        StdRandom.setSeed(seed);
        for (int i = 0; i < numTrials; i++ ) {
            Integer searchFor = StdRandom.uniform(0,arraySize-1);
            bst.contains(searchFor);
        }
        return timer.elapsedTime()/ (double) numTrials;
    }

    public static void main(String[] args) {
        /* Skilgreining gagna */

        int maxArraySize = 5000000;  // Mesta stærð á fylki sem við ætlum að tímamæla
        int stride =       50000;    // Bil á milli stærða
        int numTrials =    20000;    // Fjöldi mælinga fyrir hverja stærð fylkis
        long seed =        28022018; // Samræmt seed

        StopwatchCPU timer = new StopwatchCPU();
        /* Mælingar */
        timeBinarySearch(maxArraySize, numTrials, seed); // Keyrt einu sinni í upphafi

        int n = stride;
        double time, maxTime = 0;
        double[] times = new double[maxArraySize / stride];
        for (int j = 0; j < 1; j++ ) {
            for (int i = 0; i < maxArraySize / stride; i++) {
                time = timeBinarySearch(n, numTrials, seed);
                times[i] = time;
                n += stride;
                if (time > maxTime) {
                    maxTime = time;
                }

            }
        }

        // Teikning á niðurstöðum
        StdDraw.setXscale(0, maxArraySize);
        StdDraw.setYscale(0, maxTime * 1.05);
        StdDraw.setPenRadius(.01);
        n = 0;
        for (double timei : times) {
            StdDraw.point(n, timei);
            n += stride;
        }

        StdOut.println("Keyrslan tók " + timer.elapsedTime() + " sekúndur");
    }

}