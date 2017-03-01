
/**
 * Created by Kotex on 2017-02-27.
 */

public class CompKruskalEdge<E extends Edge> implements Comparable<CompKruskalEdge<E>>{
    private E edge;

    public CompKruskalEdge(E e)
    {
        super();
        edge = e;
    }

    public int getSource()
    {
        return edge.getSource();
    }

    public int getDest()
    {
        return edge.getDest();
    }

    public double getWeight()
    {
        return edge.getWeight();
    }

    public E getEdge(){
        return edge;
    }

    @Override
    public int compareTo(CompKruskalEdge<E> o) {
        double result = edge.getWeight() - o.getWeight();
        return (int) result;
    }
}
