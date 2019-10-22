package Serie3.exo5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static final File FILE = new File("/home/greemluck/Documents/UNIFR/Algorithmic/Series/src/Serie3/exo5/numbers.txt");

    public static void main(String[] args) throws IOException{
        long timer;

        FileWriter csvWriter = new FileWriter("threesum.csv");
        csvWriter.append("#,ThreeSum,ThreeSumFast\n");

        for(int i = 100; i < 3000; i+=50){
            double[] numbers = listingDoubles(FILE, i);
            Arrays.sort(numbers);

            csvWriter.append(Integer.toString(i));
            csvWriter.append(",");

            // ThreeSum
            timer = System.currentTimeMillis();
            ThreeSum.run(numbers);
            timer = System.currentTimeMillis() - timer;

            csvWriter.append(Long.toString(timer));
            csvWriter.append(",");

            // ThreeSumFast
            timer = System.currentTimeMillis();
            ThreeSumFast.run(numbers);
            timer = System.currentTimeMillis() - timer;

            csvWriter.append(Long.toString(timer));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }

    public static double[] listingDoubles(File file, int n) throws IOException{
        Scanner scan = new Scanner(file).useDelimiter("\\s*\\n");
        double[] a = new double[n];

        for(int i=0; i<n; i++){
            a[i] = scan.nextDouble();
        }

        scan.close();

        return a;
    }
}
