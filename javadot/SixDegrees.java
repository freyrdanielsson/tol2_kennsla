package javadot;

import edu.princeton.cs.algs4.*;
import java.util.*;

public class SixDegrees {

// Input:   String, with everything before the first slash representing a movie name,
// and the rest of the slash-separated line representing actor names
// Returns: A String bag of the actors' names
    private static Bag<String> getActorsFromLine(String line) {
        Bag<String> actorBag = new Bag<>();
        String[] splitLine = line.split("/");
        for (int i = 1; i < splitLine.length; i++) {
            actorBag.add(splitLine[i]);
        }
        return actorBag;
    }

    public static void main(String[] args) {
        In in = new In("javadot/movies.txt");
        String[] moviesActors = in.readAllLines(); //setja linu i fylki
        SET<String> actors = new SET<>();

        //fá Bag af leikurum úr hverri línu og setja í <SET>
        //ath SET samþykir bara .add() ef hluturinn er ekki í menginu núþegar
        //svo sama nafni verður ekki bætt við tvisvar
        for(int i=0; i<moviesActors.length; i++){
            Bag<String> actorBag = getActorsFromLine(moviesActors[i]);
            for(String s : actorBag){
                actors.add(s);
            }
        }
        //2. Upphafsstilla net sem inniheldur gögnin.
        //Þetta má gera á svipaðan hátt og í DegreesOfSeparation.java.
        SymbolGraph sg = new SymbolGraph("javadot/movies.txt", "/");
        Graph G = sg.graph();
        

        //Velja "Bacon, Kevin" sem ós og gera BreadthFirstPaths úr því
        int s = sg.indexOf("Bacon, Kevin");
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        int degree; //fjöldi leggja á milli
        int[] actorDegree = new int[7];//heldur utan um fjölda með sama degree

        Iterator<String> itr = actors.iterator();//ítrari yfir SET
        while (itr.hasNext()) {
            degree = 0;
            String name = itr.next();//name- nafn sem á að finna bacon tölu á
						System.out.println(name);
            int t = sg.indexOf(name);
            if(bfs.hasPathTo(t)){
                for(int v : bfs.pathTo(t)){
                    degree++;
                }
                //hækka fjölda þeirra sem hafa ákveðna bacon tölu
                //degree/2 til að telja ekki myndir mynd er hútur með börn sem eru leikarar svo þetta tvítelst allt
                actorDegree[degree/2]++;
            }
            else{
                actorDegree[6]++;//þeir sem eru ekki tengdri Bacon 
            }
        }
        // 4. Skrifa þarf út hversu oft hver Bacon-tala kom fyrir.
        for(int i=0; i<actorDegree.length-1; i++){
            StdOut.println(i + ": " + actorDegree[i]);
        }
        StdOut.println(actorDegree[6] + " actors have no defined Bacon number");
    }
}