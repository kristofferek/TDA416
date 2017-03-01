
import java.util.*;

public class DirectedGraph<E extends Edge> {

	private int nbrOfNodes;
	private List<E>[] edges;

	public DirectedGraph(int noOfNodes) {
		edges = new List[noOfNodes];
		for (int i = 0; i < noOfNodes; i++) {
			edges[i] = new LinkedList<E>();
		}
	}

    public void addEdge(E e) {
		edges[e.getSource()].add(e);
    }
	public Iterator<E> shortestPath(int from, int to) {
        List<Integer> visited = new ArrayList<>(); //Keeps track of the visited nodes.
	    PriorityQueue<CompDijkstraPath<E>> queue = new PriorityQueue<>(); //Shortest path so far is always on top.
        queue.add(new CompDijkstraPath<>(from, 0, new LinkedList<>())); // Start node

        while(!queue.isEmpty()){
            CompDijkstraPath<E> ssf = queue.poll();
            if (!visited.contains(ssf.getToNode())){
                if (ssf.getToNode() == to) return ssf.getRoute().iterator();

                visited.add(ssf.getToNode()); // Mark as visited
                for (E e : edges[ssf.getToNode()]){ // Add all neighbors to the queue.
                    if (!visited.contains(e.getDest())){
                        LinkedList<E> path = new LinkedList<>();
                        path.addAll(ssf.getRoute());
                        path.add(e);
                        queue.add(new CompDijkstraPath<E>(e.getDest(), ssf.getCost() + e.getWeight(), path));
                    }
                }
            }
        }
        return null;
	}
		
	public Iterator<E> minimumSpanningTree()
    {

        LinkedList<E>[] cc = new LinkedList[nbrOfNodes];
        PriorityQueue<CompKruskalEdge> kruskalPQ = new PriorityQueue<CompKruskalEdge>();

        for (int i = 0; i < nbrOfNodes; i++)
            cc[i] = new LinkedList<E>();

        for (int i = 0; i < edges.length; i++)
        {
            for (E temp : edges[i])
            kruskalPQ.add(new CompKruskalEdge(temp));
        }

        while (!kruskalPQ.isEmpty() && cc.length > 1)
        {
            CompKruskalEdge nextEdge = kruskalPQ.poll();

            LinkedList<E> longList,shortList;
            if (cc[nextEdge.getSource()] !=(cc[nextEdge.getDest()]))
            {
                    if (cc[nextEdge.getSource()].size() > cc[nextEdge.getDest()].size() )
                    {
                        longList = cc[nextEdge.getSource()];
                        shortList = cc[nextEdge.getDest()];
                    }
                    else {
                        shortList = cc[nextEdge.getSource()];
                        longList = cc[nextEdge.getDest()];
                    }

                    for (E temp : shortList){
                        longList.add(temp);
                    }

                    longList.add((E) nextEdge.getEdge());
                    for (E temp : longList){
                        cc[temp.getSource()] = longList;
                        cc[temp.getDest()] = longList;
                    }
                    if (longList.size() == nbrOfNodes-1)
                        return longList .iterator();
                }
            }

        return null;
	}
}
  
