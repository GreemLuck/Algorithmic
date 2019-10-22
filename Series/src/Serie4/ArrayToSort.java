package Serie4;

import java.util.Arrays;
import java.util.Random;

public class ArrayToSort<T extends Comparable<T>> {

    public final int length;

    public ArrayToSort (T[] array) {
        this.array = array;
        length = array.length;
        cheatSolution = Arrays.copyOf(array, array.length);
        Arrays.sort(cheatSolution);
    }

    public static Integer[] createRandomIntegerArray(int size, int maxValue, int seed) {
        Random rand = new Random(seed);
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(maxValue);
        }
        return array;
    }

    public boolean isLess(int firstIndex, int secondIndex) {
        cmpCounter++;
        return array[firstIndex].compareTo(array[secondIndex]) < 0;
    }

    public void exch (int firstIndex, int secondIndex) {
        swapCounter++;
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    protected T[] array;
    protected int cmpCounter = 0, swapCounter = 0;
    protected T[] cheatSolution;

    protected boolean isSorted () {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(cheatSolution[i]) != 0) return false;
        }
        return true;
    }
}


