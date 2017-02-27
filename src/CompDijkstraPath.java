import java.util.LinkedList;

public class CompDijkstraPath<E extends Edge> implements Comparable<CompDijkstraPath> {

    private int toNode;
    private double cost;
    private LinkedList<E> route;

    public CompDijkstraPath(int to, double cost, LinkedList<E> route){
        this.route = route;
        this.toNode = to;
        this.cost = cost;
    }

    public LinkedList<E> getRoute(){
        return route;
    }

    public int getToNode(){
        return toNode;
    }

    public double getCost(){
        return cost;
    }

    @Override
    public int compareTo(CompDijkstraPath path) {
        return (int)(this.cost - path.cost);
    }
}
