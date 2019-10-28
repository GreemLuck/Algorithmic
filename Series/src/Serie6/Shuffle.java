package Serie6;

import java.util.Random;

public class Shuffle {
    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    private Shuffle() {}

    public static void shuffle(Object[] a){
        int n = a.length;
        for (int i = 0; i< n; i++){
            int r = i + uniform(n - i);
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int uniform(int n) {
        return random.nextInt(n);
    }

}
