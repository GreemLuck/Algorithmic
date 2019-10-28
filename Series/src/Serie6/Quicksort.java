package Serie6;

public class Quicksort<T extends Comparable<T>> implements ISortingAlgorithm<T> {
    @Override
    public void Sort(T[] array) {
        int N = array.length;

        Shuffle.shuffle(array);
        sort(array, 0, N-1);
    }

    public static <T extends Comparable<? super T>> void sort(T[] array, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int j  = partition(array, lo, hi);
        sort(array, lo, j- 1);
        sort(array, j + 1, hi);
    }

    public static <T extends Comparable<? super T>> int partition(T[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true){
            while(isLess(array[i++], array[lo])){
                if(i==hi){
                    break;
                }
            }
            while(isLess(array[lo], array[--j])){
                if (j == lo) {
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exch(array, i, j);
        }

        exch(array, lo, j);
        return j;
    }

    @Override
    public String Name() {
        return "QuickSort";
    }

    public static <T extends Comparable<? super T>> boolean isLess(T a, T b){
        if(a.compareTo(b) < 0){
            return true;
        }
        return false;
    }

    public static <T extends Comparable<? super T>> void exch(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
