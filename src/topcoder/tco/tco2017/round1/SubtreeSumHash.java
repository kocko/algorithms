package topcoder.tco.tco2017.round1;

import java.util.ArrayList;
import java.util.List;

public class SubtreeSumHash {

    private final int MOD = (int) 1e9 + 7;

    private long pow(long x, long p) {
        if (p == 0) return 1L;
        if (p == 1) return x % MOD;
        if ((p & 1) == 0) {
            long v = pow(x, p / 2);
            return v * v % MOD;
        }
        long v = pow(x, p / 2);
        return ((v * v % MOD) * x) % MOD;
    }

    private List<List<Integer>> graph;
    private int[] w;
    private long result;
    private int x;

    private long dfs(int u, int parent, int min) {
        long result = pow(x, w[u]);
        for (Integer next : graph.get(u)) {
            if (next > min && next != parent) {
                result *= (1 + dfs(next, u, min));
                result %= MOD;
            }
        }
        return result;
    }

    private int count(int[] weight, int[] p, int x) {
        int n = weight.length;
        this.w = weight;
        this.x = x;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i + 1).add(p[i]);
            graph.get(p[i]).add(i + 1);
        }
        for (int i = 0; i < n; i++) {
            result += dfs(i, -1, i);
        }

        return (int) (result % MOD);
    }

}
