package topcoder.contests701_800.srm746;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PairProduct {

    public int[] findPair(int n, int a0, int step, long p) {
        long[] x = new long[n];
        TreeMap<Long, List<Integer>> map = new TreeMap<>();
        x[0] = a0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(x[0], list);
        for (int i = 1; i < n; i++) {
            x[i] = x[i - 1] + step;
            list = map.getOrDefault(x[i], new ArrayList<>());
            list.add(i);
            map.put(x[i], list);
        }
        if (p == 0) {
            for (int i = 0; i < n; i++) {
                if (x[i] == 0) {
                    return new int[]{i, i};
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (x[i] != 0 && p % x[i] == 0) {
                long need = p / x[i];
                if (map.containsKey(need)) {
                    list = map.get(need);
                    return new int[]{i, list.get(0)};
                }
            }
        }

        return new int[0];
    }

}

