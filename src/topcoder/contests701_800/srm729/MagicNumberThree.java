package topcoder.contests701_800.srm729;

public class MagicNumberThree {

    public int countSubsequences(String s) {
        n = s.length();
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = s.charAt(i) - '0';
        }
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return (recurse(0, 0) + MOD - 1) % MOD;
    }

    private int n, MOD = 1000000007;
    private int[] x;
    private int[][] dp;

    private int recurse(int idx, int rem) {
        if (idx == n) return (rem == 0 ? 1 : 0);

        if (dp[idx][rem] != -1) return dp[idx][rem];

        int ans = 0;

        ans += recurse(idx + 1, rem);
        if (ans >= MOD) ans %= MOD;

        ans += recurse(idx + 1, (rem + x[idx]) % 3);
        if (ans >= MOD) ans %= MOD;

        return dp[idx][rem] = ans;
    }

}
