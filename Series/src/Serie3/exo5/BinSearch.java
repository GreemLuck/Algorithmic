package Serie3.exo5;

public class BinSearch {
    public static int search(double[] sortedList, double n){
        int l = 0;
        int h = sortedList.length - 1;

        while(l <= h){
            int mid = l + (h-l)/ 2;

            if(sortedList[mid] < n){
                l = mid + 1;
            } else if(sortedList[mid] > n){
                h = mid - 1;
            } else if (sortedList[mid] == n){
                return mid;
            }
        }
        return -1;
    }
}
