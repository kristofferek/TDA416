
import java.util.*;

public class DirectedGraph<E extends Edge> {

	private List<E>[] edges;

	public DirectedGraph(int noOfNodes) {
		edges = new List[noOfNodes];
		for (int i = 0; i < noOfNodes; i++) {
			edges[i] = new LinkedList<E>();
		}
	}

	public void addEdge(E edge) {
		edges[edge.getSource()].add(edge);
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
		
	public Iterator<E> minimumSpanningTree() {
		return null;
	}

}
  
