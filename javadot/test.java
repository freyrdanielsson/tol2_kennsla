package javadot;
// Muna að sýna þeim java pakkakerfi | ekki nauðsýnlegt en nice

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MoreRandom {

    public static Double[] getRandomDoubleArray(int arraySize, long seed) {
        /*
        Skilar fylki með arraySize jafndreifðum Double tölum á bilinu [0, 1[,
        slembitölugjafi upphafsstilltur með seed.
         */

        // Hér þarf að skrifa kóða!
        return new Double[] {1.0, 2.0, 3.0}; // þessu þarf að breyta..

        // cool leið til að gera þetta er að hafa annað fall sem heitir það sama en
        // tekur bara inn arraySize og sér um útreikninga og láta þetta fall bara
        // setja seed. Annars getur þetta fall líka gert allt 
        // upphafsstilla slembigjafa með seed, sem segir að fyrir sömu gefnu tölu mun
        // slembigjafi alltaf varpa í sömu random tölu m.v. seed
        // StdRandom.uniform(); er nice
    }

    public static void main(String[] args) {
        int arraySize = 3;
        long seed = 203;
        for (Double d : getRandomDoubleArray(arraySize, seed)) {
            StdOut.print(d + " ");
        }
        StdOut.println("");
    }
}