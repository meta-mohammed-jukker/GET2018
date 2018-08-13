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
        UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(6);
        uwg.addEgde(0, 1, 4);
        uwg.addEgde(0, 2, 3);
        uwg.addEgde(1, 3, 2);
        uwg.addEgde(1, 2, 5);
        uwg.addEgde(2, 3, 7);
        uwg.addEgde(3, 4, 2);
        uwg.addEgde(4, 0, 4);
        uwg.addEgde(4, 1, 4);
        uwg.addEgde(4, 5, 6);
        
        boolean actualOutput = uwg.isConnected();
        
        assertTrue(actualOutput);
    }
    
    @Test
    public void testIsConnetedWithAllCitiesNotConnected()
    {
        UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(8);
        uwg.addEgde(0, 1, 4);
        uwg.addEgde(0, 2, 3);
        uwg.addEgde(1, 3, 2);
        uwg.addEgde(1, 2, 5);
        uwg.addEgde(2, 3, 7);
        uwg.addEgde(3, 4, 2);
        uwg.addEgde(4, 0, 4);
        uwg.addEgde(4, 1, 4);
        uwg.addEgde(4, 5, 6);
        uwg.addEgde(6, 7, 7);
        
        boolean actualOutput = uwg.isConnected();
        
        assertFalse(actualOutput);
    }
    
    //Test cases for reachable()
    @Test
    public void testReachableWithAllCitiesRechable()
    {
        UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(8);
        uwg.addEgde(0, 1, 4);
        uwg.addEgde(0, 2, 3);
        uwg.addEgde(1, 3, 2);
        uwg.addEgde(1, 2, 5);
        uwg.addEgde(2, 3, 7);
        uwg.addEgde(3, 4, 2);
        uwg.addEgde(4, 0, 4);
        uwg.addEgde(4, 1, 4);
        uwg.addEgde(4, 5, 6);
        uwg.addEgde(6, 7, 7);
        
        Integer[] expectedOutput = {0, 1, 2, 3, 4, 5};
        List<Integer> actualOutput = uwg.reachable(0);
        for(int i=0; i<expectedOutput.length; i++)
        {
            assertEquals(expectedOutput[i], actualOutput.get(i));
        }
    }
    
    @Test
    public void testReachableWithAllCitiesNotRechable()
    {
        UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(8);
        uwg.addEgde(0, 1, 4);
        uwg.addEgde(0, 2, 3);
        uwg.addEgde(1, 3, 2);
        uwg.addEgde(1, 2, 5);
        uwg.addEgde(2, 3, 7);
        uwg.addEgde(4, 5, 6);
        uwg.addEgde(6, 7, 7);
        
        Integer[] expectedOutput = {0, 1, 2, 3};
        List<Integer> actualOutput = uwg.reachable(0);
        for(int i=0; i<expectedOutput.length; i++)
        {
            assertEquals(expectedOutput[i], actualOutput.get(i));
        }
    }
    
    @Test
    public void testGetMinimumSpanningTree()
    {
        UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(6);
        uwg.addEgde(0, 1, 4);
        uwg.addEgde(0, 2, 3);
        uwg.addEgde(1, 3, 2);
        uwg.addEgde(1, 2, 5);
        uwg.addEgde(2, 3, 7);
        uwg.addEgde(3, 4, 2);
        uwg.addEgde(4, 0, 8);
        uwg.addEgde(4, 1, 4);
        uwg.addEgde(4, 5, 6);
        
        String[] expectedOutput = {"0 1 4",
                                   "0 2 3",
                                   "1 3 2",
                                   "3 4 2",    
                                   "4 5 6"};   
        int i = 0;
        for(Edge edge: uwg.getMinimumSpanningTree())
        {
            String actualOutput = edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }

    @Test
    public void testGetShortestPath()
    {
        UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(6);
        uwg.addEgde(0, 1, 4);
        uwg.addEgde(0, 2, 3);
        uwg.addEgde(1, 3, 2);
        uwg.addEgde(1, 2, 5);
        uwg.addEgde(2, 3, 7);
        uwg.addEgde(3, 4, 2);
        uwg.addEgde(4, 0, 8);
        uwg.addEgde(4, 1, 4);
        uwg.addEgde(4, 5, 6);
        
        String[] expectedOutput = {"1 2 0",
                                   "2 3 7",
                                   "3 4 9",    
                                   "4 5 15"};   
        int i = 0;
        for(Edge edge: uwg.getShortestPath(2, 5))
        {
            String actualOutput = edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test(expected = AssertionError.class)
    public void testGetShortestPathWithNoPathAvailable()
    {
        UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(6);
        uwg.addEgde(0, 1, 4);
        uwg.addEgde(0, 2, 3);
        uwg.addEgde(1, 3, 2);
        uwg.addEgde(1, 2, 5);
        uwg.addEgde(2, 3, 7);
        uwg.addEgde(3, 4, 2);
        uwg.addEgde(4, 0, 8);
        uwg.addEgde(4, 1, 4);
        
        List<Edge> shortestPath = uwg.getShortestPath(2, 5);
    }
}
