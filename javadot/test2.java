
import java.util.*;

SET<String> actors = new Set<>();

actors.add(String)


 In in = new In("javadot/movies.txt");
 String[] moviesActors = in.readAllLines();
 System.out.println("lengd fylkis " + moviesActors.length);

//fá Bag af leikurum úr hverri línu og setja í <SET>
//ath SET samþykir bara .add() ef hluturinn er ekki í menginu núþegar
//svo sama nafni verður ekki bætt við tvisvar
for(int i=0; i<moviesActors.length; i++){
    Bag<String> actorBag = getActorsFromLine(moviesActors[i]);
    for(String s : actorBag){
        actors.add(s);
    }
}

SymbolGraph sg = new SymbolGraph("javadot/movies.txt", "/");

Graph graph = sq.graph();

int i = sg.indexOf("Bacon, Kevin");
