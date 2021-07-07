package undirectedWeightedGraph;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class UndirectedWeightedGraphTest
{

    //Test cases for isConnected()
    @Test
    public void testIsConnetedWithAllCitiesConnected()
    {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph(6);
        undirectedWeightedGraph.addEgde(0, 1, 4);
        undirectedWeightedGraph.addEgde(0, 2, 3);
        undirectedWeightedGraph.addEgde(1, 3, 2);
        undirectedWeightedGraph.addEgde(1, 2, 5);
        undirectedWeightedGraph.addEgde(2, 3, 7);
        undirectedWeightedGraph.addEgde(3, 4, 2);
        undirectedWeightedGraph.addEgde(4, 0, 4);
        undirectedWeightedGraph.addEgde(4, 1, 4);
        undirectedWeightedGraph.addEgde(4, 5, 6);
        
        boolean actualOutput = undirectedWeightedGraph.isConnected();
        
        assertTrue(actualOutput);
    }
    
    @Test
    public void testIsConnetedWithAllCitiesNotConnected()
    {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph(8);
        undirectedWeightedGraph.addEgde(0, 1, 4);
        undirectedWeightedGraph.addEgde(0, 2, 3);
        undirectedWeightedGraph.addEgde(1, 3, 2);
        undirectedWeightedGraph.addEgde(1, 2, 5);
        undirectedWeightedGraph.addEgde(2, 3, 7);
        undirectedWeightedGraph.addEgde(3, 4, 2);
        undirectedWeightedGraph.addEgde(4, 0, 4);
        undirectedWeightedGraph.addEgde(4, 1, 4);
        undirectedWeightedGraph.addEgde(4, 5, 6);
        undirectedWeightedGraph.addEgde(6, 7, 7);
        
        boolean actualOutput = undirectedWeightedGraph.isConnected();
        
        assertFalse(actualOutput);
    }
    
    //Test cases for reachable()
    @Test
    public void testReachableWithAllCitiesRechable()
    {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph(8);
        undirectedWeightedGraph.addEgde(0, 1, 4);
        undirectedWeightedGraph.addEgde(0, 2, 3);
        undirectedWeightedGraph.addEgde(1, 3, 2);
        undirectedWeightedGraph.addEgde(1, 2, 5);
        undirectedWeightedGraph.addEgde(2, 3, 7);
        undirectedWeightedGraph.addEgde(3, 4, 2);
        undirectedWeightedGraph.addEgde(4, 0, 4);
        undirectedWeightedGraph.addEgde(4, 1, 4);
        undirectedWeightedGraph.addEgde(4, 5, 6);
        undirectedWeightedGraph.addEgde(6, 7, 7);
        
        Integer[] expectedOutput = {0, 1, 2, 3, 4, 5};
        List<Integer> actualOutput = undirectedWeightedGraph.reachable(0);
        for(int i=0; i<expectedOutput.length; i++)
        {
            assertEquals(expectedOutput[i], actualOutput.get(i));
        }
    }
    
    @Test
    public void testReachableWithAllCitiesNotRechable()
    {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph(8);
        undirectedWeightedGraph.addEgde(0, 1, 4);
        undirectedWeightedGraph.addEgde(0, 2, 3);
        undirectedWeightedGraph.addEgde(1, 3, 2);
        undirectedWeightedGraph.addEgde(1, 2, 5);
        undirectedWeightedGraph.addEgde(2, 3, 7);
        undirectedWeightedGraph.addEgde(4, 5, 6);
        undirectedWeightedGraph.addEgde(6, 7, 7);
        
        Integer[] expectedOutput = {0, 1, 2, 3};
        List<Integer> actualOutput = undirectedWeightedGraph.reachable(0);
        for(int i=0; i<expectedOutput.length; i++)
        {
            assertEquals(expectedOutput[i], actualOutput.get(i));
        }
    }
    
    @Test
    public void testGetMinimumSpanningTree()
    {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph(6);
        undirectedWeightedGraph.addEgde(0, 1, 4);
        undirectedWeightedGraph.addEgde(0, 2, 3);
        undirectedWeightedGraph.addEgde(1, 3, 2);
        undirectedWeightedGraph.addEgde(1, 2, 5);
        undirectedWeightedGraph.addEgde(2, 3, 7);
        undirectedWeightedGraph.addEgde(3, 4, 2);
        undirectedWeightedGraph.addEgde(4, 0, 8);
        undirectedWeightedGraph.addEgde(4, 1, 4);
        undirectedWeightedGraph.addEgde(4, 5, 6);
        
        String[] expectedOutput = {"0 1 4",
                                   "0 2 3",
                                   "1 3 2",
                                   "3 4 2",    
                                   "4 5 6"};   
        int i = 0;
        for(Edge edge: undirectedWeightedGraph.getMinimumSpanningTree())
        {
            String actualOutput = edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }

    @Test
    public void testGetShortestPath()
    {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph(6);
        undirectedWeightedGraph.addEgde(0, 1, 4);
        undirectedWeightedGraph.addEgde(0, 2, 3);
        undirectedWeightedGraph.addEgde(1, 3, 2);
        undirectedWeightedGraph.addEgde(1, 2, 5);
        undirectedWeightedGraph.addEgde(2, 3, 7);
        undirectedWeightedGraph.addEgde(3, 4, 2);
        undirectedWeightedGraph.addEgde(4, 0, 8);
        undirectedWeightedGraph.addEgde(4, 1, 4);
        undirectedWeightedGraph.addEgde(4, 5, 6);
        
        String[] expectedOutput = {"1 2 0",
                                   "2 3 7",
                                   "3 4 9",    
                                   "4 5 15"};   
        int i = 0;
        for(Edge edge: undirectedWeightedGraph.getShortestPath(2, 5))
        {
            String actualOutput = edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test(expected = AssertionError.class)
    public void testGetShortestPathWithNoPathAvailable()
    {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph(6);
        undirectedWeightedGraph.addEgde(0, 1, 4);
        undirectedWeightedGraph.addEgde(0, 2, 3);
        undirectedWeightedGraph.addEgde(1, 3, 2);
        undirectedWeightedGraph.addEgde(1, 2, 5);
        undirectedWeightedGraph.addEgde(2, 3, 7);
        undirectedWeightedGraph.addEgde(3, 4, 2);
        undirectedWeightedGraph.addEgde(4, 0, 8);
        undirectedWeightedGraph.addEgde(4, 1, 4);
        
        List<Edge> shortestPath = undirectedWeightedGraph.getShortestPath(2, 5);
    }
}
