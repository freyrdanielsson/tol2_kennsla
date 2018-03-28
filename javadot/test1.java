import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.SymbolGraph;
import edu.princeton.cs.algs4.StdOut;

public class GraphProperties {

    private Graph g;
    // Búa til breytur fyrir radius, diameret, center og eccentricity...eða ekki þið ráðið

    GraphProperties(Graph g) {
        /*
        Upphafsstillir klasa sem reiknar út nokkra eiginleika netsins <g>.
        Netið <g> skal vera samanhangandi. Þessi aðferð veldur villu sé svo ekki.
        */

        // Skoðiði Graph klasann. Hvað gerir t.d. g.V() ??
        // Skoðið BreadthFirstPaths klasann, það eru 102 leiðir til að gera þetta en ég notaði það.
        // Skoðið smiðinn á honum.. gæti verið hentugur til að ath hvort net sé samhangandi 🤔
        // BreadhFirstPaths hefur líka hasPathTo fall 😮
        // Hér er líka fínt að upphafsstilla eccentricity [] (já það er gott að hafa fylki af eccemtricity fyrir hvern hnút held ég)
        // bara setja lengd á það, það er upphafsstillt með null-um

        // Hér þarf að skrifa kóða!
        this.g = g;
    }

    public int eccentricity(int v) {
        /*
        Skilar lengd stystu leiðar frá hnútnum <v> í <this.g> til þess hnúts sem lengst er frá honum.
        */

        // Ath þetta fall er notað í honum föllunum 😬
        // hér væri t.d. sniðugt að skila eccentricity úr eccentricity fylkinu m.v. int v se mer tekið inn
        // þetta var alveg smá flókið getum skoðað þetta betur allir sáttir

        // Hér þarf að skrifa kóða!
        return 0;
    }

    public int diameter() {
        /*
        Skilar hæsta eccentricity meðal allra hnúta í <this.g>.
        */
        // Hér þarf að skrifa kóða!
        return 0;
    }

    public int radius() {
        /*
        Skilar lægsta eccentricity meðal allra hnúta í <this.g>.
        */
        // Hér þarf að skrifa kóða!
        return 0;
    }

    public int center() {
        /*
        Skilar númeri hnúts í <this.g> sem hefur eccentricity = this.radius().
        */
        return 0;
    }

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("routes.txt", " ");
        GraphProperties gp = new GraphProperties(sg.graph());

        StdOut.println("Eiginleikar leiðanetsins:");
        StdOut.println("");
        StdOut.println("Þvermál:   " + gp.diameter());
        StdOut.println("Radíus:    " + gp.radius());
        StdOut.println("Miðhnútur: " + sg.nameOf(gp.center()));
        StdOut.println("");
        StdOut.println(" Völlur frávik ");
        StdOut.println("===============");
        for (int v = 0; v < sg.graph().V(); v++) {
            StdOut.println(String.format("  %-5s   %-4d", sg.nameOf(v), gp.eccentricity(v)));
        }
    }

}