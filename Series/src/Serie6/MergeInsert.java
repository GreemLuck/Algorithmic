package Serie6;

import java.util.Arrays;

public class MergeInsert<T extends Comparable<T>> implements ISortingAlgorithm<T> {

    final static int CUTOFF_IS = 14;

    @Override
    public void Sort(Comparable[] array) {
        int N = array.length;

        Comparable[] aux = Arrays.copyOf(array, array.length);
        sort(array, aux, 0, N-1);
    }

    private static <T extends Comparable<T>> void sort(Comparable[] array, Comparable[] aux,
                                                       int lo, int hi){
        if (hi - lo + 1 <= CUTOFF_IS){
            insertionSort(array, lo, hi);
        } else {
            int mid = lo + (hi - lo) / 2;
            sort(array, aux, lo, mid);
            sort(array, aux, mid + 1, hi);
            MergeSort.merge(array, aux, lo, mid, hi);
        }
    }

    private static <T extends Comparable<T>> void insertionSort(T[] array, int lo, int hi){
        for (int i = lo+1; i < hi; i++) {
            for (int j = i; j > 0; j--){
                if(less(array, j, j-1)){
                    exch(array,j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public String Name() {
        return "MergeInsertSort";
    }

    private static <T extends Comparable<? super T>> boolean less(T[] array, int i, int j){
        return array[i].compareTo(array[j]) < 0;
    }

    private static <T extends Comparable<? super T>> void exch(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
