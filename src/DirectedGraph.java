
import java.util.*;

public class DirectedGraph<E extends Edge> {

	private int nbrOfNodes;
	private List<Edge>[] edges;

	public DirectedGraph(int noOfNodes) {
		nbrOfNodes = noOfNodes;
		edges = new List[nbrOfNodes];
		for (int i = 0; i < nbrOfNodes; i++) {
			edges[i] = new LinkedList<>();
		}
	}

	public void addEdge(E e) {
		edges[e.getSource()].add(e);
	}

	public Iterator<E> shortestPath(int from, int to) {
		return null;
	}
		
	public Iterator<E> minimumSpanningTree() {
		return null;
	}

}
  
