package Serie11;

public interface IConnectedComponents {

    boolean connected(int v, int w); // are v and w connected

    int count(); // number of connected components

    int getConnectedCompID(int v); // get conn. comp. id for i
}
