package topcoder.tco.tco2018.round2a;

import static java.lang.Math.abs;

public class ArithmeticSequenceDiv1 {

    public int findMinCost(int[] x) {
        int result = Integer.MAX_VALUE, n = x.length;
        for (int first = -200; first <= 200; first++) {
            for (int d = -200; d <= 200; d++) {
                int current = 0;
                for (int i = 0; i < n; i++) {
                    int expected = first + i * d;
                    current += abs(x[i] - expected);
                }
                if (current < result) result = current;
            }
        }
        return result;
    }

}
