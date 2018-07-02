package topcoder.contests601_700.srm698;

import static java.lang.Integer.max;

public class RepeatStringEasy {

    public int maximalLength(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            LongestCommonSubstring lcs = new LongestCommonSubstring(s.substring(0, i), s.substring(i));
            result = max(result, lcs.recurse(0, 0));
        }
        return result << 1;
    }

    private class LongestCommonSubstring {
        private LongestCommonSubstring(String x, String y) {
            this.x = x.toCharArray();
            this.y = y.toCharArray();
            n = x.length();
            m = y.length();
            dp = new int[n][m];
            for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) dp[i][j] = ~0;
        }

        private int n, m;
        private char[] x, y;
        private int[][] dp;

        private int recurse(int i, int j) {
            if (i == n || j == m) return 0;
            if (dp[i][j] != ~0) return dp[i][j];

            int ans;
            if (x[i] == y[j]) {
                ans = 1 + recurse(i + 1, j + 1);
            } else {
                ans = max(recurse(i, j + 1), recurse(i + 1, j));
            }
            return dp[i][j] = ans;
        }
    }
    
}
