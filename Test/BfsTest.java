import it.uniupo.graphLib.DirectedGraph;
import it.uniupo.graphLib.GraphInterface;
import it.uniupo.graphLib.UndirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;


public class BfsTest {
    @Test
    public void testCreate() {
        GraphInterface grafo = new DirectedGraph(3);
        BFS bfsTest = new BFS(grafo);
        assertNotNull(bfsTest);
    }

    @Test(timeout = 100)
    public void testScoperti() {
        GraphInterface grafo = new DirectedGraph("3;0 1;1 2;2 0");
        BFS bfsTest = new BFS(grafo);
        assertNotNull(bfsTest.getNodesInOrderOfVisit(0));
    }

    @Test
    public void testNumeroNodiVisitati() {
        GraphInterface grafo = new DirectedGraph("3;0 1;1 2;2 0");
        BFS bfsTest = new BFS(grafo);
        assertEquals(3, bfsTest.getNodesInOrderOfVisit(0).size());
    }

    @Test
    public void testBFSOrder() {
        GraphInterface grafo = new UndirectedGraph("4;0 2;0 1;2 3;1 3");
        BFS bfsTest = new BFS(grafo);
        assertTrue(bfsTest.getNodesInOrderOfVisit(2).get(2) == 0 || bfsTest.getNodesInOrderOfVisit(2).get(2) == 3);
        assertNotEquals(0, (int) bfsTest.getNodesInOrderOfVisit(2).get(2));
    }


    @Test
    public void testInitNumeroNodiVisitati() {
        GraphInterface grafo = new UndirectedGraph("4;0 2;0 1;2 3;1 3");
        BFS bfsTest = new BFS(grafo);
        int numeroNodi = bfsTest.getNodesInOrderOfVisit(0).size();
        assertEquals(4, numeroNodi);
        numeroNodi = bfsTest.getNodesInOrderOfVisit(2).size();
        assertEquals(4, numeroNodi);
    }

    @Test

    public void testDistanzaUnNodo(){
        GraphInterface g=new UndirectedGraph("1;0 0");
        BFS bfsTest = new BFS(g);
        int[] distanza=bfsTest.getDistance(0);
        assertEquals(0,distanza[0]);
    }

    @Test
    public void testDistanzaDueNodi(){
        GraphInterface g=new UndirectedGraph("2;0 1");
        BFS bfsTest = new BFS(g);
        int[] distanza=bfsTest.getDistance(0);
        assertEquals(0,distanza[0]);
        assertEquals(1,distanza[1]);
    }


    @Test

    public void testDistanzaQuattroNodi(){
        GraphInterface g=new UndirectedGraph("4;0 1;0 2;1 3;2 3");
        BFS bfsTest = new BFS(g);
        int[] distanza=bfsTest.getDistance(0);
        assertEquals(0,distanza[0]);
        assertEquals(1,distanza[1]);
        assertEquals(1,distanza[2]);
        assertEquals(2,distanza[3]);
    }

    @Test
    public void testInitDistanza(){
        GraphInterface g=new UndirectedGraph("4;0 1;0 2;1 3;2 3");
        BFS bfsTest = new BFS(g);
        int[] distanza=bfsTest.getDistance(2);
        assertEquals(2,distanza[1]);
        distanza=bfsTest.getDistance(3);
        assertEquals(2,distanza[0]);

    }





}
