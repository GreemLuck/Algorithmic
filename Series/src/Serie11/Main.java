package Serie11;

import java.io.IOException;

public class Main {

    static final String KOENIGSBERG = "/home/greemluck/Documents/UNIFR/Algorithmic/Series/src/Serie11/koenigsbergG.txt";
    static final String KALINGRAD = "/home/greemluck/Documents/UNIFR/Algorithmic/Series/src/Serie11/kaliningradG.txt";

    public static void main(String[] args) throws IOException {

        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(0,2);
        g1.addEdge(1,2);
        g1.addEdge( 2,3);
        printEulerianPath(g1);

        Graph g2 = new Graph(KALINGRAD);
        printEulerianPath(g2);

        Graph g3 = new Graph(KOENIGSBERG);
        printEulerianPath(g3);
    }

    private static void printEulerianPath(Graph g) {
        Iterable<Integer> path = EulerianPath.findEulerianPath(g);
        if (EulerianPath.isEulerianPath(g, path)) {
            System.out.print("The path is : ");
            for(int i: path) {
                System.out.print(i);
            }
            System.out.print("\n");
        } else {
            System.out.print("The graph is not Eulerian.\n");
        }
    }
}
