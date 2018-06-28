package topcoder.tco.tco2018.round2a;

public class ThreeSameLetters {

    public int countStrings(int l, int s) {
        this.s = s;
        this.l = l;
        if (l < 3) return 0;
        if (l == 3) return s;
        if (s == 1) return 0;
        dp = new long[100][2][2];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        long result = s * recurse(1, 0, 0) % MOD;
        return (int) result;
    }

    private int s, l;
    private final long MOD = (int) (1e9 + 7);
    private long[][][] dp;

    private long recurse(int idx, int found, int lastTwoSame) {
        if (idx == l) return found;
        if (dp[idx][found][lastTwoSame] != -1) return (int) dp[idx][found][lastTwoSame];

        long ans = 0;
        if (found == 1) {
            if (lastTwoSame == 1) {
                ans += ((s - 1) * recurse(idx + 1, 1, 0)) % MOD;
            } else {
                ans += recurse(idx + 1, 1, 1) % MOD;
                ans += (s - 1) * recurse(idx + 1, 1, 0) % MOD;
            }
        } else {
            if (lastTwoSame == 1) {
                ans += recurse(idx + 1, 1, 1) % MOD;
                ans += (s - 1) * recurse(idx + 1, 0, 0) % MOD;
            } else {
                ans += recurse(idx + 1, 0, 1) % MOD;
                ans += (s - 1) * recurse(idx + 1, 0, 0) % MOD;
            }
        }
        ans %= MOD;
        dp[idx][found][lastTwoSame] = ans;
        return (int) ans;
    }

}
