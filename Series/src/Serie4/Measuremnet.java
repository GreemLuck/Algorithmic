package Serie4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Measuremnet
{

    public static void Run (
            String filename,
            ISortingAlgorithm<Integer>[] algorithms,
            int startingCount,
            int countIncrement,
            int nbSteps,
            int folds)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("N,Time,Algorithm\n");
        System.out.println("N,Time,Algorithm");

        for (int i = 0; i < nbSteps; i++)
        {
            int N = startingCount + countIncrement * i;
            for (ISortingAlgorithm<Integer> algo : algorithms)
            {

                long time = 0;
                for (int j = 0; j < folds; j++)
                {
                    ArrayToSort<Integer> toSort = new ArrayToSort<>(
                            ArrayToSort.createRandomIntegerArray(N, Integer.MAX_VALUE, (int) System.nanoTime())
                    );
                    long startTime = System.currentTimeMillis();
                    algo.sort(toSort);
                    long endTime = System.currentTimeMillis();
                    time += (endTime - startTime);
                    assert toSort.isSorted();
                }
                stringBuilder.append(N + "," + (time / folds) + "," + algo.name() + "\n");
                System.out.println(N + "," + (time / folds) + "," + algo.name());
            }

        }
        try (PrintStream out = new PrintStream(new FileOutputStream(filename)))
        {
            out.print(stringBuilder.toString());
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
