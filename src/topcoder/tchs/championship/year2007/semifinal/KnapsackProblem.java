package topcoder.tchs.championship.year2007.semifinal;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.util.Collections.sort;

public class KnapsackProblem {

    public int numberOfWays(int[] x, int c) {
        int n = x.length, half = n / 2;
        List<Long> list = new ArrayList<>();

        int MAX = 1 << half;
        for (int mask = 0; mask < MAX; mask++) {
            long sum = 0;
            for (int i = 0; i < 30; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += x[i];
                }
            }
            list.add(sum);
        }
        sort(list);
        int rem = n - half;
        MAX = 1 << rem;
        int result = 0;
        for (int mask = 0; mask < MAX; mask++) {
            long sum = 0;
            for (int i = 0; i < 30; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += x[half + i];
                }
            }
            if (sum <= c) {
                long need = c - sum;
                int left = 0, right = list.size() - 1;
                int index = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid) <= need) {
                        left = mid + 1;
                        index = max(index, mid);
                    } else {
                        right = mid - 1;
                    }
                }
                if (index != -1) result += index + 1;
            }
        }
        return result;
    }
    
}
