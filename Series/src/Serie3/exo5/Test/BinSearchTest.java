package Serie3.exo5.Test;

import Serie3.exo5.BinSearch;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinSearchTest {

    @Test
    public void search() {
        double[] sortedList = {-4.2, -3.4, -0.1, 0, 2.4, 234.3, 2365.454};

        assert BinSearch.search(sortedList,1) == -1;
        assert BinSearch.search(sortedList, -4.2) == 0;
        assert BinSearch.search(sortedList, 2365.454) == 6;
        assert BinSearch.search(sortedList, 3000) == -1;
        assert BinSearch.search(sortedList, -5) == -1;
        assert BinSearch.search(sortedList, 0) == 3;
    }
}