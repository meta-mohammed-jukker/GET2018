package undirectedWeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UndirectedWeightedGraph implements Graph
{
    int totalNumberOfCities;
    List<Edge> [] roadList;
    private Edge edge;
    //private List<Edge> edges;

    /**
     * Initializes UndirectedWeightedGraph with total number of cities
     * @param totalNumberOfCities
     */
    UndirectedWeightedGraph(int totalNumberOfCities) 
    {
        this.totalNumberOfCities = totalNumberOfCities;
        roadList = new LinkedList[totalNumberOfCities];
        //initialize adjacency lists for all the Cities
        for (int i = 0; i <totalNumberOfCities ; i++) 
        {
            roadList[i] = new LinkedList<>();
        }
    }

    /**
     * Adds path between 2 cities
     * @param source source city
     * @param destination destination city
     * @param weight length of path
     */
    public void addEgde(int source, int destination, int weight) 
    {
        Edge path = new Edge(source, destination, weight); 
        Edge reversePath = new Edge(destination, source, weight);
        roadList[source].add(path);
        roadList[destination].add(reversePath);
    }

    public void printGraph()
    {
        for (int i = 0; i <totalNumberOfCities ; i++) 
        {
            List<Edge> list = roadList[i];
            for (int j = 0; j <list.size() ; j++) 
            {
                System.out.println(i + " --> " +
                        list.get(j).getDestination() + " with weight " +  list.get(j).getWeight());
            }
        }
    }
    
    /**
     * Utility method used by DFS() to recursively do depth first search
     * @param currentCity current city
     * @param visited boolean array indicating all cities that have been visited
     */
    void DFSUtil(int currentCity,boolean visited[])
    {
        // Mark the current node as visited
        visited[currentCity] = true;
        for(Edge road: roadList[currentCity])
        {
            if(! visited[road.getDestination()])
            {
                DFSUtil(road.getDestination(), visited);
            }
        }
    }
 
    /**
     * Returns list of all cities that have been visited by depth first search traversal
     * @param startCity city from which traversal is started 
     * @return boolean array indicating all cities that can be reached
     */
    boolean[] DFS(int startCity)
    {
        // Mark all the totalNumberOfCities as not visited
        boolean visited[] = new boolean[totalNumberOfCities];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(startCity, visited);
        
        return visited;
        
        
    }

    /**
     * Checks if all the cities are connected with each other
     */
    @Override
    public boolean isConnected()
    {
        boolean[] visitedCities = DFS(0);
        for(boolean node: visitedCities)
        {
            if(! node)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a list of all cities reachable from the specified city
     */
    @Override
    public List<Integer> reachable(int city)
    {
        List<Integer> reachableCityList = new ArrayList<Integer>();
        boolean [] visitedCities = DFS(city); 
        
        for(int i=0; i<totalNumberOfCities; i++)
        {
            if(visitedCities[i])
            {
                reachableCityList.add(i);
            }
        }
        
        return reachableCityList;
    }
    
    /**
     * Returns vertex with minimum key value from set of vertices
     * not yet included in MST
     * @param key array of minimum weight edge
     * @param boolSet array of vertices not included in MST
     * @return index with minimum edge
     */
    public int getMinimumKeyIndex(int minimumWeight[], Boolean boolSet[]) 
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < totalNumberOfCities; v++)
            if (boolSet[v] == false && minimumWeight[v] < min) 
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
        List<Edge> minSpanningtree;
        List<Edge> edges;

        // Array to store constructed MST
        int parent[] = new int[totalNumberOfCities];

        // Key values used to pick minimum weight edge
        int minimumWeight[] = new int[totalNumberOfCities];

        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[totalNumberOfCities];

        // Initialize all keys as INFINITE
        for (int i = 0; i < totalNumberOfCities; i++) 
        {
            minimumWeight[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        minimumWeight[0] = 0;         // Make key 0 so that this vertex is picked as first vertex
        parent[0] = -1;     // First node is always root of MST
        
        for (int count = 0; count < totalNumberOfCities - 1; count++) 
        {
            // Pick the minimum key vertex from the set of vertices
            // not yet included in MST
            int u = getMinimumKeyIndex(minimumWeight, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            edges = roadList[u];

            // Updates key value and parent index of the adjacent vertices 
            // which are not yet included in MST
            for (Edge adjacentEdge : edges) 
            {
                int v = adjacentEdge.getDestination();
                
                // Update the key, if weight(u,v) is smaller than key[v]
                if (adjacentEdge.getWeight() != 0 && !mstSet[v]
                        && adjacentEdge.getWeight() < minimumWeight[v]) 
                {

                    parent[v] = u;
                    minimumWeight[v] = adjacentEdge.getWeight();

                }
            }
        }

        minSpanningtree = new ArrayList<>();

        for (int i = 1; i < totalNumberOfCities; i++) 
        {
            edges = roadList[i];
            for (Edge edgeConnected : edges) 
            {

                if (edgeConnected.getDestination() == parent[i]) 
                {

                    edge = new Edge(parent[i], i,
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
        List<Edge> shortestPath;
        List<Edge> edges;

        // The output array distance[i] will hold the shortest distance from source to i
        int distance[] = new int[totalNumberOfCities];

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from source to i is finalized
        Boolean sptSet[] = new Boolean[totalNumberOfCities];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < totalNumberOfCities; i++) 
        {
            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        distance[source] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < totalNumberOfCities - 1; count++) 
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to source in first
            // iteration.
            int u = getMinimumKeyIndex(distance, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            edges = roadList[u];
            
            // Update distance value of the adjacent vertices of the
            // picked vertex.

                // Update distance[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from source to
                // v through u is smaller than current value of distance[v]

                for (Edge adjacentEdge : edges) 
                {
                    // getting weight connected with vertex v
                    int v = adjacentEdge.getDestination();

                        if (!sptSet[v] && adjacentEdge.getWeight() != 0
                                && distance[u] != Integer.MAX_VALUE
                                && distance[u] + adjacentEdge.getWeight() < distance[v]) 
                        {

                            distance[v] = distance[u] + adjacentEdge.getWeight();
                        }
                    
                }
        }

        // store the resulting list in a arrayList along with their
        // distance
        shortestPath = new ArrayList<>();
        
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
