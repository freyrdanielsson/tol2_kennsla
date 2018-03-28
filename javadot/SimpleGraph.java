package javadot;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;

public class SimpleGraph extends Graph {

    public SimpleGraph(int V) {
        /*
        Upphafsstillir net með engum leggjum og <V> hnútum
         */
        super(V); // Kallar á sama smið í Graph.java svo við þurfum ekki að skrifa kóðann þar aftur
    }

    @Override
    public void addEdge(int v, int w) {
        /*
        Bætir legg á milli hnúta númer <v> og <w> við netið.
         */
        if (v == w) {
            throw new IllegalArgumentException("Lykkjur eru ekki leyfðar í einföldu neti");
        }
        for (Integer z : this.adj(v)) {
            if (z == w) {
                throw new IllegalArgumentException("Endurteknir leggir eru ekki leyfðir í einföldu neti");
            }
        }
        for (Integer z : this.adj(w)) {
            if (z == v) {
                throw new IllegalArgumentException("Endurteknir leggir eru ekki leyfðir í einföldu neti");
            }
        }
        super.addEdge(v, w); // Kallar á addEdge aðferðina í Graph.java
    }

    public static void main(String[] args) {
        int[] gNumbers = new In("javadot/tinyG.txt").readAllInts(); // Lesum inn netið í tinyG.txt
        SimpleGraph g = new SimpleGraph(gNumbers[0]); // Fyrsta talan í skránni er hnútafjöldinn
        for (int i = 2; i < gNumbers.length; i += 2) { // Tölur 2 og uppúr í skránni tákna leggi
            g.addEdge(gNumbers[i], gNumbers[i + 1]);
        }
        try{
            g.addEdge(1, 1);
            StdOut.println("Þetta á ekki að birtast, línan að ofan átti að valda villu.");
        } catch (IllegalArgumentException e) {
            StdOut.println("Villan sem hlaust af því að bæta við lykkju var giftusamlega gripin!");
        }
        try{
            g.addEdge(4, 3);
            StdOut.println("Þetta á ekki að birtast, línan að ofan átti að valda villu.");
        } catch (IllegalArgumentException e) {
            StdOut.println("Villan sem hlaust af því að bæta við endurteknum legg var giftusamlega gripin!");
        }
        try{
            g.addEdge(5, 0);
            StdOut.println("Þetta á ekki að birtast, línan að ofan átti að valda villu.");
        } catch (IllegalArgumentException e) {
            StdOut.println("Villan sem hlaust af því að bæta við endurteknum legg var giftusamlega gripin!");
        }
    }
}