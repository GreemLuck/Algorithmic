package Serie6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class Measurement
{

    public static Integer[] CreateRandomIntegerArray (int size, int seed) {
        Integer[] array = new Integer[size];
        Random random = new Random(seed);
        for (int i = 0; i < size; i++)
        {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static <T extends Comparable<T>> boolean isSorted (T[] array) {
        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i].compareTo(array[i+1]) > 0) return false;
        }
        return true;
    }

    public static void Run (
            String filename,
            ISortingAlgorithm<Integer>[] algorithms,
            int startingCount,
            double relativeIncreasePerStep,
            int nbSteps,
            int folds)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("N, Time, Algorithm\n");
        System.out.println("N, Time, Algorithm");

        for (int i = 0; i < nbSteps; i++)
        {
            int N = (int)(startingCount * Math.pow(relativeIncreasePerStep, i));
            for (ISortingAlgorithm<Integer> algo : algorithms)
            {

                long time = 0;
                for (int j = 0; j < folds; j++)
                {
                    Integer[] arrayToSort = CreateRandomIntegerArray(N, (int) System.nanoTime());
                    long startTime = System.currentTimeMillis();
                    algo.Sort(arrayToSort);
                    long endTime = System.currentTimeMillis();
                    time += (endTime - startTime);
                    assert isSorted(arrayToSort);
                }
                stringBuilder.append(N + ", " + ((double)time / folds) + ", " + algo.Name() + "\n");
                System.out.println(N + ", " + ((double)time / folds) + ", " + algo.Name());
            }

        }
        try (PrintStream out = new PrintStream(new FileOutputStream(filename)))
        {
            out.print(stringBuilder.toString());
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}