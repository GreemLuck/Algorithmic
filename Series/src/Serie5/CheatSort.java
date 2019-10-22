package Serie5;

import java.util.Arrays;

public class CheatSort<T extends Comparable<T>> implements ISortingAlgorithm<T>
{

    @Override
    public void Sort(T[] array)
    {
        Arrays.sort(array);
    }

    @Override
    public String Name()
    {
        return "CheatSort";
    }
}
