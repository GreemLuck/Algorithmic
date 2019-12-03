package Serie11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph implements IGraph {

    private final int n;
    private int m;
    private LinkedList<Integer>[] adjLists;

    public Graph(int numberOfNodes) {
        this.n = numberOfNodes;
        adjLists = new LinkedList[n];
        for(int v = 0; v < n; v++) {
            adjLists[v] = new LinkedList<Integer>();
        }
    }

    public Graph(String inputPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        this.n = Integer.parseInt(reader.readLine());
        adjLists = new LinkedList[n];
        for(int v = 0; v < n; v++) {
            adjLists[v] = new LinkedList<Integer>();
        }

        String line = null;
        while((line = reader.readLine()) != null) {
            String[] split = line.split(" ");
            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            addEdge(v, w);
        }
        reader.close();
    }

    @Override
    public int numberOfNodes() {
        return n;
    }

    @Override
    public int numberOfEdges() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        if(isEdge(v, w)) return;
        adjLists[v].add(w);
        adjLists[w].add(v);
        m++;

    }

    @Override
    public boolean isEdge(int v, int w) {
        for(int edge: adjLists[v]) {
            if(edge == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteEdge(int v, int w) {
        adjLists[v].remove((Object)w);
        adjLists[w].remove((Object)v);
        m--;
    }

    @Override
    public int degree(int v) {
        return adjLists[v].size();
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adjLists[v];
    }

    @Override
    public Iterator<Integer> depthFirstSearch(int v) {
        return null;
    }

    @Override
    public Iterator<Integer> breathFirstSearch(int v) {
        return null;
    }
}
