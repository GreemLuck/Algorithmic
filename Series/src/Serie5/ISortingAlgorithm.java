package Serie5;

public interface ISortingAlgorithm<T extends Comparable<T>>
{
    void Sort (T[] array);
    String Name ();
}
