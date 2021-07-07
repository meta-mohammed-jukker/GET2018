package undirectedWeightedGraph;

import java.util.List;

public interface Graph
{
    public boolean isConnected();
    public List<Integer> reachable(int city);
    public List<Edge> getMinimumSpanningTree();
    public List<Edge> getShortestPath(int source, int destination);
}
