package Serie4;

public class InsertionSort<T> implements ISortingAlgorithm {
    @Override
    public String name() {
        return "InsertionSort";
    }

    @Override
    public void sort(ArrayToSort array) {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--){
                if(array.isLess(j, j-1)){
                    array.exch(j, j-1);
                } else {
                    break;
                }
            }
        }
        assert array.isSorted();
    }
}
