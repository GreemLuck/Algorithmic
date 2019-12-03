package Serie11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class EulerianPath
{
    public static Iterable<Integer> findEulerianPath (IGraph g) {
        // since we delete edges in the process the graph has to be copied:
        g = copyGraph(g);
        
        int start = findStartVert(g);
        LinkedList<Integer> path = new LinkedList<>();
        path.add(start);
        fleuryAlgorithm(start, path, g);

        return path;
    }

    public static void fleuryAlgorithm(int start, LinkedList<Integer> path, IGraph g) {
        Collection<Integer> adj = (Collection)g.adj(start);
        for(Integer i: adj) {
            int v = i;
            if(adj.size() == 1 || !isBridge(g, v, start)) {
                path.add(v);
                g.deleteEdge(start, v);
                fleuryAlgorithm(v, path, g);
                return;
            }
        }
    }

    public static int findStartVert(IGraph g) {
        for(int v = 0; v < g.numberOfNodes(); v++) {
            int deg = g.degree(v);
            if(deg%2 == 1) {
                return v;
            }
        }
        return 0;
    }

    public static IGraph copyGraph (IGraph g) {
        IGraph g2 = new Graph(g.numberOfNodes());
        for (int i = 0; i < g.numberOfNodes(); i++)
        {
            for (Integer edge : g.adj(i))
            {
                if (i < edge) {
                    g2.addEdge(i, edge);
                }
            }
        }
        return g2;
    }

    public static boolean isBridge(IGraph graph, int v, int w) {
        if (!graph.isEdge(v, w)) {
            return false;
        }
        // there is an edge, so check if it is a bridge
        boolean[] marked = new boolean[graph.numberOfNodes()];
        marked[v] = true;
        marked[w] = true;
        boolean isReached = false;
        for (int x : graph.adj(v)) {
            if (x != w) {
                isReached = isReachable(graph, x, w, marked);
            }
            if (isReached) {
                break;
            }
        }
        return !isReached;
    }

    private static boolean isReachable(IGraph graph, int x, int w, boolean[] marked) {
        marked[x] = true;
        for (int y : graph.adj(x)) {
            if(y == w) {
                return true;
            }
            if (!marked[y]) {
                if (isReachable(graph, y, w, marked)) return true;
            }
        }
        return false;
    }

    public static boolean isEulerianPath (Graph g, Iterable<Integer> path) {
        ArrayList<Integer> array = new ArrayList<>();
        for (Integer i: path)
        {
            array.add(i);
        }

        // check that all edges of the graph are in the path:
        for (int i = 0; i < g.numberOfNodes(); i++)
        {
            for (Integer j : g.adj(i))
            {
                if (i < j) {
                    // path should contain [.. -> i -> j -> ..] or [.. -> j -> i -> ..]
                    boolean foundThePair = false;
                    for (int k = 0; !foundThePair && k < array.size() - 1; k++)
                    {
                        if ((array.get(k).equals(i) && array.get(k + 1).equals(j))
                            || (array.get(k).equals(j) && array.get(k+1).equals(i)))
                        {
                            foundThePair = true;
                        }
                    }
                    if (!foundThePair) return false;
                }
            }
        }
        // check that the path is valid
        for (int i = 0; i < array.size() - 1; i++)
        {
            if (!g.isEdge(array.get(i), array.get(i+1))) return false;
        }

        return true;
    }
}
