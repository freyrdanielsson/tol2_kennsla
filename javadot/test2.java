

import edu.princeton.cs.algs4.*;

public class SortingCompetition {

		// Hér ættu alveg örugglega að koma ein eða fleiri aðferðir til hjálpar.
		// t.d nákvæmlega sama fall og í dæmi 2 nema með merge sort? (yes)

    public static void main(String[] args) {

        int maxN = 1000; // Við gefumst upp eftir 1000 stök
        int numTrials = 50000; // Fjöldi mælinga fyrir hverja stærð fylkis, hér mjög stórt
        long seed = 203; // Fastur grunnur fyrir slembitölugjafann
        int n = 10; // Byrjum að skoða fylki af þessari stærð

        long insertionTime = 0;
        long mergeTime = Long.MAX_VALUE;
        while (insertionTime < mergeTime && n < maxN) {
            // Hér þarf að skrifa kóða!
            n++;
        }
        StdOut.println(n);
    }

}