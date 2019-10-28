package Serie6;

public class QuicksortMedian3<T extends Comparable<T>> implements ISortingAlgorithm<T> {
    @Override
    public void Sort(T[] array) {
        int N = array.length;

        sort(array, 0, N-1);
    }

    private static <T extends Comparable<? super T>> void sort(T[] array,int lo,int hi){
        if(hi <= lo){
            return;
        }
        median3(array, lo, hi);
        int j = Quicksort.partition(array, lo, hi);
        sort(array, lo, j- 1);
        sort(array, j + 1, hi);
    }

    @Override
    public String Name() {
        return "QuickSortMedian3";
    }

    private static <T extends Comparable <? super T>> void median3(T[] array, int lo, int hi){
        if((lo-hi) < 3){
            return;
        }

        T a = array[lo];
        T b = array[lo+1];
        T c = array[lo+2];

        if(a.compareTo(b) < 0 && a.compareTo(c) > 0
            || a.compareTo(b) > 0 && a.compareTo(c) < 0){
            return;
        } else if(b.compareTo(a) < 0 && b.compareTo(c) > 0
            || b.compareTo(a) > 0 && b.compareTo(c) < 0){
            Quicksort.exch(array, lo, lo+1);
            return;
        } else {
            Quicksort.exch(array, lo, lo+2);
            return;
        }
    }
}
