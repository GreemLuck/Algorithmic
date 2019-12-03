package Serie6;

public class Heapsort<T extends Comparable<T>> implements ISortingAlgorithm<T>
{
    @Override
    public void Sort(T[] array)
    {
        int N = array.length;
        Heap<T> heap = new Heap<T>(N);
        for (int i = 0; i < array.length; i++)
        {
            heap.insert(array[i]);
        }
        for (int i = 0; i < array.length; i++)
        {
            array[i] = heap.remove();
        }
    }

    @Override
    public String Name()
    {
        return "Heapsort";
    }
}
