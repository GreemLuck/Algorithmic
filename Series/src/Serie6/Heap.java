package Serie6;

public class Heap<T extends Comparable<T>> {

    int size;
    T[] array;

    public Heap(int N){
        array = (T[])new Comparable[N+1];
        size = 0;
    }

    public T remove() {
        if(isEmpty()){
            return null;
        } else {
            T root = array[1];
            exch(array, 1, size);
            array[size--] = null;
            sink(array, 1, size);
            return root;
        }
    }

    public T min() {
        if(isEmpty()) return null;
        return array[1];
    }

    public void insert(T elem) {
        array[size++] = elem;

        int swim = size;
        while(swim > 1 && less(array, swim, swim/2)){
            exch(array, swim, swim/2);
            swim = swim/2;
        }
    }

    public boolean isEmpty() {
        if(size <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void assertHeapOrientation () {
        // TODO, for ex 4
        //assert ...
    }

    private static <T extends Comparable<? super T>> void sink(T[] array, int k, int N){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && (less(array, j+1, j))){
                j++;
            }
            if(!less(array, k, j)){
                break;
            }

            exch(array, k, j);
            k = j;
        }
    }

    private static <T extends Comparable<? super T>> boolean less(T[] array, int i, int j){
        return array[i-1].compareTo(array[j-1]) < 0;
    }

    private static <T extends Comparable<? super T>> void exch(T[] array, int i, int j){
        T temp = array[i-1];
        array[i-1] = array[j-1];
        array[j-1] = temp;
    }
}
