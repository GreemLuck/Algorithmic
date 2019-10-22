package Serie4;

import org.junit.Test;

public class Main {

    public static void main(String[] args)
    {
        @SuppressWarnings("unchecked")
        ISortingAlgorithm<Integer>[] algos = new ISortingAlgorithm[] {
                new SelectionSort<Integer>(),
                new InsertionSort<Integer>(),
                new ShellSort<Integer>()
        };
        Measuremnet.Run("sort.csv", algos, 10000, 1000, 10, 4);

    }

    @Test
    public void test () throws InterruptedException {
        ArrayToSortWithVisuals array = new ArrayToSortWithVisuals (
                ArrayToSort.createRandomIntegerArray(25, 100, (int)System.currentTimeMillis()),
                500
        );
        ISortingAlgorithm<Integer> selectionSort = new InsertionSort<Integer>();
        selectionSort.sort(array);

        Thread.sleep(5000); // Don't close window immediately.
    }

}











































































