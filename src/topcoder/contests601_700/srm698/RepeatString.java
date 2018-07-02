package topcoder.contests601_700.srm698;

import static java.lang.Math.min;

public class RepeatString {

    public int minimalModify(String s) {
        int result = 1000;
        for (int i = 0; i < s.length(); i++) {
            EditDistance editDistance = new EditDistance(s.substring(0, i), s.substring(i));
            result = min(result, editDistance.recurse(0, 0));
        }
        return result;
    }

    private class EditDistance {
        private EditDistance(String x, String y) {
            this.x = x.toCharArray();
            this.y = y.toCharArray();
            this.n = x.length();
            this.m = y.length();
            dp = new int[n][m];
            for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) dp[i][j] = -1;
        }

        private char[] x, y;
        private int n, m;
        private int[][] dp;

        private int recurse(int i, int j) {
            if (i == n) return m - j;
            if (j == m) return n - i;
            if (dp[i][j] != -1) return dp[i][j];

            int cost = x[i] == y[j] ? 0 : 1;

            return dp[i][j] = min(min(recurse(i, j + 1) + 1, recurse(i + 1, j) + 1), recurse(i + 1, j + 1) + cost);
        }
    }

}
