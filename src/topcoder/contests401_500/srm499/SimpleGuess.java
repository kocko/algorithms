package topcoder.contests401_500.srm499;

import static java.util.Arrays.sort;

public class SimpleGuess {

    public int getMaximum(int[] x) {
        int n = x.length;
        sort(x);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((x[j] * x[j] - x[i] * x[i]) % 4 == 0) {
                    max = Math.max(x[j] * x[j] - x[i] * x[i], max);
                }
            }
        }
        return max >> 2;
    }

}
