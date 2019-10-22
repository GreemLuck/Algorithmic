package Serie3.exo5;

public class ThreeSumFast {
    public static void run(double[] a){
        int counter = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                int k = BinSearch.search(a, -(a[i] + a[j]));
                if (k > j) counter++;
            }
        }
        System.out.println(counter);
    }
}
