package Serie8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static final File FILE = new File(
            "/home/greemluck/Documents/UNIFR/" +
                    "Algorithmic/Series/src/Serie7/leipzig1M-p.txt");

    public static void main(String[] args) throws IOException {

        class Pair implements Comparable<Pair> {

            String key;
            Integer val;

            Pair(String key, Integer val){
                this.key = key;
                this.val = val;
            }

            public String getKey() {
                return key;
            }

            public Integer getValue() {
                return val;
            }

            @Override
            public int compareTo(Pair o) {
                return this.getValue().compareTo(o.getValue());
            }
        }

        long startTime = System.currentTimeMillis();

        //First loop to count the words and list them
        Scanner scan = new Scanner(FILE).useDelimiter(" ");
        Serie8.BinarySearchTree<String, Integer> table = new Serie8.BinarySearchTree<>();

        while(scan.hasNext()){
            String word = scan.next();

            // We only need the word of length between 8 and 10.
            if (word.length() < 8 || word.length() > 10){
                continue;
            }

            if (table.contains(word)){
                int count = table.get(word)+1;
                table.put(word, count);
            } else {
                table.put(word, 1);
            }
        }

        //Second loop to get the top 10 most counted words
        PriorityQueue<Pair> counts =  new PriorityQueue<>(10);
        Iterator<String> iterator = table.keys().iterator();

        while (iterator.hasNext()) {
            String w = iterator.next();
            int c = table.get(w);
            Pair p = new Pair(w, c);

            if (counts.size() < 10) {
                counts.add(p);
            } else if (p.compareTo(counts.peek()) > 0){
                counts.poll();
                counts.add(p);
            }
        }

        //Writing the results
        FileWriter countWriter = new FileWriter(new File(
                "/home/greemluck/Documents/UNIFR/" +
                "Algorithmic/Series/src/Serie8/top10word.txt"));

        Iterator itr = counts.iterator();
        while(itr.hasNext()) {
            Pair p = (Pair)itr.next();
            System.out.print(p.getKey() + ": " + p.getValue() + "\n");
            countWriter.append(p.getKey() + ": " + p.getValue() + "\n");
        }

        long endTime = System.currentTimeMillis();
        System.out.print("Time : " + (endTime - startTime) + "ms\n");
        countWriter.append("Time : " + (endTime - startTime) + "ms\n");

        countWriter.flush();
        countWriter.close();
    }


}
