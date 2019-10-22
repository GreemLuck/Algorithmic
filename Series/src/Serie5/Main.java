package Serie5;

public class Main {

    public static void main(String[] args) {
        
       Measurement.Run(
               "test.csv",
               new ISortingAlgorithm[] {new MergeSort() },
               100000,
               1.5,
               18,
               1
       );

    }
}
