package javadot;

import edu.princeton.cs.algs4.*;

/**
 * Created by ernir on 4.4.2018.
 */
public class DijkstraTest {
    public static void main(String[] args) {
        DijkstraSP dijkstraSP = new DijkstraSP(new EdgeWeightedDigraph(new In("javadot/mediumEWG.txt")), 0);
        StdOut.println(dijkstraSP.distTo(168));
        StdOut.println(dijkstraSP.distTo(200));
        StdOut.println(dijkstraSP.distTo(201));
    }
}