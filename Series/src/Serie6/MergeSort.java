package Serie6;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements ISortingAlgorithm<T> {


    @Override
    public void Sort(T[] array) {
        int N = array.length;

        Comparable[] aux = Arrays.copyOf(array, array.length);
        sort(array, aux, 0, N-1);
    }

    @Override
    public String Name() {
        return "MergeSort";
    }

    private static <T extends Comparable<T>> void sort(Comparable[] array, Comparable[] aux,
                                                       int lo, int hi){
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
         sort(array, aux, lo, mid);
         sort(array, aux, mid+1, hi);
         merge(array, aux, lo, mid, hi);
    }

    public static <T extends Comparable<T>> void merge(Comparable[] array, Comparable[] aux,
                                                        int lo, int mid, int hi){
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }
}
