package undirectedWeightedGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UndirectedWeightedGraph implements Graph
{
    int numberOfNodes;
    List<Edge> [] adjacencyList;
    private Edge edge;
    //private List<Edge> edges;

    /**
     * Initializes UndirectedWeightedGraph with total number of nodes
     * @param numberOfNodes
     */
    UndirectedWeightedGraph(int numberOfNodes) 
    {
        this.numberOfNodes = numberOfNodes;
        adjacencyList = new LinkedList[numberOfNodes];
        //initialize adjacency lists for all the Cities
        for (int i = 0; i <numberOfNodes ; i++) 
        {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    /**
     * Adds path between 2 nodes
     * @param source source 
     * @param destination destination 
     * @param weight length of path
     */
    public void addEgde(int source, int destination, int weight) 
    {
        Edge path = new Edge(source, destination, weight); 
        Edge reversePath = new Edge(destination, source, weight);
        adjacencyList[source].add(path);
        adjacencyList[destination].add(reversePath);
    }

    public void printGraph()
    {
        for (int i = 0; i <numberOfNodes ; i++) 
        {
            List<Edge> list = adjacencyList[i];
            for (int j = 0; j <list.size() ; j++) 
            {
                System.out.println(i + " --> " +
                        list.get(j).getDestination() + " with weight " +  list.get(j).getWeight());
            }
        }
    }
    
    /**
     * Utility method used by DFS() to recursively do depth first search
     * @param currentNode current node
     * @param visited boolean array indicating all nodes that have been visited
     */
    void DFSUtil(int currentNode,boolean visited[])
    {
        // Mark the current node as visited
        visited[currentNode] = true;
        for(Edge edge: adjacencyList[currentNode])
        {
            if(! visited[edge.getDestination()])
            {
                DFSUtil(edge.getDestination(), visited);
            }
        }
    }
 
    /**
     * Returns list of all nodes that have been visited by depth first search traversal
     * @param startNode node from which traversal is started 
     * @return boolean array indicating all nodes that can be reached
     */
    boolean[] DFS(int startNode)
    {
        boolean visited[] = new boolean[numberOfNodes];
        DFSUtil(startNode, visited);
        
        return visited;
    }

    /**
     * Checks if all the cities are connected with each other
     */
    @Override
    public boolean isConnected()
    {
        boolean[] visitedNodes = DFS(0);
        for(boolean node: visitedNodes)
        {
            if(! node)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a list of all nodes reachable from the specified node
     */
    @Override
    public List<Integer> reachable(int node)
    {
        List<Integer> reachableNodeList = new ArrayList<Integer>();
        boolean [] visitedNodes = DFS(node); 
        
        for(int i=0; i<numberOfNodes; i++)
        {
            if(visitedNodes[i])
            {
                reachableNodeList.add(i);
            }
        }
        
        return reachableNodeList;
    }
    
    /**
     * Returns vertex with minimum key value from set of vertices
     * not yet included in MST
     * @param key array of minimum weight edge
     * @param visited array of vertices not included in MST
     * @return index with minimum edge
     */
    public int getMinimumKeyIndex(int minimumWeight[], Boolean visited[]) 
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < numberOfNodes; v++)
            if (visited[v] == false && minimumWeight[v] < min) 
            {
                min = minimumWeight[v];
                min_index = v;
            }

        return min_index;
    }

    /**
     * Returns minimum spanning tree of given graph
     */
    @Override
    public List<Edge> getMinimumSpanningTree()
    {
        List<Edge> edges;
        int sourceNodes[] = new int[numberOfNodes];
        int minimumWeight[] = new int[numberOfNodes];
        Boolean visited[] = new Boolean[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) 
        {
            minimumWeight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        minimumWeight[0] = Integer.MIN_VALUE;
        sourceNodes[0] = -1;
        
        for (int count = 0; count < numberOfNodes - 1; count++) 
        {
            int u = getMinimumKeyIndex(minimumWeight, visited);
            visited[u] = true;

            edges = adjacencyList[u];
            for (Edge adjacentEdge : edges) 
            {
                int v = adjacentEdge.getDestination();
                if (adjacentEdge.getWeight() != Integer.MIN_VALUE && !visited[v]
                        && adjacentEdge.getWeight() < minimumWeight[v]) 
                {

                    sourceNodes[v] = u;
                    minimumWeight[v] = adjacentEdge.getWeight();

                }
            }
        }

        List<Edge> minSpanningtree = new ArrayList<>();

        for (int i = 1; i < numberOfNodes; i++) 
        {
            edges = adjacencyList[i];
            for (Edge edgeConnected : edges) 
            {

                if (edgeConnected.getDestination() == sourceNodes[i]) 
                {

                    edge = new Edge(sourceNodes[i], i,
                            edgeConnected.getWeight());

                    minSpanningtree.add(edge);
                }
            }
        }

        return minSpanningtree;
    }

    /**
     * Returns shortest distance between 2 cities
     */
    @Override
    public List<Edge> getShortestPath(int source, int destination) throws AssertionError
    {
        List<Edge> edges;
        int distance[] = new int[numberOfNodes];
        Boolean visited[] = new Boolean[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) 
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[source] = 0;
        for (int count = 0; count < numberOfNodes - 1; count++) 
        {
            int u = getMinimumKeyIndex(distance, visited);

            visited[u] = true;

            edges = adjacencyList[u];


                for (Edge adjacentEdge : edges) 
                {
                    int v = adjacentEdge.getDestination();

                        if (!visited[v] && adjacentEdge.getWeight() != 0
                                && distance[u] != Integer.MAX_VALUE
                                && distance[u] + adjacentEdge.getWeight() < distance[v]) 
                        {

                            distance[v] = distance[u] + adjacentEdge.getWeight();
                        }
                    
                }
        }
        List<Edge> shortestPath = new ArrayList<>();
        
        if(distance[destination] == Integer.MAX_VALUE)
        {
            throw new AssertionError("Path not connected");
        }

        for (int i = source; i < destination + 1; i++) 
        {
            edge = new Edge(i - 1, i, distance[i]);
            shortestPath.add(edge);
        }
        return shortestPath;
    }
}
