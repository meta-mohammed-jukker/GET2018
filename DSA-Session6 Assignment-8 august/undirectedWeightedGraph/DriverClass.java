package undirectedWeightedGraph;

public class DriverClass
{

    public static void main(String[] args)
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
        undirectedWeightedGraph.printGraph();
        System.out.println(undirectedWeightedGraph.isConnected());
        for(int i: undirectedWeightedGraph.reachable(0))
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for(Edge edge: undirectedWeightedGraph.getMinimumSpanningTree())
        {
            System.out.println(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
        }
        System.out.println("\n");
        for(Edge edge: undirectedWeightedGraph.getShortestPath(2, 5))
        {
            System.out.println(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
        }
    }

}
