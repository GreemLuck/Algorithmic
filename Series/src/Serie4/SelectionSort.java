package Serie4;

public class SelectionSort<T> implements ISortingAlgorithm {

    @Override
    public String name() {
        return "SelectionSort";
    }

    @Override
    public void sort(ArrayToSort array) {
        int N = array.length;

        // Initialize Sentinel
        int sentinel = 0;
        int index = 1;
        while(index < N){
            if(array.isLess(index, sentinel)){
                sentinel = index;
            }
            index++;
        }
        array.exch(sentinel, 0);

        for(int i = 2; i<N; i++){
            int t = i;
            int j = i-1;
            while(array.isLess(t, j)){
                array.exch(j+1, j);
                j--;
            }
            array.exch(j+1, t);
        }

        assert array.isSorted();

    }
}
