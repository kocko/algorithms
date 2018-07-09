package topcoder.tchs.championship.year2007.semifinal;

import java.util.Arrays;

public class SortInsideNumber {

    public int sort(int x) {
        char[] value = String.valueOf(x).toCharArray();
        Arrays.sort(value);
        StringBuilder sb = new StringBuilder();
        for (char c : value) sb.append(c);
        return Integer.valueOf(sb.toString());
    }
    
}
