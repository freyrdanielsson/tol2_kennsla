package javadot;
import edu.princeton.cs.algs4.*;

public class PlotRunningTimes {


    public static long timeInsertionSort(int arraySize, int numTrials, long seed) {
        /*
        Skilar meðalkeyrslutíma innsetningarröðunar á slembfylki af stærð arraySize eftir numTrials keyrslur.
         */
        long before, after;
        long totalElapsed = 0;
        Double[] a;

        for (int i = 0; i < numTrials; i++) {
            a = MoreRandom.getRandomDoubleArray(arraySize, seed);
            before = System.nanoTime();
            Insertion.sort(a);
            after = System.nanoTime();
            totalElapsed += (after - before);
        }

         for (int i = 0; i < numTrials; i++) {
            a = MoreRandom.getRandomDoubleArray(arraySize, seed);
            before = System.nanoTime();
            Insertion.sort(a);
            after = System.nanoTime();
            totalElapsed += (after - before);
        }

        return totalElapsed / numTrials;
    }

    public static void main(String[] args) {
        long before, after;

        before = System.nanoTime();
        // Skilgreining gagna
        int maxArraySize = 5000; // Mesta stærð á fylki sem við ætlum að tímamæla
        int stride = 10; // Bil á milli stærða
        int numTrials = 20; // Fjöldi mælinga fyrir hverja stærð fylkis
        long seed = 203; // Fastur grunnur fyrir slembitölugjafann

        // Mælingar
        timeInsertionSort(maxArraySize, 1, seed); // Keyrum einu sinni í upphafi áður en mælingar hefjast

        int n = 0;
        long time, maxTime = 0;
        long[] times = new long[maxArraySize / stride + 1];
        for (int i = 0; i <= maxArraySize / stride; i++) {
            time = timeInsertionSort(n, numTrials, seed);
            System.out.println(time);
            times[i] = time;
            n += stride;
            if (time > maxTime) {
                maxTime = time;
            }

        }

        // Teikning á niðurstöðum
        StdDraw.setXscale(0, maxArraySize);
        StdDraw.setYscale(0, maxTime * 1.05);
        StdDraw.setPenRadius(.01);
        n = 0;
        for (long timei : times) {
            StdDraw.point(n, timei);
            n += stride;
        }
        after = System.nanoTime();

        StdOut.println("Keyrslan tók " + (after - before) / 1000000000 + " sekúndur");
    }

}