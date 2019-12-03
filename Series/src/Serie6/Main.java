package Serie6;

public class Main {

    public static void main(String[] args) {
        
       Measurement.Run(
               "test.csv",
               new ISortingAlgorithm[] {
                       new CheatSort<Integer>(),
                       new Quicksort<Integer>(),
                       new QuicksortMedian3<Integer>(),
                       new Heapsort<Integer>(),
                       new MergeSort(),
                       new MergeInsert()
               },
               100000,
               1.5,
               15,
               1
       );

    }
}
