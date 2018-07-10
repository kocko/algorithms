package topcoder.tchs.srm06;

import static java.lang.Math.min;

public class WildCardMatch {

    public int minimalChanges(String s, String t) {
        this.s = s.toCharArray();
        this.t = t.toCharArray();
        this.n = s.length();
        this.m = t.length();
        this.dp = new int[55][55];
        for (int i = 0; i < 55; i++) for (int j = 0; j < 55; j++) dp[i][j] = -1;
        return recurse(0, 0);
    }

    private int n, m;
    private char[] s, t;
    private int[][] dp;

    private int recurse(int i, int j) {
        if (i == n) return m - j;
        if (j == m) return n - i;
        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        if (s[i] == t[j]) {
            ans = min(ans, recurse(i + 1, j + 1));
        } else {
            //delete
            ans = min(ans, 1 + recurse(i + 1, j));
            ans = min(ans, 1 + recurse(i, j + 1));
            //modify
            ans = min(ans, 1 + recurse(i + 1, j + 1));
            if (t[j] == '?') {
                ans = min(ans, recurse(i + 1, j + 1));
            }
        }
        return dp[i][j] = ans;
    }
    
}
