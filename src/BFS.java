import it.uniupo.graphLib.GraphInterface;

import java.util.ArrayList;
import java.util.Arrays;

public class BFS {
    GraphInterface g;
    public BFS(GraphInterface g){
        this.g = g;
    }

    public ArrayList<Integer> getNodesInOrderOfVisit(int sorgente){
        ArrayList<Integer> visitati = new ArrayList<>();
        ArrayList<Integer> coda= new ArrayList<>();
        boolean[] scoperti = new boolean[g.getOrder()];
        coda.add(sorgente);
        scoperti[sorgente]=true;
        visitati.add(sorgente);
        while(!coda.isEmpty()){
            for (Integer vicino: this.g.getNeighbors(coda.get(0))
                 ) {
                if(!scoperti[vicino]){
                    scoperti[vicino]=true;
                    visitati.add(vicino);
                    coda.add(vicino);
                }
            }
            coda.remove(0);
        }

        return visitati;
    }

    public int[] getDistance(int sorgente){
        ArrayList<Integer> coda= new ArrayList<>();
        boolean[] scoperti= new boolean[g.getOrder()];
        int[] distanza= new int[g.getOrder()];
        Arrays.fill(distanza,-1);
        distanza[sorgente]=0;
        scoperti[sorgente]=true;
        coda.add(sorgente);
        while(!coda.isEmpty()){
            for (int vicino: g.getNeighbors(coda.get(0))
                 ) {
                if(!scoperti[vicino]){
                    scoperti[vicino]=true;
                    coda.add(vicino);
                    distanza[vicino]=distanza[coda.get(0)]+1;
                }
            }
            coda.remove(0);
        }

        return distanza;

    }
}
