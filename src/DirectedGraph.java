
import java.util.*;

public class DirectedGraph<E extends Edge> {

	private int nbrOfNodes;
	private List<E>[] edges;

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
  
