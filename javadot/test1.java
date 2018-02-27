package javadot;

import edu.princeton.cs.algs4.*;

public class PlotRunningTimes {

    public static long timeInsertionSort(int arraySize, int numTrials, long seed) {
        // Hér er ráðlagt (en ekki nauðsynlegt) að skrifa aðferð skv. lýsingu:
        /*
        Skilar meðalkeyrslutíma innsetningarröðunar á slembifylki af stærð <arraySize> 
        eftir <numTrials> keyrslur, með slembitölugjafann stilltan á <seed>.

        // Hér væri frekar nice að nota slembifylkið úr dæmi 1
        // Hér væri ekki nice að skrifa það allt aftur
        // Hér væri nice að nota það bara beint því það er hægt (pakkakerfi)
        // double[] a;
        // a = MoreRandom(arraySize, seed); komið!
        // Allir eru að nota pakkakerfi en ekki allir vita það

        /* Lykkja */ 
        // fáum slembifylki
        // byrjum tíma
        // röðum fylki
        // endum tíma
        // leggjum allan timan saman
        /* */
        // skilum samanlögðum tíma deilt með numTrials 
        return 0;
    }

    public static void main(String[] args) {
        /* Skilgreining gagna */

        int maxArraySize = 5000; // Mesta stærð á fylki sem við ætlum að tímamæla
        int stride = 10; // Bil á milli stærða
        int numTrials = 20; // Fjöldi mælinga fyrir hverja stærð fylkis
        long seed = 203; // Fastur grunnur fyrir slembitölugjafann

        /* Mælingar */

        // Hér þarf að skrifa kóða!
        // fint að hafa í huga.
        // hvað munum við prófa mörg fylki?
        // væri ekki sniðugt að geyma tima fyrir hvert fylki að raðast 20x í öðru fylki? (jú)
        // væri kanski sniðugt að halda utam um lengsta tíman því við þurfum
        // að plotta þetta á eftir? (já)

        /* Teikning á niðurstöðum */

        // Hvernig er best að hafa ásana? er ekki best að hafa stærð fylkis
        // sem fall af tíma? (jú)
        // hint hafið penRadius frekar lítið .setPenRadius(0,x);

        // Hér þarf að skrifa kóða!
    }

}
