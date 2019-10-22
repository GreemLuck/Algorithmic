package Serie3.exo5;

public class ThreeSum {
    public static void run(double[] a){
        int counter = 0;
        for (int i = 0; i < a.length; i++){
            for (int j = i+1; j < a.length; j++){
                for (int k = j+1; k < a.length; k++){
                   if (a[i] + a[j] + a[k] == 0){
                       counter++;
                   }
                }
            }
        }
        System.out.println(counter);
    }

}
