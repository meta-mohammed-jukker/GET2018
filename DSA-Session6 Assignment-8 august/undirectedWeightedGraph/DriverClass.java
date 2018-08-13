package undirectedWeightedGraph;

public class DriverClass
{

    public static void main(String[] args)
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
        uwg.printGraph();
        System.out.println(uwg.isConnected());
        for(int i: uwg.reachable(0))
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for(Edge edge: uwg.getMinimumSpanningTree())
        {
            System.out.println(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
        }
        System.out.println("\n");
        for(Edge edge: uwg.getShortestPath(2, 5))
        {
            System.out.println(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
        }
    }

}
