package javadot;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;

public class GraphProperties {

    private Graph g;
    private Integer[] eccentricities;
    private Integer diameter;
    private Integer radius;
    private Integer center;

    GraphProperties(Graph g) {
        for (int i = 0; i < g.V(); i++) {
            BreadthFirstPaths bfs = new BreadthFirstPaths(g, i);
            for (int j = 0; j < i; j++) {
                assert bfs.hasPathTo(j);
            }
        }
        this.g = g;
        this.eccentricities = new Integer[g.V()];
    }

    public int eccentricity(int v) {
        if (this.eccentricities[v] == null) {
            BreadthFirstPaths bfs = new BreadthFirstPaths(g, v);
            int eccentricity = Integer.MIN_VALUE;
            for (int i = 0; i < g.V(); i++) {
                int distTo = bfs.distTo(i);
                if (eccentricity < distTo) {
                    eccentricity = distTo;
                }
            }
            this.eccentricities[v] = eccentricity;
        }
        return this.eccentricities[v];
    }

    public int diameter() {
        if (this.diameter == null) {
            int diameter = Integer.MIN_VALUE;
            for (int i = 0; i < g.V(); i++) {
                if (diameter < eccentricity(i)) {
                    this.diameter = eccentricity(i);
                }
            }
        }
        return this.diameter;
    }

    public int radius() {
        if (this.radius == null) {
            this.radius = Integer.MAX_VALUE;
            for (int i = 0; i < g.V(); i++) {
                if (eccentricity(i) < this.radius) {
                    this.radius = eccentricity(i);
                    this.center = i;
                }
            }
        }
        return this.radius;
    }

    public int center() {
        if (this.center == null) {
            this.radius(); // Upphafsstillir miðjuna
        }
        return this.center;
    }

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("javadot/routes.txt", " ");
        GraphProperties gp = new GraphProperties(sg.graph());

        StdOut.println("Eiginleikar leiðanetsins:");
        StdOut.println("");
        StdOut.println("Þvermál:   " + gp.diameter());
        StdOut.println("Radíus:    " + gp.radius());
        StdOut.println("Miðhnútur: " + sg.nameOf(gp.center()));
        StdOut.println("");
        StdOut.println(" Völlur frávik ");
        StdOut.println("===============");
        for (int i = 0; i < sg.graph().V(); i++) {
            StdOut.println(String.format("  %-5s   %-4d", sg.nameOf(i), gp.eccentricity(i)));
        }
    }

}