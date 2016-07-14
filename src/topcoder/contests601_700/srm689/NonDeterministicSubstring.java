package topcoder.contests601_700.srm689;

import java.util.HashSet;
import java.util.Set;

public class NonDeterministicSubstring {

    public long ways(String a, String b) {
        char[] x = a.toCharArray(); int n = x.length;
        char[] y = b.toCharArray(); int m = y.length;
        long result = 0;
        Set<String> used = new HashSet<>();
        for (int i = 0; i < n - m + 1; i++) {
            boolean ok = true;
            for (int j = 0; j < m; j++) {
                if (y[j] != '?' && x[i + j] != y[j]) {
                    ok = false; break;
                }
            }
            if (ok) {
                String temp = a.substring(i, i + m);
                if (!used.contains(temp)) {
                    used.add(temp);
                    result++;
                }
            }
        }
        return result;
    }

}
