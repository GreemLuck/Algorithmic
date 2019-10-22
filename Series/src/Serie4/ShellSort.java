package Serie4;

public class ShellSort<T> implements ISortingAlgorithm {
    @Override
    public String name() {
        return "ShellSort";
    }

    @Override
    public void sort(ArrayToSort array) {
        int N = array.length;
        int h = 1;

        while (h < N / 3){
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (array.isLess(j, j-h)) {
                        array.exch(j, j - h);
                    } else {
                        break;
                    }
                }
            }

            h /= 3;
        }
    }
}
