package Serie11;

import java.util.Iterator;

public interface IGraph {

    int numberOfNodes();

    int numberOfEdges();

    void addEdge(int v, int w);

    boolean isEdge(int v, int w);

    void deleteEdge(int v, int w);

    int degree (int v);

    Iterable<Integer> adj(int v);

    Iterator<Integer> depthFirstSearch (int v);

    Iterator<Integer> breathFirstSearch(int v);
}
