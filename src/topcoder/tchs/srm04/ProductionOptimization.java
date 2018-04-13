package topcoder.tchs.srm04;

import static java.lang.Math.min;

public class ProductionOptimization {

    public int getMost(int[] costs, int[] times, int cost, int time) {
        this.n = times.length;
        this.costs = costs;
        this.times = times;
        dp = new int[55][101][101];
        for (int i = 0; i < 55; i++) for (int j = 0; j < 101; j++) for (int k = 0; k < 101; k++) dp[i][j][k] = -1;

        return recurse(0, time, cost);
    }

    private int n;
    private int[] costs, times;
    private int[][][] dp;

    private int recurse(int idx, int time, int cost) {
        if (cost < costs[idx] || time < times[idx]) return 0;
        if (dp[idx][time][cost] != -1) return dp[idx][time][cost];
        if (idx == n - 1) {
            return min(time / times[n - 1], cost / costs[n - 1]);
        }

        int ans = 0;
        int v = cost - costs[idx];
        for (int i = 0; i <= v; i++) {
            int score = recurse(idx + 1, time - times[idx], i) + recurse(idx, time - times[idx], v - i);
            if (score >= ans) ans = score;
        }
        return dp[idx][time][cost] = ans;
    }

}
