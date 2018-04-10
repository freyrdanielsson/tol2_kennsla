package javadot;

import edu.princeton.cs.algs4.*;

public class Schulze {

    public static int[][] floydWarshall(int[][] d, int n) {
        /*
        Útgáfa af Floyd-Warshall reikniritinu til nota í Schulze kosningakerfinu.

        Tekur inn tvívítt fylki d, þar sem d[i][j] er fjöldi kjósenda sem kýs
        frambjóðanda i fram yfir frambjóðanda j, ásamt fjölda frambjóðenda n.

        Skilar tvívíðu fylki p, þar sem p[i][j] er styrkur sterkasta vegs frá i til j.
         */
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) { // Upphafsstilling fylkisins p
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (d[i][j] > d[j][i]) {
                        p[i][j] = d[i][j];
                    } else {
                        p[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    for (int k = 0; k < n; k++) {
                        if (i != k && j != k) {
                            p[j][k] = Math.max(p[j][k], Math.min(p[j][i], p[i][k])); // "veikasti hlekkurinn" uppfærður
                        }
                    }
                }
            }
        }
        return p;
    }


    public static void main(String[] args) {
        String[] votes = new In("javadot/votes.txt").readAllLines();
        int numCandidates = Integer.parseInt(votes[0]);
        int[][] preferences = new int[numCandidates][numCandidates];
        for (int i = 1; i < votes.length; i++) {
            char[] candidates = votes[i].toCharArray();
            for (int j = 0; j < candidates.length; j++) {
                int preferredCandidate = candidates[j] - 'A';
                for (int k = j + 1; k < candidates.length; k++) {
                    int lessPreferredCandidate = candidates[k] - 'A';
                    preferences[preferredCandidate][lessPreferredCandidate]++;
                }
            }
        }
        int[][] strongestPaths = floydWarshall(preferences, numCandidates);
        int[] rankings = new int[numCandidates];
        for (int candidate = 0; candidate < numCandidates; candidate++) {
            for (int opponent = 0; opponent < numCandidates; opponent++) {
                if (strongestPaths[candidate][opponent] > strongestPaths[opponent][candidate]) {
                    rankings[candidate]++;
                }
            }
        }
        char[] winners = new char[numCandidates];
        char rank = 'A';
        for (int ranking : rankings) {
            winners[ranking] = rank++;
        }
        for (int i = 0; i < winners.length - 1; i++) {
            StdOut.print(winners[i] + " < ");
        }
        StdOut.println(winners[winners.length - 1]);
    }
}