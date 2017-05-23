package edu.miracosta.cs113;

public class driver {

	public static void main(String[] args)
	{
		
		ListGraph graph = new ListGraph(5, true);
		
		int[] pred = new int[graph.getNumV()];
		double[] dist = new double[graph.getNumV()];
		
		graph.insert(new Edge(0, 1, 0.1));
		graph.insert(new Edge(0, 4, 0.9));
		graph.insert(new Edge(0, 3, 0.3));
		graph.insert(new Edge(1, 2, 0.5));
		graph.insert(new Edge(2, 4, 0.1));
		graph.insert(new Edge(3, 4, 0.6));
		graph.insert(new Edge(3, 2, 0.2));
		graph.insert(new Edge(4, 2, 0.4));
		
		
		
		DijkstrasAlgorithm.dijkstrasAlgorithm(graph, 3, pred, dist);
		
		for(int i = 0; i < pred.length ; i++)
		{
			System.out.println(pred[i] + "  " + dist[i]);
		}
			
		
		
	}

}
