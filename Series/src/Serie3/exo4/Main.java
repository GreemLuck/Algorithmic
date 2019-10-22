package Serie3.exo4;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Let's calculate the first 40 number of the Fibonnaci sequence.
        long timer;

        FileWriter csvWriter = new FileWriter("fibonnaci.csv");
        csvWriter.append("#,Slow,Fast\n");

        for(int i = 0; i < 50; i++){

            csvWriter.append(Integer.toString(i));
            csvWriter.append(",");

            // O(2^n) Fibonnaci
            timer = System.currentTimeMillis();
            fibonnaciSlow(i);
            timer = System.currentTimeMillis() - timer;
            System.out.println(timer);

            csvWriter.append(Long.toString(timer));
            csvWriter.append(",");

            // O(n) Fibonnaci
            timer = System.currentTimeMillis();
            fibonnaciFast(i);
            timer = System.currentTimeMillis() - timer;

            csvWriter.append(Long.toString(timer));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }

    public static int fibonnaciSlow(int n){
        if(n<=1){
            return n;
        } else {
            return fibonnaciSlow(n-1) + fibonnaciSlow(n-2);
        }
    }

    public static int fibonnaciFast(int n){
        int fn, f1, f2;
        fn = 0;
        f1 = 1;
        f2 = 0;
        while(n > 1){
            fn = f1 + f2;
            f2 = f1;
            f1 = fn;
            n--;
        }
        return fn;
    }
}
