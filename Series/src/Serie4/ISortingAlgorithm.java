package Serie4;

public interface ISortingAlgorithm<T extends Comparable<T>> {
    String name();
    void sort(ArrayToSort<T> array);
}
